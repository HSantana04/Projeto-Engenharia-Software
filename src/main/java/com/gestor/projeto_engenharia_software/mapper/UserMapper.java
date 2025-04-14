package com.gestor.projeto_engenharia_software.mapper;

import com.gestor.projeto_engenharia_software.dto.UserDTO;
import com.gestor.projeto_engenharia_software.entity.User;

public class UserMapper {

    public static UserDTO mapToUserDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

    public static User mapToUser(UserDTO userDTO) {
        return new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail()
        );
    }
}
