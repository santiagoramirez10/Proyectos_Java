package com.sura.signalmaking.dtos;

import com.sura.signalmaking.models.News;
import lombok.Data;

import java.util.Set;

@Data
public class DataAnalyzedDto {

    private News newAnalyzed;
    private Set<String> classification;
    private String timeClassification;
    private String summary;
    private Set<String> keywords;

}
