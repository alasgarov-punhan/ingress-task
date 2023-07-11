package com.alasgarov.mscar.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name = "owner")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "owner", cascade = ALL)
    private List<Car> cars;



}
