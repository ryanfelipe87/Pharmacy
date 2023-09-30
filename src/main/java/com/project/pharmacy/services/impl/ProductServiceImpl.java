package com.project.pharmacy.services.impl;

import com.project.pharmacy.dtos.ProductDTO;
import com.project.pharmacy.models.Product;
import com.project.pharmacy.repositories.ProductRepository;
import com.project.pharmacy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setValidity(productDTO.getValidity());

        product = productRepository.save(product);

        return convertToDTO(product);
    }

    @Override
    public List<ProductDTO> listAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this :: convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findClientById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if(product != null){
            return convertToDTO(product);
        }
        return null;
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            Product product = productOptional.get();
            product.setName(productDTO.getName());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());
            product.setValidity(productDTO.getValidity());

            product = productRepository.save(product);

            return convertToDTO(product);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public ProductDTO convertToDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setValidity(product.getValidity());
        return productDTO;
    }
}
