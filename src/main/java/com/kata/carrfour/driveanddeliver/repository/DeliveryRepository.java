package com.kata.carrfour.driveanddeliver.repository;

import com.kata.carrfour.driveanddeliver.entities.DeliveryMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<DeliveryMethod,Long> {
}
