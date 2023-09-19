package com.project.pharmacy.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String cpf;

    @Column
    private String cellPhone;

    @Column
    private LocalDate birthDate;

    @Column
    private String zipCode;

    @Column
    private String address;

    @OneToMany(mappedBy = "client")
    private List<Purchase> purchases;

    @OneToMany(mappedBy = "client")
    private List<Sale> sales;
}
