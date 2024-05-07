package com.kata.carrfour.driveanddeliver.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerException {

    @ExceptionHandler(TimeSlotAlreadyBookedException.class)
    public ResponseEntity<?> handleTimeSlotAlreadyBooked(TimeSlotAlreadyBookedException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT); // 409 Conflict
    }

    @ExceptionHandler(TimeSlotsNotExistException.class)
    public ResponseEntity<?> handleTimeSlotsNotExistException(TimeSlotsNotExistException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND); // 404 Not Found
    }

    // Général exception handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // 500 Internal Server Error
    }
}