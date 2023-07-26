package com.alasgarov.mscar.repository;

import com.alasgarov.mscar.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
