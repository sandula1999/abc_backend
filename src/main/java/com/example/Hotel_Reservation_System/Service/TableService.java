package com.example.Hotel_Reservation_System.Service;

import com.example.Hotel_Reservation_System.Entity.ResturantT;
import com.example.Hotel_Reservation_System.Entity.Table;
import com.example.Hotel_Reservation_System.Repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    public Table addTable(ResturantT table) {
        return tableRepository.save(table);
    }

    public List<Table> getAllTables() {
        return tableRepository.findAll();
    }

    public Optional<Table> getTableById(Long id) {
        return tableRepository.findById(id);
    }

    public Table updateTable(Long id, Table updatedTable) {
        return tableRepository.findById(id).map(table -> {
            table.setCapacity(updatedTable.getCapacity());
            table.setAvailable(updatedTable.isAvailable());
            table.setType(updatedTable.getType());
            return tableRepository.save(table);
        }).orElseThrow(() -> new ResourceNotFoundException("Table not found with id: " + id));
    }

    public void deleteTable(Long id) {
        tableRepository.deleteById(id);
    }
}
