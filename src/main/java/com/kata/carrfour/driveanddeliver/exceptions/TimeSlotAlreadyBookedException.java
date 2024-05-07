package com.kata.carrfour.driveanddeliver.exceptions;

public class TimeSlotAlreadyBookedException extends RuntimeException {
    public TimeSlotAlreadyBookedException(String message) {
        super(message);
    }
}
