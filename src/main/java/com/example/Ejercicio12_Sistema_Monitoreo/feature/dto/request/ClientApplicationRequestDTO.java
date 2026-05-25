package com.example.Ejercicio12_Sistema_Monitoreo.feature.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClientApplicationRequestDTO {
    
    @NotBlank
    private String name;

    private String description;

    @Email
    private String email;
}
