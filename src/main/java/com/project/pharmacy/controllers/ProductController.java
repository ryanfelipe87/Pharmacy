package com.project.pharmacy.controllers;

import com.project.pharmacy.dtos.ProductDTO;
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
    public ResponseEntity<Void> createProduct(@RequestBody ProductDTO productDTO){
        productService.createProduct(productDTO);
        return new ResponseEntity<Void>(HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public List<ProductDTO> listAllProducts(){
        return productService.listAllProducts();
    }

    @GetMapping(path = "/{id}")
    public ProductDTO filterProductById(@PathVariable Long id){
        return productService.findClientById(id);
    }

    @PutMapping(path = "/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id, productDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
