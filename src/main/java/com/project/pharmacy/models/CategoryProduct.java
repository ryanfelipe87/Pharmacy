package com.project.pharmacy.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "category_product")
public class CategoryProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Integer amount;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
