package com.project.pharmacy.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "enterprise")
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String cnpj;

    @Column
    private String number;

    @Column
    private String address;

    @Column
    private String neighborhood;

    @Column
    private String cep;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "enterprise")
    private List<Employee> employees;

    @OneToMany(mappedBy = "enterprise")
    private List<Product> products;
}
