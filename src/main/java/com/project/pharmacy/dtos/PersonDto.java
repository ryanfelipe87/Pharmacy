package com.project.pharmacy.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PersonDto {

    private String name;
    private String gender;
    private String cpf;
    private String department;
    private String cellPhone;
    private String certification;
    private Double wage;
    private String office;
    private String nickname;
    private String email;
    private String password;
    private String confirmPassword;
    private LocalDateTime dateRegister;
}
