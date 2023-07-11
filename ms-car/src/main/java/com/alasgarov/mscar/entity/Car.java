package com.alasgarov.mscar.entity;


import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "car")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(mappedBy = "car", cascade = ALL, fetch = LAZY)
    private Driver driver;

    @ManyToOne(fetch = LAZY)
    private Owner owner;





}
