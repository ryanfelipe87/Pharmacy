package com.project.pharmacy.services;

import com.project.pharmacy.dtos.SaleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaleService {

    SaleDTO createSale(SaleDTO saleDTO);

    List<SaleDTO> listAllSales();

    SaleDTO getSaleById(Long id);

    SaleDTO updateSale(Long id, SaleDTO saleDTO);

    void deleteSale(Long id);
}
