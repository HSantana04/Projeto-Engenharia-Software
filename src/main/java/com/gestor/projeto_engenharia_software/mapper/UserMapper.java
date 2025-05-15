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

    public static User mapToUser(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setRole(dto.getRole());
        user.setName(dto.getName());
        user.setMail(dto.getEmail());
        user.setPwd(dto.getPassword());
        user.setAreas_of_activity(dto.getAreasOfActivity());
        user.setCurrent_company(dto.getCurrentCompany());
        user.setCertificates(dto.getCertificates());
        user.setOccupation(dto.getOccupation());
        user.setCreated_date(dto.getCreatedAt());
        user.setLast_update(dto.getUpdatedAt());
        user.setRating(dto.getRating());
        return user;
    }
}
