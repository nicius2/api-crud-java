package com.crud_simple.dto;

import jakarta.validation.constraints.NotBlank;

public record CarRequestDto(

        @NotBlank(message = "Nome do carro é obrigatório")
        String nameCar,

        @NotBlank(message = "Placa é obrigatória")
        String plate
)
{}
