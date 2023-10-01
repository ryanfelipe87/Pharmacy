package com.project.pharmacy.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PurchaseDTO {

    private LocalDate datePurchase;
    private Double totalPurchase;
}
