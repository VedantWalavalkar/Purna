package com.example.purna.exception;

public class SellerNotFoundException extends RuntimeException{
    public SellerNotFoundException(String messgage){
        super(messgage);
    }
}
