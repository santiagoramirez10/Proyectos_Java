import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class NewsAPIClient {
    private static final String API_KEY = "TU_API";
    public static void main(String[] args) {
        String country = "co"; // Código de país para Colombia
        String apiKey = API_KEY;
        String apiUrl = "https://newsapi.org/v2/top-headlines?country=" + country + "&apiKey=" + apiKey;
        try {
            String response = sendHttpRequest(apiUrl);
            // Cargar los datos existentes del archivo JSON
            String filePath = "noticias_colombia.json";
            String existingData = loadExistingData(filePath);
            // Combinar los datos existentes con los nuevos datos
            String combinedData = combineData(existingData, response);
            // Guardar el contenido completo en el archivo JSON
            saveDataToFile(filePath, combinedData);
            System.out.println("Noticias guardadas en el archivo: " + filePath);
        } catch (IOException e) {
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
    private static String loadExistingData(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            return content.toString();
        } catch (FileNotFoundException e) {
            // Si el archivo no existe, devolveremos una cadena vacía
            return "";
        }
    }
    private static String combineData(String existingData, String newData) {
        // Verifica si hay datos existentes en el archivo
        if (existingData.trim().isEmpty()) {
            return newData;
        }
        // Combinar los datos existentes con los nuevos datos (agregar una coma entre ellos para que sea un JSON válido)
        return existingData.substring(0, existingData.length() - 1) + "," + newData.substring(1);
    }
    private static void saveDataToFile(String filePath, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        }
    }
}