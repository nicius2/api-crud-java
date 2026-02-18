package com.crud_simple.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nameCar;

    @Column(nullable = false, unique = true)
    private String plate;

    @Column(nullable = false)
    private boolean available = true;

    public Car(String nameCar, String plate) {
        this.nameCar = nameCar;
        this.plate = plate;
    }
}
