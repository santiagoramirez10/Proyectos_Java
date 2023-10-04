package com.sura.signalmaking.models;

import com.sura.signalmaking.dtos.SourceDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String tags;
    private String idSource;
    private String nameSource;
    private String author;
    private String description;
    private String url;
    private String urlToImage;
    private String content;

}
