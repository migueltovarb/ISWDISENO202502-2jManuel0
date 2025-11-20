package com.example.vehiclerental.service;

import com.example.vehiclerental.domain.Vehicle;
import com.example.vehiclerental.exception.VehicleNotFoundException;
import com.example.vehiclerental.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository repository;

    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        vehicle.setId(null);
        return repository.save(vehicle);
    }

    public List<Vehicle> listVehicles() {
        return repository.findAll();
    }

    public Vehicle getVehicleById(String id) {
        return repository.findById(id).orElseThrow(() -> new VehicleNotFoundException(id));
    }

    public Vehicle updateVehicle(String id, Vehicle vehicle) {
        Vehicle existing = getVehicleById(id);
        existing.setMake(vehicle.getMake());
        existing.setModel(vehicle.getModel());
        existing.setYear(vehicle.getYear());
        existing.setColor(vehicle.getColor());
        existing.setVin(vehicle.getVin());
        return repository.save(existing);
    }

    public void deleteVehicle(String id) {
        Vehicle existing = getVehicleById(id);
        repository.delete(existing);
    }
}
