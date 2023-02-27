package com.restApi.foreignApi.exception;

public class RepositoryServiceNotAvailableException extends RuntimeException {

    public RepositoryServiceNotAvailableException(String message)   {
        super(message);
    }
}
