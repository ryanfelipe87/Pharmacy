package com.project.pharmacy.exceptions.product;

public class ProductUpdateByIdException extends RuntimeException {

    public ProductUpdateByIdException(String message) {
        super(message);
    }
}
