package com.example.Ejercicio12_Sistema_Monitoreo.feature.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ejercicio12_Sistema_Monitoreo.feature.dto.request.LogRequestDTO;
import com.example.Ejercicio12_Sistema_Monitoreo.feature.entity.Log;
import com.example.Ejercicio12_Sistema_Monitoreo.feature.service.LogService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/logs")
@Tag(name = "Logs", description = "Gestión de logs")
public class LogController {

    private final LogService service;

    public LogController(LogService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Registrar log")
    @ApiResponse(responseCode = "200", description = "Log registrado")
    @ApiResponse(responseCode = "401", description = "API KEY inválida")
    public void create(@RequestBody @Valid LogRequestDTO dto) {

        service.create(dto);
    }

    @GetMapping
    @Operation(summary = "Listar logs")
    public List<Log> getAll() {

        return service.getAll();
    }

    @GetMapping("/app/{appId}")
    @Operation(summary = "Buscar logs por aplicación")
    public List<Log> getByAppId(
            @PathVariable Long appId) {

        return service.getByAppId(appId);
    }

    @GetMapping("/dates")
    @Operation(summary = "Buscar logs por rango de fechas")
    public List<Log> getByDates(
            @RequestParam LocalDateTime from,
            @RequestParam LocalDateTime to) {

        return service.getByDates(from, to);
    }
}
