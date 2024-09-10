package com.example.Hotel_Reservation_System.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class ResturantT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tableId;

    private int capacity;

    private boolean isAvailable;
    private String type; // e.g., "Regular", "VIP"

    // Constructors, Getters, and Setters
}
