package com.example.Hotel_Reservation_System.Controller;

import com.example.Hotel_Reservation_System.Entity.ResturantT;
import com.example.Hotel_Reservation_System.Service.ResourceNotFoundException;
import com.example.Hotel_Reservation_System.Service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tables")
public class TableController {

    @Autowired
    private TableService tableService;

    @PostMapping
    public ResponseEntity<ResturantT> addTable(@RequestBody ResturantT resturantT) {
        ResturantT newResturantT = tableService.addTable(resturantT);
        return ResponseEntity.status(HttpStatus.CREATED).body(newResturantT);
    }

    @GetMapping
    public ResponseEntity<List<ResturantT>> getAllTables() {
        List<ResturantT> resturantTS = tableService.getAllTables();
        return ResponseEntity.ok(resturantTS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResturantT> getTableById(@PathVariable Long id) {
        ResturantT resturantT = tableService.getTableById(id).orElseThrow(() ->
                new ResourceNotFoundException("Table not found with id: " + id));
        return ResponseEntity.ok(resturantT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResturantT> updateTable(@PathVariable Long id, @RequestBody ResturantT resturantT) {
        ResturantT updatedResturantT = tableService.updateTable(id, resturantT);
        return ResponseEntity.ok(updatedResturantT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        tableService.deleteTable(id);
        return ResponseEntity.noContent().build();
    }
}
