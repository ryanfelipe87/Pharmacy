package com.project.pharmacy.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {

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
    private LocalDateTime dateRegister;

    @OneToOne(mappedBy = "user")
    private Enterprise enterprise;

    @OneToOne
    private Login login;

    @OneToMany(mappedBy = "user")
    private List<Employee> employees;
}