package com.frota.checklist.controller.documentation;

import com.frota.checklist.dto.ChecklistDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.UUID;

@Tag(name = "Checklist", description = "Serviço para gerenciamento de checklists")
public interface ChecklistController {
    @Operation(summary = "Criar nova checklist")
    ResponseEntity<ChecklistDto> createChecklist(@RequestBody ChecklistDto checklistDto);

    @Operation(summary = "Buscar checklist por ID")
    ResponseEntity<ChecklistDto> getChecklistById(
            @Parameter(name = "id", description = "ID da checklist", required = true)
            @PathVariable UUID id);

    @Operation(summary = "Buscar checklist por ID do usuário")
    ResponseEntity<Collection<ChecklistDto>> getAllChecklistByUserId(
            @Parameter(name = "id_usuário", description = "Id do usuário", required = true)
            @PathVariable UUID userId);
}
