package com.project.pharmacy.exceptions.clients;

public class ClientUpdateByIdException extends RuntimeException{

    public ClientUpdateByIdException(String message){
        super(message);
    }
}
