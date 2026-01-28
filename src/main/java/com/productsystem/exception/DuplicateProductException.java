package com.productsystem.exception;

public class DuplicateProductException extends RuntimeException {
    public DuplicateProductException(String name) {
        super("Product already exists: " + name);
    }
}
