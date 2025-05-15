package com.gestor.projeto_engenharia_software.controller;

import com.gestor.projeto_engenharia_software.dto.AuthDTO;
import com.gestor.projeto_engenharia_software.dto.UserDTO;
import com.gestor.projeto_engenharia_software.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
@Slf4j // Lombok cria o logger automaticamente
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        log.info("🔧 [POST] /users - Criando usuário: {}", userDTO);
        UserDTO savedUser = userService.createUser(userDTO);
        log.info("✅ Usuário criado com sucesso: {}", savedUser);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long userId) {
        log.info("🔍 [GET] /users/{} - Buscando usuário por ID", userId);
        UserDTO userDTO = userService.getUserById(userId);
        log.info("📦 Usuário encontrado: {}", userDTO);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        log.info("📥 [GET] /users - Buscando todos os usuários");
        List<UserDTO> userDTOs = userService.getAllUsers();
        log.info("📦 Total de usuários encontrados: {}", userDTOs.size());
        return ResponseEntity.ok(userDTOs);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long userId,
                                              @RequestBody UserDTO updatedUserDTO) {
        log.info("♻️ [PUT] /users/{} - Atualizando usuário com dados: {}", userId, updatedUserDTO);
        UserDTO userDTO = userService.updateUser(userId, updatedUserDTO);
        log.info("✅ Usuário atualizado: {}", userDTO);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        log.info("❌ [DELETE] /users/{} - Excluindo usuário", userId);
        UserDTO userDTO = userService.deleteUser(userId);
        log.info("🗑️ Usuário deletado: {}", userDTO);
        return ResponseEntity.ok("User deleted successfully. " + userDTO);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthDTO authDTO) {
        log.info("🔐 [POST] /users/authenticate - Autenticando usuário: {}", authDTO.getEmail());
        boolean authenticated = userService.authenticateUser(
                authDTO.getEmail(),
                authDTO.getPassword(),
                authDTO.getRole()
        );

        if (authenticated) {
            log.info("✅ Autenticação bem-sucedida para: {}", authDTO.getEmail());
            return ResponseEntity.ok("Authentication successful");
        } else {
            log.warn("❌ Falha na autenticação para: {}", authDTO.getEmail());
            return ResponseEntity.status(401).body("Invalid email, password or role");
        }
    }
}
