package com.frota.checklist.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ChecklistDto {
    private UUID id;
    private UUID userId;
    private UUID vehicleId;
    private int checklistType;
    private String travelDate;
    private boolean horn;
    private boolean wheelWrench;
    private boolean seatBelts;
    private boolean headlights;
    private boolean brakes;
    private boolean tailLights;
    private boolean windshieldWiper;
    private boolean bumpers;
    private boolean tires;
    private boolean reflectors;
    private boolean spareTire;
    private boolean turnSignals;
    private String otherProblems;
}
