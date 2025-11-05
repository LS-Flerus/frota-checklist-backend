package com.frota.checklist.controller;

import com.frota.checklist.controller.documentation.UserController;
import com.frota.checklist.dto.UserDto;
import com.frota.checklist.service.interfaces.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @Override
    @GetMapping("/getById")
    public ResponseEntity<UserDto> getUserById(@RequestParam UUID id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Override
    @GetMapping("/getByName")
    public ResponseEntity<UserDto> getUserByName(@RequestParam String name) {
        return ResponseEntity.ok(userService.getUserByName(name));
    }
}