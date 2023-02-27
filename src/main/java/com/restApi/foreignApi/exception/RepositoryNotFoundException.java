package com.restApi.foreignApi.exception;

public class RepositoryNotFoundException extends RuntimeException {

    public RepositoryNotFoundException(String message) {
        super(message);
    }

    public RepositoryNotFoundException() {
        super("Repository not found");
    }
}
