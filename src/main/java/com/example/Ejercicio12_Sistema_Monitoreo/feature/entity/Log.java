package com.example.Ejercicio12_Sistema_Monitoreo.feature.entity;

import java.time.LocalDateTime;

import com.example.Ejercicio12_Sistema_Monitoreo.feature.entity.LogLevel;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Log {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @Enumerated(EnumType.STRING)
    private LogLevel logLevel;

    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private ClientApplication application;
}
