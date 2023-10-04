package com.sura.signalmaking.controllers;

import com.sura.signalmaking.dtos.NewsDto;
import com.sura.signalmaking.services.WebScraperService;
import com.sura.signalmaking.services.WebScraperServiceImpl;
import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web-scraper")
@RequiredArgsConstructor
public class WebScraperController {

    private final WebScraperService webScraper;

    @PostMapping("/elTiempo")
    private ResponseEntity<String> getDocument(@RequestBody NewsDto newsDto){
        Document responseWebScraper = webScraper.scrapeDataFromUrl(newsDto.getUrlNew());
        return ResponseEntity.status(HttpStatus.OK).body("Response :" + responseWebScraper);
    }
}
