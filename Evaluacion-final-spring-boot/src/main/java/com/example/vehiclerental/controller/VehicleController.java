package com.example.vehiclerental.controller;

import com.example.vehiclerental.domain.Vehicle;
import com.example.vehiclerental.exception.VehicleNotFoundException;
import com.example.vehiclerental.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@Validated
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@Valid @RequestBody Vehicle vehicle) {
        Vehicle created = vehicleService.createVehicle(vehicle);
        return ResponseEntity.created(URI.create("/api/vehicles/" + created.getId())).body(created);
    }

    @GetMapping
    public List<Vehicle> listVehicles() {
        return vehicleService.listVehicles();
    }

    @GetMapping("/{id}")
    public Vehicle getVehicle(@PathVariable String id) {
        return vehicleService.getVehicleById(id);
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable String id, @Valid @RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(id, vehicle);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVehicle(@PathVariable String id) {
        vehicleService.deleteVehicle(id);
    }

    @ExceptionHandler(VehicleNotFoundException.class)
    public ResponseEntity<String> handleNotFound(VehicleNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
