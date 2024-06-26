package com.example.citymanager.model;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    private Long area;


    private Long population;


    private Long GDP;


    private String introduce;

    @ManyToOne
    private Country country;
}