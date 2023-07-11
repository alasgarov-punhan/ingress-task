package com.alasgarov.mscar.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "driver")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int experience;

    @OneToOne(fetch = LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private Car car;

}
