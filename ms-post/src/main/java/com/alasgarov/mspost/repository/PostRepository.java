package com.alasgarov.mspost.repository;


import com.alasgarov.mspost.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
