package com.project.pharmacy.services;

import com.project.pharmacy.dtos.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO);

    List<ProductDTO> listAllProducts();

    ProductDTO findClientById(Long id);

    ProductDTO updateProduct(Long id, ProductDTO productDTO);

    void deleteProduct(Long id);
}
