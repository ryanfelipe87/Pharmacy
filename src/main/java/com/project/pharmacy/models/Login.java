package com.project.pharmacy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Entity
@Table(name = "login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nickname;

    @Column
    @Email
    private String email;

    @Column
    private String password;

    private String confirmPassword;

    @OneToOne
    private Person person;
}
