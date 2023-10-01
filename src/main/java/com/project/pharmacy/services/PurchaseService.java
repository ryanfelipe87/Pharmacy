package com.project.pharmacy.services;

import com.project.pharmacy.dtos.PurchaseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PurchaseService {

    PurchaseDTO createPurchase(PurchaseDTO purchaseDTO);

    List<PurchaseDTO> listAllPurchases();

    PurchaseDTO getPurchaseById(Long id);

    PurchaseDTO updatePurchase(Long id, PurchaseDTO purchaseDTO);

    void deletePurchase(Long id);
}
