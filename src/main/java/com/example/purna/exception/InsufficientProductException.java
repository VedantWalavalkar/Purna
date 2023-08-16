package com.example.purna.exception;

public class InsufficientProductException extends RuntimeException{
    public InsufficientProductException(String message){
        super(message);
    }
}
