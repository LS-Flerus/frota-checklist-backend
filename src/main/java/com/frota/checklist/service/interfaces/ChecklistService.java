package com.frota.checklist.service.interfaces;

import com.frota.checklist.dto.ChecklistDto;

import java.util.Collection;
import java.util.UUID;

public interface ChecklistService {
    ChecklistDto createChecklist(ChecklistDto dto);
    ChecklistDto getChecklistById(UUID id);
    Collection<ChecklistDto> getAllChecklistsByUserId(UUID userId);
}
