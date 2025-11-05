package com.frota.checklist.repository;

import com.frota.checklist.model.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VehicleRepository extends JpaRepository<VehicleModel, UUID> {
}
