package com.project.pharmacy.controllers;

import com.project.pharmacy.dtos.PurchaseDTO;
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
    public ResponseEntity<Void> savePurchase(@RequestBody PurchaseDTO purchaseDTO){
        purchaseService.createPurchase(purchaseDTO);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public List<PurchaseDTO> findAll(){
        return purchaseService.listAllPurchases();
    }

    @GetMapping("/{id}")
    public PurchaseDTO getPurchaseById(@PathVariable Long id){
        return purchaseService.getPurchaseById(id);
    }

    @PutMapping("/{id}")
    public PurchaseDTO updatePurchase(@PathVariable Long id, @RequestBody PurchaseDTO purchaseDTO){
        return purchaseService.updatePurchase(id, purchaseDTO);
    }

    @DeleteMapping("/{id}")
    void deletePurchase(@PathVariable Long id){
        purchaseService.deletePurchase(id);
    }
}
