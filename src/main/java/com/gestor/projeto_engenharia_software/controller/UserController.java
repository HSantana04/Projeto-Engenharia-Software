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

import com.gestor.projeto_engenharia_software.dto.EmailRequestDTO;


@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        log.info("🔧 [POST] /users - Criando usuário: {}", userDTO);
        UserDTO savedUser = userService.createUser(userDTO);
        log.info("✅ Usuário criado com sucesso: {}", savedUser);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/search-by-email")  // rota clara, não conflita com {id}
    public ResponseEntity<UserDTO> getUserByEmail(@RequestBody EmailRequestDTO request) {
        log.info("📥 [POST] /users/search-by-email - Buscando usuário por email: {}", request.getEmail());
        UserDTO userDTO = userService.getUserByEmail(request.getEmail());

        if (userDTO == null) {
            return ResponseEntity.notFound().build();  // Retorna 404 se não encontrado
        }

        return ResponseEntity.ok(userDTO);
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

    @GetMapping("/role/{role}")
    public ResponseEntity<List<UserDTO>> getUsersByRole(@PathVariable String role) {
        log.info("📥 [GET] /users/role/{} - Buscando todos os usuários do papel: {}", role, role);
        List<UserDTO> userDTOs = userService.getUsersByRole(role);
        log.info("📦 Total de usuários encontrados: {}", userDTOs.size());
        return ResponseEntity.ok(userDTOs);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        log.info("📥 [GET] /users - Buscando todos os usuários");
        List<UserDTO> userDTOs = userService.getAllUsers();
        log.info("📦 Total de usuários encontrados: {}", userDTOs.size());
        return ResponseEntity.ok(userDTOs);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long userId) {
        log.info("🔍 [GET] /users/{} - Buscando usuário por ID", userId);
        UserDTO userDTO = userService.getUserById(userId);
        log.info("📦 Usuário encontrado: {}", userDTO);
        return ResponseEntity.ok(userDTO);
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

}
