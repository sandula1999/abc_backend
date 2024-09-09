package com.example.Hotel_Reservation_System.Repository;

import com.example.Hotel_Reservation_System.Entity.Reservation;
import com.example.Hotel_Reservation_System.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUser(User user);
}

