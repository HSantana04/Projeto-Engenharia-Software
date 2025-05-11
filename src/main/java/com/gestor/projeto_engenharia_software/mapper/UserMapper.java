package com.gestor.projeto_engenharia_software.mapper;

import com.gestor.projeto_engenharia_software.dto.UserDTO;
import com.gestor.projeto_engenharia_software.entity.User;

public class UserMapper {

    public static UserDTO mapToUserDTO(User user) {
        return new UserDTO(
                user.getID(),
                user.getROLE(),
                user.getNAME(),
                user.getMAIL(),
                user.getPWD(),
                user.getAREAS_OF_ACTIVITY(),
                user.getCURRENT_COMPANY(),
                user.getCERTIFICATES(),
                user.getOCCUPATION(),
                user.getCREATED_DATE(),
                user.getLAST_UPDATE(),
                user.getRATING()
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
                userDTO.getOccupation(),
                userDTO.getRole(),
                userDTO.getCreatedAt(),
                userDTO.getUpdatedAt(),
                userDTO.getRating()
        );
    }
}
