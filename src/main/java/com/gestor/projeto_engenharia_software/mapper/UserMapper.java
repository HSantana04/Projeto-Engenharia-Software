package com.gestor.projeto_engenharia_software.mapper;

import com.gestor.projeto_engenharia_software.dto.UserDTO;
import com.gestor.projeto_engenharia_software.entity.User;

public class UserMapper {

    public static UserDTO mapToUserDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getRole(),
                user.getName(),
                user.getMail(),
                user.getPwd(),
                user.getAreas_of_activity(),
                user.getCurrent_company(),
                user.getCertificates(),
                user.getOccupation(),
                user.getCreated_date(),
                user.getLast_update(),
                user.getRating()
        );
    }

    public static User mapToUser(UserDTO userDTO) {
        return new User(
                userDTO.getId(),
                userDTO.getRole(),
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getAreasOfActivity(),
                userDTO.getCurrentCompany(),
                userDTO.getCertificates(),
                userDTO.getOccupation(),
                userDTO.getCreatedAt(),
                userDTO.getUpdatedAt(),
                userDTO.getRating()
        );
    }
}
