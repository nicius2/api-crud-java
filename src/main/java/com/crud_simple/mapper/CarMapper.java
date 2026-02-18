package com.crud_simple.mapper;

import com.crud_simple.dto.CarRequestDto;
import com.crud_simple.dto.CarResponseDto;
import com.crud_simple.entities.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public Car toEntity(CarRequestDto dto) {
        return new Car(dto.nameCar(), dto.plate());
    }

    public CarResponseDto toDto(Car car) {
        return new CarResponseDto(
                car.getId(),
                car.getNameCar(),
                car.getPlate(),
                car.isAvailable()
        );
    }
}
