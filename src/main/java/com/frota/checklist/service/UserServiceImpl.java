package com.frota.checklist.service;

import com.frota.checklist.dto.UserDto;
import com.frota.checklist.model.UserModel;
import com.frota.checklist.repository.UserRepository;
import com.frota.checklist.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDto createUser(UserDto userDTO) {
        Optional<UserModel> existingUser = userRepository.findByName(userDTO.getName());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("Já existe um usuário com esse nome no sistema!");
        }

        UserModel user = UserModel.builder()
                .name(userDTO.getName())
                .password(userDTO.getPassword())
                .build();

        userRepository.save(user);
        return user.toDto();
    }

    @Override
    public UserDto getUserById(UUID id) {
        return userRepository.findById(id)
                .map(UserModel::toDto)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    @Override
    public UserDto getUserByName(String name) {
        return userRepository.findByName(name)
                .map(UserModel::toDto)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
