package com.crud_simple.dto;

import java.util.UUID;

public record CarResponseDto(
        UUID id,
        String nameCar,
        String plate,
        boolean available
) {
}
