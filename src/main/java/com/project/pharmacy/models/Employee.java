package com.project.pharmacy.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String cpf;

    @Column
    private LocalDate birthDate;

    @Column
    private String cellPhone;

    @Column
    private double wage;

    @Column
    private String office;

    @ManyToOne
    private Enterprise enterprise;

    @ManyToOne
    private Admin admin;
}
