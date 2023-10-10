package com.project.pharmacy.exceptions.person;

public class PersonUpdateByIdException extends RuntimeException{

    public PersonUpdateByIdException(String message){
        super(message);
    }
}
