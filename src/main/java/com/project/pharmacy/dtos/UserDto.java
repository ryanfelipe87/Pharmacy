package com.project.pharmacy.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {

    private String name;
    private String gender;
    private String cpf;
    private String department;
    private String cellPhone;
    private String nickname;
    private String email;
    private String password;
    private LocalDateTime dateRegister;
}
