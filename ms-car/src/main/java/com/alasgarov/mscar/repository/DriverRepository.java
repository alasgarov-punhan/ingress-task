package com.alasgarov.mscar.repository;

import com.alasgarov.mscar.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
