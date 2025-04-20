package com.gestor.projeto_engenharia_software.service.users;

import com.gestor.projeto_engenharia_software.dto.users.ManagerDTO;

import java.util.List;

public interface ManagerService {
    ManagerDTO createManager(ManagerDTO user);

    ManagerDTO getManagerById(Long managerId);

    List<ManagerDTO> getAllManagers();

    ManagerDTO updateManager(Long managerId, ManagerDTO updatedManager);

    ManagerDTO deleteManager(Long managerId);
}
