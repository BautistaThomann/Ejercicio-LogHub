package com.example.Ejercicio12_Sistema_Monitoreo.feature.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Ejercicio12_Sistema_Monitoreo.feature.entity.Log;

public interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findByApplicationId(Long appId);
    
    List<Log> findByTimestampBetween(
            LocalDateTime from,
            LocalDateTime to);
}
