package com.example.Hotel_Reservation_System.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

@jakarta.persistence.Table(name="ResturantTable")  // Change table name here

public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tableId;

    private int capacity;
    @Column(columnDefinition = "Bit=1")
    private boolean isAvailable;
    private String type; // e.g., "Regular", "VIP"

    // Constructors, Getters, and Setters
}
