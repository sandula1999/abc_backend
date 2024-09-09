package com.example.Hotel_Reservation_System.Service;

import com.example.Hotel_Reservation_System.Entity.Reservation;
import com.example.Hotel_Reservation_System.Entity.Table;
import com.example.Hotel_Reservation_System.Entity.User;
import com.example.Hotel_Reservation_System.Repository.ReservationRepository;
import com.example.Hotel_Reservation_System.Repository.TableRepository;
import com.example.Hotel_Reservation_System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TableRepository tableRepository;

    public Reservation addReservation(Long userId, Long tableId, Reservation reservationDetails) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User not found with id: " + userId));
        Table table = tableRepository.findById(tableId).orElseThrow(() ->
                new ResourceNotFoundException("Table not found with id: " + tableId));

        reservationDetails.setUser(user);
        reservationDetails.setTable(table);
        return reservationRepository.save(reservationDetails);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation updateReservation(Long id, Reservation reservationDetails) {
        return reservationRepository.findById(id).map(reservation -> {
            reservation.setReservationTime(reservationDetails.getReservationTime());
            reservation.setNumberOfGuests(reservationDetails.getNumberOfGuests());
            reservation.setSpecialRequest(reservationDetails.getSpecialRequest());
            return reservationRepository.save(reservation);
        }).orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + id));
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}

