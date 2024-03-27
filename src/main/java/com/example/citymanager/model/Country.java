package com.example.citymanager.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}