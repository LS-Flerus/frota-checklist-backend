package com.frota.checklist.controller.documentation;

import com.frota.checklist.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Usuários", description = "Serviço para gerenciamento de usuários da aplicação")
public interface UserController {

    @Operation(summary = "Criar novo usuário")
    ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto);

    @Operation(summary = "Buscar usuário por ID")
    ResponseEntity<UserDto> getUserById(
            @Parameter(name = "id", description = "ID do usuário", required = true)
            @PathVariable UUID id);

    @Operation(summary = "Buscar usuário por nome")
    ResponseEntity<UserDto> getUserByName(
            @Parameter(name = "nome", description = "Nome do usuário", required = true)
            @PathVariable String nome);
}
