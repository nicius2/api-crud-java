package com.crud_simple.controller;

import com.crud_simple.dto.RentalRequestDto;
import com.crud_simple.dto.RentalResponseDto;
import com.crud_simple.services.RentalServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/rentals")
public class RentalController {
    private final RentalServices rentalServices;


    public RentalController(RentalServices rentalServices) {
        this.rentalServices = rentalServices;
    }

    @PostMapping
    public ResponseEntity<RentalResponseDto> save(@RequestBody @Valid RentalRequestDto dto) {
        RentalResponseDto rental = rentalServices.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(rental);
    }
}
