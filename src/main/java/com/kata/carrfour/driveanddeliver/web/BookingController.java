package com.kata.carrfour.driveanddeliver.web;

import com.kata.carrfour.driveanddeliver.dto.DeliveryMethodDTO;
import com.kata.carrfour.driveanddeliver.dto.TimeSlotDTO;
import com.kata.carrfour.driveanddeliver.exceptions.TimeSlotAlreadyBookedException;
import com.kata.carrfour.driveanddeliver.exceptions.TimeSlotsNotExistException;
import com.kata.carrfour.driveanddeliver.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }



    // List available time slots for a given delivery method
@GetMapping("/v1/time-slots/{deliveryMethod}")
    public ResponseEntity<List<TimeSlotDTO>> getTimeSlots(@PathVariable("deliveryMethod") DeliveryMethodDTO deliveryMethod){
    List<TimeSlotDTO> slots = bookingService.getTimeSlots(deliveryMethod) ;
    return ResponseEntity.ok(slots);
}

    // Book a selected time slot
@PostMapping("/v1/book-time-slots")
@ResponseStatus(HttpStatus.CREATED)
public ResponseEntity<TimeSlotDTO> bookTimeSlots(@RequestBody @Valid TimeSlotDTO timeSlotsDTO) throws TimeSlotAlreadyBookedException, TimeSlotsNotExistException {
    TimeSlotDTO responseDTO= bookingService.bookTimeSlots(timeSlotsDTO);
    return ResponseEntity.ok(responseDTO);
}



}
