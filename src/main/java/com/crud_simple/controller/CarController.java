package com.crud_simple.controller;

import com.crud_simple.api.ApiResponse;
import com.crud_simple.dto.CarRequestDto;
import com.crud_simple.dto.CarResponseDto;
import com.crud_simple.dto.UpdateCarAvailableDto;
import com.crud_simple.services.CarServices;
import jakarta.persistence.PostUpdate;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

        ApiResponse<CarResponseDto> response =
                new ApiResponse<>(true, "Car created successfully", saved);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saved);
    }

    @GetMapping
    public ResponseEntity<List<CarResponseDto>> findAll() {
        return ResponseEntity.ok(carServices.findAll());
    }

    @GetMapping("/{plate}")
    public ResponseEntity<CarResponseDto> findByPlate(@PathVariable String plate) {
        CarResponseDto dto = carServices.findByPlate(plate);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("{id}/available")
    public ResponseEntity<CarResponseDto> updateAvailable(@PathVariable UUID id,@RequestBody UpdateCarAvailableDto dto) {
        return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED).body(carServices.updateAvailableCar(id, dto.available()));
    }

}
