package com.sura.signalmaking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="signals")
public class Signal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="associated_new_id", referencedColumnName = "id")
    News associatedNew;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="data_analyzed_id", referencedColumnName = "id")
    DataAnalyzed dataAnalyzed;

    @Column
    LocalDate updateDate;

}
