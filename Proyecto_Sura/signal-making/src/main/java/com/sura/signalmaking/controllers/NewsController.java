package com.sura.signalmaking.controllers;

import com.sura.signalmaking.models.News;
import com.sura.signalmaking.services.NewsService;
import com.sura.signalmaking.services.NewsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping
    public ResponseEntity<List<News>> getNews(){
        return ResponseEntity.status(HttpStatus.OK).body(newsService.getNews());
    }

    @GetMapping("/key-word")
    public ResponseEntity<List<News>> getNewsByTag(@RequestParam String keyWord){
        return ResponseEntity.status(HttpStatus.OK).body(newsService.getNewsByTag(keyWord));
    }

}
