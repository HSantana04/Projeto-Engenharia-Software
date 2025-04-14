package com.gestor.projeto_engenharia_software.service.impl;

import com.gestor.projeto_engenharia_software.dto.UserDTO;
import com.gestor.projeto_engenharia_software.entity.User;
import com.gestor.projeto_engenharia_software.exception.ResourceNotFoundException;
import com.gestor.projeto_engenharia_software.mapper.UserMapper;
import com.gestor.projeto_engenharia_software.repository.UserRepository;
import com.gestor.projeto_engenharia_software.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        User user = UserMapper.mapToUser(userDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDTO(savedUser);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " not found"));
        return UserMapper.mapToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO updatedUserDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " not found"));
        user.setFirstName(updatedUserDTO.getFirstName());
        user.setLastName(updatedUserDTO.getLastName());
        user.setEmail(updatedUserDTO.getEmail());
        User updatedUser = userRepository.save(user);
        return UserMapper.mapToUserDTO(updatedUser);
    }

    @Override
    public UserDTO deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " not found"));
        userRepository.delete(user);
        return UserMapper.mapToUserDTO(user);
    }
}
