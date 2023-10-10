package com.project.pharmacy.exceptions.product;

public class ProductGetByIdException extends RuntimeException {

    public ProductGetByIdException(String message) {
        super(message);
    }
}
