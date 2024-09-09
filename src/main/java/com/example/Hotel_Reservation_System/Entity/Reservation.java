package com.example.Hotel_Reservation_System.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user; // Link to User entity

    @ManyToOne
    @JoinColumn(name = "table_id", referencedColumnName = "tableId")
    private Table table; // Link to Table entity

    private LocalDateTime reservationTime;
    private int numberOfGuests;
    private String specialRequest; // Any special requests


}

