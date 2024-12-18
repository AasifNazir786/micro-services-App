package com.example.author_service.custom_exceptions;

public class AuthorNotFoundException extends RuntimeException{
    
    public AuthorNotFoundException(String message){
        super(message);
    }
}
