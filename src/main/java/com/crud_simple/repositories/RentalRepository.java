package com.crud_simple.repositories;

import com.crud_simple.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, String> {
}
