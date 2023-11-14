package com.project.pharmacy.controllers;

import com.project.pharmacy.dtos.PurchaseDTO;
import com.project.pharmacy.exceptions.purchase.PurchaseGetByIdException;
import com.project.pharmacy.exceptions.purchase.PurchaseUpdateByIdException;
import com.project.pharmacy.services.impl.PurchaseServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/purchase")
@Tag(name = "Purchase")
public class PurchaseController {

    @Autowired
    private PurchaseServiceImpl purchaseService;

    @PostMapping
    @Operation(
            summary = "Controller for purchase of a pharmacy",
            description = "Endpoint for create a new purchase")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public ResponseEntity<Void> savePurchase(@RequestBody PurchaseDTO purchaseDTO) {
        purchaseService.createPurchase(purchaseDTO);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @GetMapping
    @Operation(
            summary = "Controller for purchase of a pharmacy",
            description = "Endpoint for search all purchases")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public List<PurchaseDTO> findAll() {
        return purchaseService.listAllPurchases();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Controller for purchase of a pharmacy",
            description = "Endpoint for search purchase for id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public String getPurchaseById(@PathVariable Long id) {
        try {
            PurchaseDTO purchaseDTO = purchaseService.getPurchaseById(id);
            return purchaseDTO.toString();
        } catch (PurchaseGetByIdException exception) {
            return exception.getMessage();
        }
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Controller for purchase of a pharmacy",
            description = "Endpoint for update a product for id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public String updatePurchase(@PathVariable Long id, @RequestBody PurchaseDTO purchaseDTO) {
        try {
            PurchaseDTO purchaseDTO1 = purchaseService.updatePurchase(id, purchaseDTO);
            return purchaseDTO1.toString();
        } catch (PurchaseUpdateByIdException exception) {
            return exception.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Controller for purchase of a pharmacy",
            description = "Endpoint for delete a purchase for id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    void deletePurchase(@PathVariable Long id) {
        purchaseService.deletePurchase(id);
    }
}
