package com.kata.carrfour.driveanddeliver.service;

import com.kata.carrfour.driveanddeliver.dto.DeliveryMethodDTO;
import com.kata.carrfour.driveanddeliver.dto.TimeSlotDTO;
import com.kata.carrfour.driveanddeliver.exceptions.TimeSlotAlreadyBookedException;
import com.kata.carrfour.driveanddeliver.exceptions.TimeSlotsNotExistException;

import java.util.List;

public interface BookingService {
    List<TimeSlotDTO> getTimeSlots(DeliveryMethodDTO deliveryMethod);

    TimeSlotDTO bookTimeSlots(TimeSlotDTO timeSlotsDTO) throws TimeSlotsNotExistException, TimeSlotAlreadyBookedException;
}
