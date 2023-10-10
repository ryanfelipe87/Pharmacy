package com.project.pharmacy.services.impl;

import com.project.pharmacy.dtos.PurchaseDTO;
import com.project.pharmacy.exceptions.purchase.PurchaseGetByIdException;
import com.project.pharmacy.exceptions.purchase.PurchaseUpdateByIdException;
import com.project.pharmacy.models.Purchase;
import com.project.pharmacy.repositories.PurchaseRepository;
import com.project.pharmacy.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;


    @Override
    public PurchaseDTO createPurchase(PurchaseDTO purchaseDTO) {
        Purchase purchase = new Purchase();
        purchase.setDatePurchase(purchaseDTO.getDatePurchase());
        purchase.setTotalPurchase(purchaseDTO.getTotalPurchase());

        purchase = purchaseRepository.save(purchase);

        return convertoToDTO(purchase);
    }

    @Override
    public List<PurchaseDTO> listAllPurchases() {
        List<Purchase> purchases = purchaseRepository.findAll();
        return purchases.stream()
                .map(this::convertoToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PurchaseDTO getPurchaseById(Long id) {
        Purchase purchase = purchaseRepository.findById(id).orElse(null);
        if (purchase != null) {
            return convertoToDTO(purchase);
        }
        throw new PurchaseGetByIdException("Purchase with ID " + id + " not found.");
    }

    @Override
    public PurchaseDTO updatePurchase(Long id, PurchaseDTO purchaseDTO) {
        Optional<Purchase> purchaseOptional = purchaseRepository.findById(id);
        if (purchaseOptional.isPresent()) {
            Purchase purchase = purchaseOptional.get();
            purchase.setDatePurchase(purchaseDTO.getDatePurchase());
            purchase.setTotalPurchase(purchaseDTO.getTotalPurchase());

            purchase = purchaseRepository.save(purchase);

            return convertoToDTO(purchase);
        }
        throw new PurchaseUpdateByIdException("Update not realized, because ID " + id + " not found.");
    }

    @Override
    public void deletePurchase(Long id) {
        purchaseRepository.deleteById(id);
    }

    public PurchaseDTO convertoToDTO(Purchase purchase) {
        PurchaseDTO purchaseDTO = new PurchaseDTO();
        purchaseDTO.setDatePurchase(purchase.getDatePurchase());
        purchaseDTO.setTotalPurchase(purchase.getTotalPurchase());
        return purchaseDTO;
    }
}
