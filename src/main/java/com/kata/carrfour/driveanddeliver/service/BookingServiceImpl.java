package com.kata.carrfour.driveanddeliver.service;

import com.kata.carrfour.driveanddeliver.dto.DeliveryMethodDTO;
import com.kata.carrfour.driveanddeliver.dto.TimeSlotDTO;
import com.kata.carrfour.driveanddeliver.entities.DeliveryMethod;
import com.kata.carrfour.driveanddeliver.entities.TimeSlot;
import com.kata.carrfour.driveanddeliver.exceptions.TimeSlotAlreadyBookedException;
import com.kata.carrfour.driveanddeliver.exceptions.TimeSlotsNotExistException;
import com.kata.carrfour.driveanddeliver.mapper.DeliveryMapper;
import com.kata.carrfour.driveanddeliver.repository.TimeSlotRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookingServiceImpl implements BookingService {

    private DeliveryMapper deliveryMapper;
    private TimeSlotRepository timeSlotRepository;

    public BookingServiceImpl(DeliveryMapper deliveryMapper, TimeSlotRepository timeSlotRepository) {
        this.deliveryMapper = deliveryMapper;
        this.timeSlotRepository = timeSlotRepository;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<TimeSlotDTO> getTimeSlots(DeliveryMethodDTO deliveryMethodDTO) {

        DeliveryMethod deliveryMethod = deliveryMapper.fromDeliveryMethodDTO(deliveryMethodDTO);

        List<TimeSlot> timeSlot  = timeSlotRepository.findByDeliveryMethodAndIsBooked(deliveryMethod,false);
        return deliveryMapper.fromListTimeSlots(timeSlot);
    }

    /**
     * @param timeSlotsDTO
     * @return
     */
    @Override
    public TimeSlotDTO bookTimeSlots(TimeSlotDTO timeSlotsDTO) throws TimeSlotsNotExistException, TimeSlotAlreadyBookedException {
        log.info(String.format("Check if the time slot is already booked to prevent double booking => %s ",timeSlotsDTO.toString()));


         Optional<TimeSlot> existingTimeSlot= timeSlotRepository.findById(timeSlotsDTO.id());
         if(!existingTimeSlot.isPresent()){
             throw new TimeSlotsNotExistException("Time Slot not found");
         }

         if(existingTimeSlot.get().isBooked()){
             throw new TimeSlotAlreadyBookedException("TimeSlotAlreadyBooked");
         }
        // Mark the time slot as booked
        existingTimeSlot.get().setBooked(true);

        TimeSlot timeSlotToSave = deliveryMapper.fromTimeSlotsDTO(timeSlotsDTO);

        TimeSlot savedTimeSlot = timeSlotRepository.save(timeSlotToSave);


        TimeSlotDTO result = deliveryMapper.fromTimeSlot(savedTimeSlot);

        return result;

    }
}
