package com.sura.signalmaking.services;


import org.jsoup.nodes.Document;

public interface WebScraperService {
    Document scrapeDataFromUrl (String url);
}
