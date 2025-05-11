package com.gestor.projeto_engenharia_software.service.users;

import com.gestor.projeto_engenharia_software.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO user);

    UserDTO getUserById(Long userId);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(Long userId, UserDTO updatedUser);

    UserDTO deleteUser(Long userId);
}
