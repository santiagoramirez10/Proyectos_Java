package com.sura.signalmaking.dtos;

import lombok.Data;

@Data
public class Articles {

    SourceDto source;
    String author;
    String title;
    String description;
    String url;
    String urlToImage;
    String content;

}
