package com.example.vehiclerental.exception;

public class VehicleNotFoundException extends RuntimeException {

    public VehicleNotFoundException(String id) {
        super("Vehicle with id " + id + " not found");
    }
}
