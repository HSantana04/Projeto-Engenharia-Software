package com.gestor.projeto_engenharia_software.controller;


import com.gestor.projeto_engenharia_software.dto.UserDTO;
import com.gestor.projeto_engenharia_software.entity.User;
import com.gestor.projeto_engenharia_software.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO savedUser = userService.createUser(userDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long userId) {
        UserDTO userDTO = userService.getUserById(userId);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOs = userService.getAllUsers();
        return ResponseEntity.ok(userDTOs);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long userId,
                                              @RequestBody UserDTO updatedUserDTO) {
        UserDTO userDTO = userService.updateUser(userId, updatedUserDTO);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted sucessfully.");
    }

}
