package com.project.pharmacy.controllers;

import com.project.pharmacy.dtos.SaleDTO;
import com.project.pharmacy.exceptions.sale.SaleGetByIdException;
import com.project.pharmacy.exceptions.sale.SaleUpdateByIdException;
import com.project.pharmacy.services.impl.SaleServiceImpl;
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
@RequestMapping(path = "/api/sale")
@Tag(name = "Sale")
public class SaleController {

    @Autowired
    private SaleServiceImpl saleService;

    @PostMapping
    @Operation(
            summary = "Controller for sales of a pharmacy",
            description = "Endpoint for create a new sale")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public ResponseEntity<Void> saveSale(@RequestBody SaleDTO saleDTO) {
        saleService.createSale(saleDTO);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @GetMapping
    @Operation(
            summary = "Controller for sales of a pharmacy",
            description = "Endpoint for search all sales")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public List<SaleDTO> listAllSales() {
        return saleService.listAllSales();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Controller for sales of a pharmacy",
            description = "Endpoint for search sale for id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public String getSaleById(@PathVariable Long id) {
        try {
            SaleDTO saleDTO = saleService.getSaleById(id);
            return saleDTO.toString();
        } catch (SaleGetByIdException exception) {
            return exception.getMessage();
        }
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Controller for sales of a pharmacy",
            description = "Endpoint for update a sale for id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public String updateSale(@PathVariable Long id, @RequestBody SaleDTO saleDTO) {
        try {
            SaleDTO saleDTO1 = saleService.updateSale(id, saleDTO);
            return saleDTO1.toString();
        } catch (SaleUpdateByIdException exception) {
            return exception.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Controller for sales of a pharmacy",
            description = "Endpoint for delete sale for id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    void deleteSale(@PathVariable Long id) {
        saleService.deleteSale(id);
    }
}
