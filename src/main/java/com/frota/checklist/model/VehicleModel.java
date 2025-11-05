package com.frota.checklist.model;

import com.frota.checklist.dto.VehicleDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
@Table(name = "veiculos")
@EqualsAndHashCode
public class VehicleModel {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "placa", nullable = false, length = 7)
    private String plaque;

    @Column(name = "marca", length = 50)
    private String brand;

    @Column(name = "model", length = 50)
    private String model;

    public VehicleDto toDto() {
        VehicleDto dto = new VehicleDto();
        dto.setId(this.id);
        dto.setPlaque(this.plaque);
        dto.setBrand(this.brand);
        dto.setModel(this.model);
        return dto;
    }
}
