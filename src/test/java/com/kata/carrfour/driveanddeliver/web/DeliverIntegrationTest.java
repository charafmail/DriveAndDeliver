package com.kata.carrfour.driveanddeliver.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.carrfour.driveanddeliver.dto.DeliveryMethodDTO;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class DeliverIntegrationTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private ObjectMapper objectMapper;


    List<DeliveryMethodDTO> DeliveryMethods;

    @BeforeEach
    void setUp() {
        this.DeliveryMethods = new ArrayList<>();

        DeliveryMethodDTO drive = new DeliveryMethodDTO(1L, "DRIVE", "Pick up your order at our drive-through.");
        DeliveryMethodDTO delivery = new DeliveryMethodDTO(2L, "DELIVERY", "Standard delivery to your address.");
        DeliveryMethodDTO deliveryToday = new DeliveryMethodDTO(3L, "DELIVERY_TODAY", "Get your order delivered today.");
        DeliveryMethodDTO deliveryAsap = new DeliveryMethodDTO(4L, "DELIVERY_ASAP", "Fastest delivery option available.");

        this.DeliveryMethods.add(drive);
        this.DeliveryMethods.add(delivery);
        this.DeliveryMethods.add(deliveryToday);
        this.DeliveryMethods.add(deliveryAsap);

    }

    @Test
    void shouldGetAllCustomers() {
        ResponseEntity<DeliveryMethodDTO[]> response = testRestTemplate.exchange("/v1/delivery-methods", HttpMethod.GET, null, DeliveryMethodDTO[].class);
        List<DeliveryMethodDTO> content = Arrays.asList(response.getBody());
        AssertionsForClassTypes.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        AssertionsForClassTypes.assertThat(content.size()).isEqualTo(4);
        AssertionsForClassTypes.assertThat(content).usingRecursiveComparison().isEqualTo(DeliveryMethods);
    }


}
