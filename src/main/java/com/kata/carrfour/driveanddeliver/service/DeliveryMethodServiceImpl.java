package com.kata.carrfour.driveanddeliver.service;

import com.kata.carrfour.driveanddeliver.dto.DeliveryMethodDTO;
import com.kata.carrfour.driveanddeliver.entities.DeliveryMethod;
import com.kata.carrfour.driveanddeliver.exceptions.DeliveryMethodAlreadyExistException;
import com.kata.carrfour.driveanddeliver.mapper.DeliveryMapper;
import com.kata.carrfour.driveanddeliver.repository.DeliveryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DeliveryMethodServiceImpl implements DeliveryMethodService {

    private DeliveryMapper deliveryMapper;
    private DeliveryRepository deliveryRepository;

    public DeliveryMethodServiceImpl(DeliveryMapper deliveryMapper,DeliveryRepository deliveryRepository) {
        this.deliveryMapper = deliveryMapper;
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public List<DeliveryMethodDTO> getAllDeliveryMethods() {
       List<DeliveryMethod> allDeliveryMethods = deliveryRepository.findAll();
       return deliveryMapper.fromListDeliveryMethods(allDeliveryMethods);
    }

    @Override
    public DeliveryMethodDTO saveDeliveryMethodChoice(DeliveryMethodDTO deliveryMethodDTO) throws DeliveryMethodAlreadyExistException {
        log.info(String.format("Saving new Customer => %s",deliveryMethodDTO.toString() ));
        Optional<DeliveryMethod> deliveryMethod =deliveryRepository.findById(deliveryMethodDTO.id());
        if(deliveryMethod.isPresent()){
            throw new DeliveryMethodAlreadyExistException(String.format("This deliveryMethod already exist => %s",deliveryMethodDTO.name()));
        }
        DeliveryMethod deliveryMethodToSave = deliveryMapper.fromDeliveryMethodDTO(deliveryMethodDTO);
        DeliveryMethod savedDeliveryMethod = deliveryRepository.save(deliveryMethodToSave);
        DeliveryMethodDTO result = deliveryMapper.fromDeliveryMapper(savedDeliveryMethod);
        return result;

    }


}
