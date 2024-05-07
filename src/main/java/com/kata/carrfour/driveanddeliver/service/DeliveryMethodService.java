package com.kata.carrfour.driveanddeliver.service;

import com.kata.carrfour.driveanddeliver.dto.DeliveryMethodDTO;
import com.kata.carrfour.driveanddeliver.exceptions.DeliveryMethodAlreadyExistException;

import java.util.List;

public interface DeliveryMethodService {

     List<DeliveryMethodDTO> getAllDeliveryMethods();
    DeliveryMethodDTO saveDeliveryMethodChoice(DeliveryMethodDTO deliveryMethodDTO) throws DeliveryMethodAlreadyExistException;


}
