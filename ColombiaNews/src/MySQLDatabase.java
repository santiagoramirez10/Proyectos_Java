import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLDatabase {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/noticiasdb"; // Cambiar por la URL de tu base de datos
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static void main(String[] args) {
        String country = "co"; // Código de país para Colombia
        String apiKey = "TU_API";
        String apiUrl = "https://newsapi.org/v2/top-headlines?country=" + country + "&apiKey=" + apiKey;
        try {
            String response = sendHttpRequest(apiUrl);
            saveDataToDatabase(response);
            System.out.println("Noticias guardadas en la base de datos.");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static String sendHttpRequest(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        StringBuilder response = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
        } finally {
            conn.disconnect();
        }

        return response.toString();
    }

// ...

    public static void saveDataToDatabase(String jsonData) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            createTable(conn);

            int startIndex = jsonData.indexOf("\"articles\":[");
            int endIndex = jsonData.lastIndexOf("]}");
            if (startIndex != -1 && endIndex != -1) {
                String articlesData = jsonData.substring(startIndex + 12, endIndex + 1);
                String[] articles = articlesData.split("\\},\\{");

                String insertQuery = "INSERT INTO noticias (title, author) VALUES (?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
                    for (String article : articles) {
                        String title = extractField(article, "title");
                        String author = extractField(article, "author");
                        pstmt.setString(1, title);
                        pstmt.setString(2, author);
                        pstmt.executeUpdate();
                    }
                }
            }
        }
    }

// ...


    private static void createTable(Connection conn) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS noticias (id INT AUTO_INCREMENT PRIMARY KEY, title TEXT, author TEXT)";
        try (PreparedStatement pstmt = conn.prepareStatement(createTableQuery)) {
            pstmt.executeUpdate();
        }
    }

    private static String extractField(String article, String field) {
        int startIndex = article.indexOf("\"" + field + "\":\"");
        if (startIndex != -1) {
            int endIndex = article.indexOf("\"", startIndex + field.length() + 4);
            if (endIndex != -1) {
                return article.substring(startIndex + field.length() + 4, endIndex);
            }
        }
        return "";
    }

}
