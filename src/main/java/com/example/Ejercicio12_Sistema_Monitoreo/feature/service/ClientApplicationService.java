package com.example.Ejercicio12_Sistema_Monitoreo.feature.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.Ejercicio12_Sistema_Monitoreo.feature.dto.request.ClientApplicationRequestDTO;
import com.example.Ejercicio12_Sistema_Monitoreo.feature.dto.response.ClientApplicationResponseDTO;
import com.example.Ejercicio12_Sistema_Monitoreo.feature.entity.ClientApplication;
import com.example.Ejercicio12_Sistema_Monitoreo.feature.repository.ClientApplicationRepository;


@Service
public class ClientApplicationService {
    
    private final ClientApplicationRepository repository;

    public ClientApplicationService(ClientApplicationRepository repository) {
        this.repository = repository;
    }

    public ClientApplicationResponseDTO create(ClientApplicationRequestDTO dto) {

        ClientApplication app = new ClientApplication();

        app.setName(dto.getName());
        app.setDescription(dto.getDescription());
        app.setEmail(dto.getEmail());

        app.setApiKey(UUID.randomUUID().toString());

        repository.save(app);

        ClientApplicationResponseDTO response = new ClientApplicationResponseDTO();

        response.setId(app.getId());
        response.setName(app.getName());
        response.setApiKey(app.getApiKey());

        return response;
    }
}