package com.project.pharmacy.controllers;

import com.project.pharmacy.dtos.SaleDTO;
import com.project.pharmacy.exceptions.sale.SaleGetByIdException;
import com.project.pharmacy.exceptions.sale.SaleUpdateByIdException;
import com.project.pharmacy.services.impl.SaleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/sale")
public class SaleController {

    @Autowired
    private SaleServiceImpl saleService;

    @PostMapping
    public ResponseEntity<Void> saveSale(@RequestBody SaleDTO saleDTO) {
        saleService.createSale(saleDTO);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public List<SaleDTO> listAllSales() {
        return saleService.listAllSales();
    }

    @GetMapping("/{id}")
    public String getSaleById(@PathVariable Long id) {
        try {
            SaleDTO saleDTO = saleService.getSaleById(id);
            return saleDTO.toString();
        } catch (SaleGetByIdException exception) {
            return exception.getMessage();
        }
    }

    @PutMapping("/{id}")
    public String updateSale(@PathVariable Long id, @RequestBody SaleDTO saleDTO) {
        try {
            SaleDTO saleDTO1 = saleService.updateSale(id, saleDTO);
            return saleDTO1.toString();
        } catch (SaleUpdateByIdException exception) {
            return exception.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    void deleteSale(@PathVariable Long id) {
        saleService.deleteSale(id);
    }
}
