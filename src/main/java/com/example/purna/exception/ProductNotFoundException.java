package com.example.purna.exception;

import com.example.purna.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message){
        super(message);
    }
}
