package com.example.Hotel_Reservation_System.Service;

import com.example.Hotel_Reservation_System.Entity.Staff;
import com.example.Hotel_Reservation_System.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public Staff registerStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public Staff login(String userName, String password) {
        Staff staff = staffRepository.findByUserName(userName);
        if (staff != null && staff.getPassword().equals(password)) {
            return staff;
        } else {
            throw new ResourceNotFoundException("Invalid username or password");
        }
    }

    public Staff getStaffById(Long id) {
        return staffRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Staff not found with id: " + id));
    }

    public Staff updateStaff(Long id, Staff updatedStaff) {
        return staffRepository.findById(id).map(staff -> {
            staff.setName(updatedStaff.getName());
            staff.setAddress(updatedStaff.getAddress());
            staff.setContactNo(updatedStaff.getContactNo());
            staff.setEmail(updatedStaff.getEmail());
            staff.setUserName(updatedStaff.getUserName());
            staff.setPassword(updatedStaff.getPassword());
            staff.setRole(updatedStaff.getRole());
            return staffRepository.save(staff);
        }).orElseThrow(() -> new ResourceNotFoundException("Staff not found with id: " + id));
    }

    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }
}
