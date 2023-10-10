package com.project.pharmacy.exceptions.person;

public class PersonGetByIdException extends RuntimeException{

    public PersonGetByIdException(String message){
        super(message);
    }
}
