package com.project.pharmacy.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SaleDTO {

    private LocalDate dateSale;
    private Double totalSale;
}
