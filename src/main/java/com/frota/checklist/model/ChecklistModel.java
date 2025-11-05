package com.frota.checklist.model;

import com.frota.checklist.dto.ChecklistDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "checklist")
public class ChecklistModel {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "idusuario", nullable = false)
    private UUID userId;

    @Column(name = "idveiculo", nullable = false)
    private UUID vehicleId;

    @Column(name = "idtipochecklist", nullable = false)
    private int checklistType;

    @Column(name = "outrosproblemas")
    private String otherProblems;

    @Column(name = "datadaviagem", length = 10)
    private String travelDate;

    @Column(name = "buzina")
    private boolean horn;

    @Column(name = "chavederoda")
    private boolean wheelWrench;

    @Column(name = "cintosdeseguranca")
    private boolean seatBelts;

    @Column(name = "farois")
    private boolean headlights;

    @Column(name = "freios")
    private boolean brakes;

    @Column(name = "lanternas")
    private boolean tailLights;

    @Column(name = "limpador")
    private boolean windshieldWiper;

    @Column(name = "parachoques")
    private boolean bumpers;

    @Column(name = "peneus")
    private boolean tires;

    @Column(name = "refletores")
    private boolean reflectors;

    @Column(name = "estepe")
    private boolean spareTire;

    @Column(name = "setas")
    private boolean turnSignals;

    public ChecklistDto toDto() {
        ChecklistDto dto = new ChecklistDto();
        dto.setId(id);
        dto.setUserId(this.userId);
        dto.setVehicleId(this.vehicleId);
        dto.setChecklistType(this.checklistType);
        dto.setOtherProblems(this.otherProblems);
        dto.setTravelDate(this.travelDate);
        dto.setBrakes(this.brakes);
        dto.setBumpers(this.bumpers);
        dto.setHorn(this.horn);
        dto.setHeadlights(this.headlights);
        dto.setReflectors(this.reflectors);
        dto.setSeatBelts(this.seatBelts);
        dto.setSpareTire(this.spareTire);
        dto.setTailLights(this.tailLights);
        dto.setTires(this.tires);
        dto.setTurnSignals(this.turnSignals);
        dto.setWheelWrench(this.wheelWrench);
        dto.setWindshieldWiper(this.windshieldWiper);

        return dto;
    }
}