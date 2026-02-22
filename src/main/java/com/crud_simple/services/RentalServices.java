package com.crud_simple.services;

import com.crud_simple.dto.RentalRequestDto;
import com.crud_simple.dto.RentalResponseDto;
import com.crud_simple.entities.Car;
import com.crud_simple.entities.Rental;
import com.crud_simple.mapper.RentalMapper;
import com.crud_simple.repositories.CarRepository;
import com.crud_simple.repositories.RentalRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class RentalServices {
    private RentalRepository rentalRepository;
    private CarRepository carRepository;
    private RentalMapper mapper;

    public RentalServices(RentalRepository rentalRepository, CarRepository carRepository, RentalMapper rentalMapper) {
        this.rentalRepository = rentalRepository;
        this.carRepository = carRepository;
        this.mapper = rentalMapper;
    }

    public RentalResponseDto save (RentalRequestDto dto) {
        UUID carUuid = UUID.fromString(dto.carId());

        // search if car exist
        Car car = carRepository.findById(carUuid)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        Rental rental = mapper.toEntity(dto, car);
        rental.setRentedAt(LocalDateTime.now());

        Rental saved = rentalRepository.save(rental);

        return mapper.toDto(saved);
    };
}
