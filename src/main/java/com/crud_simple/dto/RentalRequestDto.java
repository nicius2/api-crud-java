package com.crud_simple.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;


public record RentalRequestDto(

        @NotBlank(message = "Selecione o ID do Carro")
        String cardId,

        LocalDateTime rentedAt
) {
}
