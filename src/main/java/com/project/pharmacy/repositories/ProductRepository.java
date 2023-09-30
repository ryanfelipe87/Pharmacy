package com.project.pharmacy.repositories;

import com.project.pharmacy.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
