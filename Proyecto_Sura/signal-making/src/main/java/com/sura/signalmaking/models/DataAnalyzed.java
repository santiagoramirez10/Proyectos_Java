package com.sura.signalmaking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="data_analyzed")
public class DataAnalyzed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="new_analyzed_id", referencedColumnName = "id")
    private News newAnalyzed;

    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "classifications", joinColumns = @JoinColumn(name = "data_analyzed_id"))
    @Column(name = "classification", nullable = false)
    private List<String> classification = new ArrayList<String>();

    @Column
    private String timeClassification;

    @Column
    private String summary;

    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "keywords_news", joinColumns = @JoinColumn(name = "data_analyzed_id"))
    @Column(name = "keyword", nullable = false)
    private List<String> keywords = new ArrayList<String>();

}
