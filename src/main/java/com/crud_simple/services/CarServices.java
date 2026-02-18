package com.crud_simple.services;

import com.crud_simple.dto.CarRequestDto;
import com.crud_simple.dto.CarResponseDto;
import com.crud_simple.entities.Car;
import com.crud_simple.mapper.CarMapper;
import com.crud_simple.repositories.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarServices {
    private final CarRepository carRepository;
    private final CarMapper mapper;

    public CarServices(CarRepository repository, CarMapper mapper) {
        this.carRepository = repository;
        this.mapper = mapper;
    }

    public CarResponseDto save(CarRequestDto dto) {
        Car car = mapper.toEntity(dto);

        Car saved = carRepository.save(car);

        return mapper.toDto(saved);
    }
}
