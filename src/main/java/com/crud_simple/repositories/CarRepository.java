package com.crud_simple.repositories;

import com.crud_simple.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, String> {
}
