package com.crud_simple.dto;

public record RentalResponseDto(
        String id,
        String nameCar,
        String plate,
        java.time.LocalDateTime rendedAt,
        java.time.LocalDateTime returnedAt
) {
}
