package com.alasgarov.mscar.repository;

import com.alasgarov.mscar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
