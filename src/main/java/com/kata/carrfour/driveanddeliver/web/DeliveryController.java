package com.kata.carrfour.driveanddeliver.web;

import com.kata.carrfour.driveanddeliver.dto.DeliveryMethodDTO;
import com.kata.carrfour.driveanddeliver.exceptions.DeliveryMethodAlreadyExistException;
import com.kata.carrfour.driveanddeliver.service.DeliveryMethodServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DeliveryController {

    private DeliveryMethodServiceImpl deliveryService;

    public DeliveryController(DeliveryMethodServiceImpl deliveryService) {
        this.deliveryService = deliveryService;
    }


    // List available delivery methods
@GetMapping("/v1/delivery-methods")
    public ResponseEntity<List<DeliveryMethodDTO>> listDeliveryMethods(){
     List<DeliveryMethodDTO> methods = deliveryService.getAllDeliveryMethods();
    return ResponseEntity.ok(methods);
}

    // Save customer's delivery method choice
@PostMapping("/v1/select-delivery-method")
    public ResponseEntity<DeliveryMethodDTO> selectDeliveryMethod(@RequestBody @Valid DeliveryMethodDTO deliveryMethodDTO) throws DeliveryMethodAlreadyExistException {
    DeliveryMethodDTO responseDTO= deliveryService.saveDeliveryMethodChoice(deliveryMethodDTO);
    return ResponseEntity.ok(responseDTO);
}




}
