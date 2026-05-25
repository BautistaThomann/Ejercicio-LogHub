package com.example.Ejercicio12_Sistema_Monitoreo.feature.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ejercicio12_Sistema_Monitoreo.feature.dto.request.ClientApplicationRequestDTO;
import com.example.Ejercicio12_Sistema_Monitoreo.feature.dto.response.ClientApplicationResponseDTO;
import com.example.Ejercicio12_Sistema_Monitoreo.feature.service.ClientApplicationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/applications")
@Tag(name = "Aplicaciones", description = "Gestión de aplicaciones cliente")
public class ClientApplicationController {

    private final ClientApplicationService service;

    public ClientApplicationController(ClientApplicationService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Registrar aplicación")
    @ApiResponse(responseCode = "200", description = "Aplicación creada")
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
    public ClientApplicationResponseDTO create(
            @RequestBody @Valid ClientApplicationRequestDTO dto) {

        return service.create(dto);
    }
}
