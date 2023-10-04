package com.sura.signalmaking.services;

import com.sura.signalmaking.dtos.Articles;
import com.sura.signalmaking.dtos.NewsApiDto;
import com.sura.signalmaking.models.News;
import com.sura.signalmaking.repositories.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class NewsServiceImpl implements NewsService {


    private static final String API_KEY = "55fd2f7208e445d4927d7b5f004693f0";
    private static final List<String> KEY_WORDS = Arrays.asList("YouTube", "WFLA","Google News","Elecciones","Colombia");

    @Autowired
    private  RestTemplate restTemplate;

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> getNews(){
        String country = "co"; // Código de país para Colombia
        String apiKey = API_KEY;
        String apiUrl = "https://newsapi.org/v2/top-headlines?country=" + country + "&apiKey=" + apiKey;
        try {
            NewsApiDto response = sendHttpRequest(apiUrl);
            for (Articles articulo : response.getArticles()) {
            log.info(articulo.getSource().getName());
            }
            List<Articles> articlesList =
                    response.getArticles().stream().filter(article -> KEY_WORDS.stream().anyMatch(k -> article.getTitle().contains(k)))
                            .collect(Collectors.toList());

            List<News> newsList = new ArrayList<>();
            for(Articles article : articlesList){
                News newBD = new News();
                newBD.setAuthor(article.getAuthor());
                newBD.setDescription(article.getDescription());
                newBD.setIdSource(article.getSource().getId());
                newBD.setTitle(article.getTitle());
                newBD.setTags(article.getSource().getName());
                newBD.setNameSource(article.getSource().getName());
                newBD.setContent(article.getContent());
                newBD.setUrlToImage(article.getUrlToImage());
                newBD.setUrl(article.getUrl());
                newsList.add(newBD);
            }
            newsRepository.saveAll(newsList);
            return newsList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<News> getNewsByTag(String keyWord) {
        List<News> newsByTag = newsRepository.findByTitleContains(keyWord);
        return newsByTag;
    }

    private  NewsApiDto sendHttpRequest(String apiUrl) throws IOException {
        ResponseEntity<NewsApiDto> response = restTemplate.getForEntity(apiUrl, NewsApiDto.class);
        /*URL url = new URL(apiUrl);
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

        return response.toString();*/
        return response.getBody();
    }

    /*private static String loadExistingData(String filePath) throws IOException {
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
    }*/
    private static String combineData(String existingData, String newData) {
        // Verifica si hay datos existentes en el archivo
        if (existingData.trim().isEmpty()) {
            return newData;
        }
        // Combinar los datos existentes con los nuevos datos (agregar una coma entre ellos para que sea un JSON válido)
        return existingData.substring(0, existingData.length() - 1) + "," + newData.substring(1);
    }
}
