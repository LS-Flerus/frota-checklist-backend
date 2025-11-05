package com.frota.checklist.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class VehicleDto {
    private UUID id;
    private String plaque;
    private String brand;
    private String model;
}
