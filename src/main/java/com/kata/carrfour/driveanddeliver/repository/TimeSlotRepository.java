package com.kata.carrfour.driveanddeliver.repository;

import com.kata.carrfour.driveanddeliver.entities.DeliveryMethod;
import com.kata.carrfour.driveanddeliver.entities.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeSlotRepository extends JpaRepository<TimeSlot,Long> {
    List<TimeSlot> findByDeliveryMethodAndIsBooked(DeliveryMethod deliveryMethod, boolean isBooked);
}
