package com.sura.signalmaking.services;

import com.sura.signalmaking.models.News;

import java.util.Collection;
import java.util.List;

public interface NewsService{

    List<News> getNews();

    List<News> getNewsByTag(String keyWord);

}
