package com.example.Hotel_Reservation_System.Controller;

import com.example.Hotel_Reservation_System.Entity.Reservation;
import com.example.Hotel_Reservation_System.Service.ReservationService;
import com.example.Hotel_Reservation_System.Service.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/{userId}/{tableId}")
    public ResponseEntity<Reservation> addReservation(
            @PathVariable Long userId,
            @PathVariable Long tableId,
            @RequestBody Reservation reservationDetails) {
        Reservation newReservation = reservationService.addReservation(userId, tableId, reservationDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(newReservation);
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Reservation reservation = reservationService.getReservationById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + id));
        return ResponseEntity.ok(reservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservationDetails) {
        Reservation updatedReservation = reservationService.updateReservation(id, reservationDetails);
        return ResponseEntity.ok(updatedReservation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}

