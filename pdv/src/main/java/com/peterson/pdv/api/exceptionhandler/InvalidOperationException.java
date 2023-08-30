package com.peterson.pdv.api.exceptionhandler;

public class InvalidOperationException extends RuntimeException{

    public InvalidOperationException (String message){
        super(message);
    }
}
