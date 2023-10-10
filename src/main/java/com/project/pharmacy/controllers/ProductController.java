package com.project.pharmacy.controllers;

import com.project.pharmacy.dtos.ProductDTO;
import com.project.pharmacy.exceptions.product.ProductGetByIdException;
import com.project.pharmacy.exceptions.product.ProductUpdateByIdException;
import com.project.pharmacy.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductDTO productDTO) {
        productService.createProduct(productDTO);
        return new ResponseEntity<Void>(HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public List<ProductDTO> listAllProducts() {
        return productService.listAllProducts();
    }

    @GetMapping(path = "/{id}")
    public String filterProductById(@PathVariable Long id) {
        try {
            ProductDTO productDTO = productService.findClientById(id);
            return productDTO.toString();
        } catch (ProductGetByIdException exception) {
            return exception.getMessage();
        }
    }

    @PutMapping(path = "/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        try {
            ProductDTO productDTO1 = productService.updateProduct(id, productDTO);
            return productDTO1.toString();
        } catch (ProductUpdateByIdException exception) {
            return exception.getMessage();
        }
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
