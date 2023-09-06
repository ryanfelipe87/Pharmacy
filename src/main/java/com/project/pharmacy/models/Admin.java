package com.project.pharmacy.models;

import jakarta.persistence.*;
import lombok.Data;

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
}