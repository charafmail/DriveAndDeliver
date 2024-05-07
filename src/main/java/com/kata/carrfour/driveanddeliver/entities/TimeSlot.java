package com.kata.carrfour.driveanddeliver.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="time_slots")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="delivery_method_id",nullable= false)
    private DeliveryMethod deliveryMethod;
    @Column(nullable= false)
    private LocalDateTime startTime;
    @Column(nullable= false)
    private LocalDateTime endTime;
    @Column(nullable= false)
    private boolean isBooked;



}
