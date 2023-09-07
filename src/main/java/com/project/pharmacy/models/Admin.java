package com.project.pharmacy.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "administrator")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String cpf;

    @Column
    private String departament;

    @Column
    private String cellPhone;

    @OneToOne
    private Enterprise enterprise;

    @OneToOne
    private Login login;

    @OneToMany(mappedBy = "emplyee")
    private List<Employee> employees;
}