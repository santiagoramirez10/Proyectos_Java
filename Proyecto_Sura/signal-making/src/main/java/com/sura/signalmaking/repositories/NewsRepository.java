package com.sura.signalmaking.repositories;

import com.sura.signalmaking.models.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {

    List<News> findByTitleContains(String tag);

}
