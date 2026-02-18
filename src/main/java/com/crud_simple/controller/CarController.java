package com.crud_simple.controller;

import com.crud_simple.dto.CarRequestDto;
import com.crud_simple.dto.CarResponseDto;
import com.crud_simple.services.CarServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/cars")
public class CarController {

    private final CarServices carServices;

    public CarController(CarServices services) {
        this.carServices = services;
    }

    @PostMapping()
    public ResponseEntity<CarResponseDto> create(@RequestBody @Valid CarRequestDto dto) {
        CarResponseDto saved = carServices.save(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saved);
    }
}
