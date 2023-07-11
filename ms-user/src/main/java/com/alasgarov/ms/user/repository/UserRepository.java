package com.alasgarov.ms.user.repository;

import com.alasgarov.ms.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {



}
