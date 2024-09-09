package com.example.Hotel_Reservation_System.Controller;

import com.example.Hotel_Reservation_System.Entity.Table;
import com.example.Hotel_Reservation_System.Service.ResourceNotFoundException;
import com.example.Hotel_Reservation_System.Service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class TableController {

    @Autowired
    private TableService tableService;

    @PostMapping
    public ResponseEntity<Table> addTable(@RequestBody Table table) {
        Table newTable = tableService.addTable(table);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTable);
    }

    @GetMapping
    public ResponseEntity<List<Table>> getAllTables() {
        List<Table> tables = tableService.getAllTables();
        return ResponseEntity.ok(tables);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Table> getTableById(@PathVariable Long id) {
        Table table = tableService.getTableById(id).orElseThrow(() ->
                new ResourceNotFoundException("Table not found with id: " + id));
        return ResponseEntity.ok(table);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Table> updateTable(@PathVariable Long id, @RequestBody Table table) {
        Table updatedTable = tableService.updateTable(id, table);
        return ResponseEntity.ok(updatedTable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        tableService.deleteTable(id);
        return ResponseEntity.noContent().build();
    }
}
