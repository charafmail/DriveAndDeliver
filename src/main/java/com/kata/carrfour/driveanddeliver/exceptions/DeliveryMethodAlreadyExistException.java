package com.kata.carrfour.driveanddeliver.exceptions;

public class DeliveryMethodAlreadyExistException extends RuntimeException  {

    public DeliveryMethodAlreadyExistException(String message) {
        super(message);
    }
}