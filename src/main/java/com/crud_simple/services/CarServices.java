package com.crud_simple.services;

import com.crud_simple.dto.CarRequestDto;
import com.crud_simple.dto.CarResponseDto;
import com.crud_simple.entities.Car;
import com.crud_simple.mapper.CarMapper;
import com.crud_simple.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServices {
    private final CarRepository carRepository;
    private final CarMapper mapper;

    public CarServices(CarRepository repository, CarMapper mapper) {
        this.carRepository = repository;
        this.mapper = mapper;
    }

    public CarResponseDto save(CarRequestDto dto) {

        if (carRepository.findByPlate(dto.plate()).isPresent()) {
            throw new RuntimeException("Plate already exists");
        }

        Car car = mapper.toEntity(dto);

        Car saved = carRepository.save(car);

        return mapper.toDto(saved);
    }

    public List<CarResponseDto> findAll() {
        List<Car> cars = carRepository.findAll();

        return cars.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }


    // Searching for a car by its license plate.
    public CarResponseDto findByPlate(String plate) {
        Car car = carRepository.findByPlate(plate)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        return mapper.toDto(car);
    }
}
