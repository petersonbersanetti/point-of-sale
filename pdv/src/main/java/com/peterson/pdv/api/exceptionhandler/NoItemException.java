package com.peterson.pdv.api.exceptionhandler;

public class NoItemException extends RuntimeException{

    public NoItemException(String message){
        super(message);
    }
}
