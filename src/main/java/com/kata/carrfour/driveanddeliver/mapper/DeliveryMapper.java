package com.kata.carrfour.driveanddeliver.mapper;

import com.kata.carrfour.driveanddeliver.dto.DeliveryMethodDTO;
import com.kata.carrfour.driveanddeliver.dto.TimeSlotDTO;
import com.kata.carrfour.driveanddeliver.entities.DeliveryMethod;
import com.kata.carrfour.driveanddeliver.entities.TimeSlot;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryMapper {


    private ModelMapper modelMapper = new ModelMapper();




    public DeliveryMethodDTO fromDeliveryMapper(DeliveryMethod deliveryMethod) {
        return modelMapper.map(deliveryMethod,DeliveryMethodDTO.class);
    }

    public DeliveryMethod fromDeliveryMethodDTO(DeliveryMethodDTO deliveryMethodDTO) {
        return modelMapper.map(deliveryMethodDTO,DeliveryMethod.class);
    }

    public TimeSlot fromTimeSlotsDTO(TimeSlotDTO timeSlotsDTO) {
        return modelMapper.map(timeSlotsDTO,TimeSlot.class);
    }

    public TimeSlotDTO fromTimeSlot(TimeSlot savedTimeSlot) {
        return modelMapper.map(savedTimeSlot, TimeSlotDTO.class);
    }

    public List<DeliveryMethodDTO> fromListDeliveryMethods(List<DeliveryMethod> allDeliveryMethods) {
        return allDeliveryMethods.stream().map(d -> modelMapper.map(d,DeliveryMethodDTO.class)).collect(Collectors.toList());
    }

    public List<TimeSlotDTO> fromListTimeSlots(List<TimeSlot> timeSlot) {
        return timeSlot.stream().map(t -> modelMapper.map(t, TimeSlotDTO.class)).collect(Collectors.toList());
    }
}
