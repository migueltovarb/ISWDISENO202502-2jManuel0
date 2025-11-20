package com.example.vehiclerental.repository;

import com.example.vehiclerental.domain.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {
}
