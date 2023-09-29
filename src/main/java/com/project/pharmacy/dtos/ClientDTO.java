package com.project.pharmacy.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientDTO {

    private String name;
    private String cpf;
    private String cellPhone;
    private LocalDate birthDate;
    private String zipCode;
    private String address;
}
