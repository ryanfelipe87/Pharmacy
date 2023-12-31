package com.project.pharmacy.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "enterprise")
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String cnpj;

    @Column
    private String numberEnterprise;

    @Column
    private String address;

    @Column
    private String neighborhood;

    @Column
    private String cep;

    @OneToOne
    private Person person;

}
