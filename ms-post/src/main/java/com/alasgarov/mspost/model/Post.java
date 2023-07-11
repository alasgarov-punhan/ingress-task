package com.alasgarov.mspost.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String body;
    private Long userId;
    @CreationTimestamp
    private LocalDate createdDate;
    @UpdateTimestamp
    private LocalDate updateDate;
}
