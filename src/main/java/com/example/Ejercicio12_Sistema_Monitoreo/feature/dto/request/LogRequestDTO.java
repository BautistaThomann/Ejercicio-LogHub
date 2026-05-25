package com.example.Ejercicio12_Sistema_Monitoreo.feature.dto.request;

import com.example.Ejercicio12_Sistema_Monitoreo.feature.entity.LogLevel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LogRequestDTO {
    
    @NotBlank
    private String message;

    @NotNull
    private LogLevel logLevel;

    @NotNull
    private Long appId;
}
