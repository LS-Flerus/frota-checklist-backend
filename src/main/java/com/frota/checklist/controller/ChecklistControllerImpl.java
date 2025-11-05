package com.frota.checklist.controller;

import com.frota.checklist.controller.documentation.ChecklistController;
import com.frota.checklist.controller.documentation.UserController;
import com.frota.checklist.dto.ChecklistDto;
import com.frota.checklist.dto.UserDto;
import com.frota.checklist.service.interfaces.ChecklistService;
import com.frota.checklist.service.interfaces.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/checklist")
public class ChecklistControllerImpl implements ChecklistController {

    private final ChecklistService checklistService;

    public ChecklistControllerImpl(ChecklistService checklistService) {
        this.checklistService = checklistService;
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<ChecklistDto> createChecklist(@RequestBody ChecklistDto checklistDto) {
        return ResponseEntity.ok(checklistService.createChecklist(checklistDto));
    }

    @Override
    @GetMapping("/getById")
    public ResponseEntity<ChecklistDto> getChecklistById(@RequestParam UUID id) {
        return ResponseEntity.ok(checklistService.getChecklistById(id));
    }

    @Override
    @GetMapping("/getChecklistByUserId")
    public ResponseEntity<Collection<ChecklistDto>> getAllChecklistByUserId(@RequestParam UUID userId) {
        return ResponseEntity.ok(checklistService.getAllChecklistsByUserId(userId));
    }
}
