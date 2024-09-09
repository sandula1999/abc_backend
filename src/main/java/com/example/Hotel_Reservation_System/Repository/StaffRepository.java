package com.example.Hotel_Reservation_System.Repository;

import com.example.Hotel_Reservation_System.Entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff findByUserName(String userName);
}

