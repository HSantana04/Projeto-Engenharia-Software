package com.gestor.projeto_engenharia_software.controller.users;


import com.gestor.projeto_engenharia_software.dto.users.ManagerDTO;
import com.gestor.projeto_engenharia_software.entity.users.Manager;
import com.gestor.projeto_engenharia_software.entity.users.Mentor;
import com.gestor.projeto_engenharia_software.repository.users.ManagerRepository;
import com.gestor.projeto_engenharia_software.service.users.ManagerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users/manager")
public class ManagerController {

    @Autowired
    private ManagerRepository repository;

    @Autowired
    private ManagerService managerService;

    @PostMapping
    public ResponseEntity<ManagerDTO> createManager(@RequestBody ManagerDTO managerDTO) {
        var manager = new Manager(managerDTO);
        manager.setRole("manager");
        repository.save(manager);
        ManagerDTO savedManager = managerService.createManager(managerDTO);
        return new ResponseEntity<>(savedManager, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<ManagerDTO> getManagerById(@PathVariable("id") Long managerId) {
        ManagerDTO managerDTO = managerService.getManagerById(managerId);
        return ResponseEntity.ok(managerDTO);
    }

    @GetMapping
    public ResponseEntity<List<ManagerDTO>> getAllManagers() {
        List<ManagerDTO> userDTOs = managerService.getAllManagers();
        return ResponseEntity.ok(userDTOs);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<ManagerDTO> updateManager(@PathVariable("id") Long managerId,
                                                 @RequestBody ManagerDTO updatedManagerDTO) {
        ManagerDTO managerDTO = managerService.updateManager(managerId, updatedManagerDTO);
        return ResponseEntity.ok(managerDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteManager(@PathVariable("id") Long managerId) {
        managerService.deleteManager(managerId);
        return ResponseEntity.ok("Manager deleted sucessfully.");
    }

}
