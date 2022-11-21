package com.kiel.dsmeta.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super(String.valueOf(id));
    }
}
