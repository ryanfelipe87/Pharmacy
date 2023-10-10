package com.project.pharmacy.controllers;

import com.project.pharmacy.dtos.PurchaseDTO;
import com.project.pharmacy.exceptions.purchase.PurchaseGetByIdException;
import com.project.pharmacy.exceptions.purchase.PurchaseUpdateByIdException;
import com.project.pharmacy.services.impl.PurchaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseServiceImpl purchaseService;

    @PostMapping
    public ResponseEntity<Void> savePurchase(@RequestBody PurchaseDTO purchaseDTO) {
        purchaseService.createPurchase(purchaseDTO);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public List<PurchaseDTO> findAll() {
        return purchaseService.listAllPurchases();
    }

    @GetMapping("/{id}")
    public String getPurchaseById(@PathVariable Long id) {
        try {
            PurchaseDTO purchaseDTO = purchaseService.getPurchaseById(id);
            return purchaseDTO.toString();
        } catch (PurchaseGetByIdException exception) {
            return exception.getMessage();
        }
    }

    @PutMapping("/{id}")
    public String updatePurchase(@PathVariable Long id, @RequestBody PurchaseDTO purchaseDTO) {
        try {
            PurchaseDTO purchaseDTO1 = purchaseService.updatePurchase(id, purchaseDTO);
            return purchaseDTO1.toString();
        } catch (PurchaseUpdateByIdException exception) {
            return exception.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    void deletePurchase(@PathVariable Long id) {
        purchaseService.deletePurchase(id);
    }
}
