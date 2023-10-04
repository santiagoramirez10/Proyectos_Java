package com.sura.signalmaking.repositories;

import com.sura.signalmaking.models.Signal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignalRepository extends JpaRepository<Signal, Long> {
}
