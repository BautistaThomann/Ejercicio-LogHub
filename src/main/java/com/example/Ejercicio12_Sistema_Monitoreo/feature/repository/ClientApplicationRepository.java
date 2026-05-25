package com.example.Ejercicio12_Sistema_Monitoreo.feature.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Ejercicio12_Sistema_Monitoreo.feature.entity.ClientApplication;

public interface ClientApplicationRepository extends JpaRepository<ClientApplication, Long> {
    Optional<ClientApplication> findByApiKey(String apiKey);
    boolean existsByApiKey(String apiKey);
    
} 
