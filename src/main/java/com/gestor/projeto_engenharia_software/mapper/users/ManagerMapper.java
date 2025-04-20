package com.gestor.projeto_engenharia_software.mapper.users;

import com.gestor.projeto_engenharia_software.dto.users.ManagerDTO;
import com.gestor.projeto_engenharia_software.entity.users.Manager;

public class ManagerMapper {

    public static ManagerDTO mapToManagerDTO(Manager manager) {
        return new ManagerDTO(
                manager.getId(),
                manager.getName(),
                manager.getEmail(),
                manager.getPassword(),
                manager.getRole(),
                manager.getCreatedAt(),
                manager.getUpdatedAt()
        );
    }

    public static Manager mapToManager(ManagerDTO managerDTO) {
        return new Manager(
                managerDTO.getId(),
                managerDTO.getName(),
                managerDTO.getEmail(),
                managerDTO.getPassword(),
                managerDTO.getRole(),
                managerDTO.getCreatedAt(),
                managerDTO.getUpdatedAt()
        );
    }
}
