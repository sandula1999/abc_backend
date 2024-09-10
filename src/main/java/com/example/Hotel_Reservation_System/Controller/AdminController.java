package com.example.Hotel_Reservation_System.Controller;

import com.example.Hotel_Reservation_System.Entity.Admin;
import com.example.Hotel_Reservation_System.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
        Admin newAdmin = adminService.registerAdmin(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAdmin);
    }

    @PostMapping("/login")
    public ResponseEntity<Admin> login(@RequestParam String userName, @RequestParam String password) {
        Admin admin = adminService.login(userName, password);
        return ResponseEntity.ok(admin);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        return ResponseEntity.ok(admin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        Admin updatedAdmin = adminService.updateAdmin(id, admin);
        return ResponseEntity.ok(updatedAdmin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
