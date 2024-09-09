package com.example.Hotel_Reservation_System.Controller;

import com.example.Hotel_Reservation_System.Entity.Staff;
import com.example.Hotel_Reservation_System.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping("/register")
    public ResponseEntity<Staff> registerStaff(@RequestBody Staff staff) {
        Staff newStaff = staffService.registerStaff(staff);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStaff);
    }

    @PostMapping("/login")
    public ResponseEntity<Staff> login(@RequestParam String userName, @RequestParam String password) {
        Staff staff = staffService.login(userName, password);
        return ResponseEntity.ok(staff);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable Long id) {
        Staff staff = staffService.getStaffById(id);
        return ResponseEntity.ok(staff);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody Staff staff) {
        Staff updatedStaff = staffService.updateStaff(id, staff);
        return ResponseEntity.ok(updatedStaff);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
        return ResponseEntity.noContent().build();
    }
}
