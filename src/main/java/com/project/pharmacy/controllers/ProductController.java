package com.project.pharmacy.controllers;

import com.project.pharmacy.dtos.ProductDTO;
import com.project.pharmacy.exceptions.product.ProductGetByIdException;
import com.project.pharmacy.exceptions.product.ProductUpdateByIdException;
import com.project.pharmacy.services.impl.ProductServiceImpl;
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
@RequestMapping(path = "/api/product")
@Tag(name = "Product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping
    @Operation(
            summary = "Controller for products of a pharmacy",
            description = "Endpoint for create a new product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public ResponseEntity<Void> createProduct(@RequestBody ProductDTO productDTO) {
        productService.createProduct(productDTO);
        return new ResponseEntity<Void>(HttpStatusCode.valueOf(200));
    }

    @GetMapping
    @Operation(
            summary = "Controller for products of a pharmacy",
            description = "Endpoint for search all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public List<ProductDTO> listAllProducts() {
        return productService.listAllProducts();
    }

    @GetMapping(path = "/{id}")
    @Operation(
            summary = "Controller for products of a pharmacy",
            description = "Endpoint for search products for id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public String filterProductById(@PathVariable Long id) {
        try {
            ProductDTO productDTO = productService.findClientById(id);
            return productDTO.toString();
        } catch (ProductGetByIdException exception) {
            return exception.getMessage();
        }
    }

    @PutMapping(path = "/{id}")
    @Operation(
            summary = "Controller for products of a pharmacy",
            description = "Endpoint for update a product for id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public String updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        try {
            ProductDTO productDTO1 = productService.updateProduct(id, productDTO);
            return productDTO1.toString();
        } catch (ProductUpdateByIdException exception) {
            return exception.getMessage();
        }
    }

    @DeleteMapping(path = "/{id}")
    @Operation(
            summary = "Controller for products of a pharmacy",
            description = "Endpoint for delete a product for id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
