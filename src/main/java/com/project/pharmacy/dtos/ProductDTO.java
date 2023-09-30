package com.project.pharmacy.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductDTO {

    private String name;
    private String description;
    private Double price;
    private LocalDate validity;
}
