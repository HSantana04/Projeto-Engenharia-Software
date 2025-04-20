package com.gestor.projeto_engenharia_software.service.users.impl;

import com.gestor.projeto_engenharia_software.dto.users.ManagerDTO;
import com.gestor.projeto_engenharia_software.entity.users.Manager;
import com.gestor.projeto_engenharia_software.exception.ResourceNotFoundException;
import com.gestor.projeto_engenharia_software.mapper.users.ManagerMapper;
import com.gestor.projeto_engenharia_software.repository.users.ManagerRepository;
import com.gestor.projeto_engenharia_software.service.users.ManagerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private ManagerRepository managerRepository;

    @Override
    public ManagerDTO createManager(ManagerDTO managerDTO) {

        Manager manager = ManagerMapper.mapToManager(managerDTO);
        Manager savedManager = managerRepository.save(manager);
        return ManagerMapper.mapToManagerDTO(savedManager);
    }

    @Override
    public ManagerDTO getManagerById(Long managerId) {
        Manager manager = managerRepository.findById(managerId)
                .orElseThrow(() -> new ResourceNotFoundException("Manager with id " + managerId + " not found"));
        return ManagerMapper.mapToManagerDTO(manager);
    }

    @Override
    public List<ManagerDTO> getAllManagers() {
        List<Manager> managers = managerRepository.findAll();
        return managers.stream().map(ManagerMapper::mapToManagerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ManagerDTO updateManager(Long managerId, ManagerDTO updatedManagerDTO) {
        Manager manager = managerRepository.findById(managerId)
                .orElseThrow(() -> new ResourceNotFoundException("Manager with id " + managerId + " not found"));
        manager.setName(updatedManagerDTO.getName());
        manager.setEmail(updatedManagerDTO.getEmail());
        manager.setPassword(updatedManagerDTO.getPassword());
        Manager updatedManager = managerRepository.save(manager);
        return ManagerMapper.mapToManagerDTO(updatedManager);
    }

    @Override
    public ManagerDTO deleteManager(Long managerId) {
        Manager manager = managerRepository.findById(managerId)
                .orElseThrow(() -> new ResourceNotFoundException("Manager with id " + managerId + " not found"));
        managerRepository.delete(manager);
        return ManagerMapper.mapToManagerDTO(manager);
    }
}
