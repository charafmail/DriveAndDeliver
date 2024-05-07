package com.kata.carrfour.driveanddeliver.dto;

import java.time.LocalDateTime;

public record TimeSlotDTO(Long id, DeliveryMethodDTO deliveryMethod, LocalDateTime startTime, LocalDateTime endTime, boolean isBooked) {

}
