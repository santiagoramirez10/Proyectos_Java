package com.sura.signalmaking.services;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class WebScraperServiceImpl implements WebScraperService {

    @Override
    public Document scrapeDataFromUrl(String url) {
        log.info("Fetching " + url);
        Document responseDocument = null;
        try{
            responseDocument = Jsoup.connect(url).get();
        }catch (Exception e ){
            e.printStackTrace();
        }
        System.out.println(responseDocument);
        return  responseDocument;
    }

}
