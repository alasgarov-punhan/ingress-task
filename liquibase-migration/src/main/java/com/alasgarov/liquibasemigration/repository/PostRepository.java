package com.alasgarov.liquibasemigration.repository;


import com.alasgarov.liquibasemigration.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
