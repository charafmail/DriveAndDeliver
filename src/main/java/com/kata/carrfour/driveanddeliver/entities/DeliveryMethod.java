package com.kata.carrfour.driveanddeliver.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Table(name = "delivery_methods")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2)
    @Column(nullable = false, unique = true)
    private String name;

    @Size(min = 5)
    @Column(nullable = true)
    private String description;


}
