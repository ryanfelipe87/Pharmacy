package com.project.pharmacy.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Double price;

    @Column
    private LocalDate validity;

    @ManyToMany(mappedBy = "products")
    private List<Purchase> purchases;

    @ManyToMany(mappedBy = "products")
    private List<Sale> sales;

    @OneToOne(mappedBy = "product")
    private CategoryProduct categoryProduct;

}
