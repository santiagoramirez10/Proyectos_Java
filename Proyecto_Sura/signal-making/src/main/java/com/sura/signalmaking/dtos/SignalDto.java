package com.sura.signalmaking.dtos;

import com.sura.signalmaking.models.DataAnalyzed;
import com.sura.signalmaking.models.News;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SignalDto {
    News associatedNews;
    DataAnalyzed dataAnalyzed;
    LocalDate updateDate;
}
