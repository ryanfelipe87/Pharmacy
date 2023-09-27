package com.project.pharmacy.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String gender;

    @Column
    private String cpf;

    @Column
    private String department;

    @Column
    private String cellPhone;

    @Column
    private Double wage;

    @Column
    private String office;

    @Column
    private String certification;

    @Column
    private LocalDateTime dateRegister;

    @OneToMany(mappedBy = "person")
    private List<Purchase> purchaseList;

    @OneToMany(mappedBy = "person")
    private List<Sale> saleList;

    @OneToOne
    @JoinColumn(name = "login_id")
    private Login login;

    @OneToOne(mappedBy = "person")
    private Enterprise enterprise;

}