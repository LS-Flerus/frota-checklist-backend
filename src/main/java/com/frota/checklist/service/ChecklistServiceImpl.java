package com.frota.checklist.service;

import com.frota.checklist.dto.ChecklistDto;
import com.frota.checklist.model.ChecklistModel;
import com.frota.checklist.repository.ChecklistRepository;
import com.frota.checklist.service.interfaces.ChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;

@Service
public class ChecklistServiceImpl implements ChecklistService {

    private final ChecklistRepository checklistRepository;

    @Autowired
    public ChecklistServiceImpl(ChecklistRepository checklistRepository) {
        this.checklistRepository = checklistRepository;
    }

    @Override
    @Transactional
    public ChecklistDto createChecklist(ChecklistDto checklistDTO) {
        ChecklistModel checklist = ChecklistModel.builder()
                .userId(checklistDTO.getUserId())
                .vehicleId(checklistDTO.getVehicleId())
                .checklistType(checklistDTO.getChecklistType())
                .travelDate(checklistDTO.getTravelDate())
                .brakes(checklistDTO.isBrakes())
                .tailLights(checklistDTO.isTailLights())
                .horn(checklistDTO.isHorn())
                .tires(checklistDTO.isTires())
                .bumpers(checklistDTO.isBumpers())
                .headlights(checklistDTO.isHeadlights())
                .reflectors(checklistDTO.isReflectors())
                .seatBelts(checklistDTO.isSeatBelts())
                .spareTire(checklistDTO.isSpareTire())
                .turnSignals(checklistDTO.isTurnSignals())
                .wheelWrench(checklistDTO.isWheelWrench())
                .windshieldWiper(checklistDTO.isWindshieldWiper())
                .otherProblems(checklistDTO.getOtherProblems())
                .build();

        checklistRepository.save(checklist);
        return checklist.toDto();
    }

    @Override
    public ChecklistDto getChecklistById(UUID id) {
        return checklistRepository.findById(id)
                .map(ChecklistModel::toDto)
                .orElseThrow(() -> new RuntimeException("Checklist não encontrada!"));
    }

    @Override
    public Collection<ChecklistDto> getAllChecklistsByUserId(UUID userId) {
        return checklistRepository.findAllByUserId(userId).stream()
                .map(ChecklistModel::toDto)
                .toList();
    }
}
