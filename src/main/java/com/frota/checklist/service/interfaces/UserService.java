package com.frota.checklist.service.interfaces;

import com.frota.checklist.dto.UserDto;

import java.util.UUID;

public interface UserService {
    UserDto createUser(UserDto dto);
    UserDto getUserById(UUID id);
    UserDto getUserByName(String name);
}
