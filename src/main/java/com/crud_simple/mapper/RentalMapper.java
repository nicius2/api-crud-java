package com.crud_simple.mapper;

import com.crud_simple.dto.RentalRequestDto;
import com.crud_simple.dto.RentalResponseDto;
import com.crud_simple.entities.Car;
import com.crud_simple.entities.Rental;
import org.springframework.stereotype.Component;

@Component
public class RentalMapper {

    public Rental toEntity(RentalRequestDto dto, Car car) {
        Rental rental = new Rental();
        rental.setCar(car);
        rental.setRentedAt(dto.rentedAt());
        return rental;
    }

    public RentalResponseDto toDto(Rental rental) {
        return new RentalResponseDto(
                rental.getId(),
                rental.getCar().getNameCar(),
                rental.getCar().getPlate(),
                rental.getRentedAt(),
                rental.getReturnedAt()
        );
    }
}
