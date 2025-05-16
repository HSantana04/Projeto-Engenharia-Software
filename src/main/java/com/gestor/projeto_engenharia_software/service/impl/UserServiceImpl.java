package com.gestor.projeto_engenharia_software.service.impl;

import com.gestor.projeto_engenharia_software.dto.UserDTO;
import com.gestor.projeto_engenharia_software.entity.User;
import com.gestor.projeto_engenharia_software.exception.ResourceNotFoundException;
import com.gestor.projeto_engenharia_software.mapper.UserMapper;
import com.gestor.projeto_engenharia_software.repository.UserRepository;
import com.gestor.projeto_engenharia_software.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        log.info("🛠️ Criando novo usuário: {}", userDTO);

        userDTO.setCreatedAt(Instant.now());
        userDTO.setUpdatedAt(Instant.now());

        log.debug("🔐 Codificando senha...");
        String hashedPassword = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(hashedPassword);

        User user = UserMapper.mapToUser(userDTO);
        log.debug("📦 Entidade User mapeada: {}", user);

        User savedUser = userRepository.save(user);
        log.info("✅ Usuário salvo com sucesso: {}", savedUser);

        return UserMapper.mapToUserDTO(savedUser);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        log.info("🔍 Buscando usuário com ID: {}", userId);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    log.warn("❌ Usuário com ID {} não encontrado", userId);
                    return new ResourceNotFoundException("User with id " + userId + " not found");
                });

        log.info("✅ Usuário encontrado: {}", user);
        return UserMapper.mapToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        log.info("📥 Buscando todos os usuários...");
        List<User> users = userRepository.findAll();
        log.info("📦 Total de usuários encontrados: {}", users.size());
        return users.stream().map(UserMapper::mapToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO updatedUserDTO) {
        log.info("♻️ Atualizando usuário com ID: {}", userId);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    log.warn("❌ Usuário com ID {} não encontrado para atualização", userId);
                    return new RuntimeException("Usuário não encontrado");
                });

        log.debug("📤 Dados recebidos para atualização: {}", updatedUserDTO);

        if (updatedUserDTO.getRole() != null) user.setRole(updatedUserDTO.getRole());
        if (updatedUserDTO.getName() != null) user.setName(updatedUserDTO.getName());
        if (updatedUserDTO.getEmail() != null) user.setMail(updatedUserDTO.getEmail());
        if (updatedUserDTO.getPassword() != null) {
            log.debug("🔐 Atualizando senha...");
            user.setPwd(passwordEncoder.encode(updatedUserDTO.getPassword()));
        }
        if (updatedUserDTO.getAreasOfActivity() != null) user.setAreas_of_activity(updatedUserDTO.getAreasOfActivity());
        if (updatedUserDTO.getCurrentCompany() != null) user.setCurrent_company(updatedUserDTO.getCurrentCompany());
        if (updatedUserDTO.getCertificates() != null) user.setCertificates(updatedUserDTO.getCertificates());
        if (updatedUserDTO.getOccupation() != null) user.setOccupation(updatedUserDTO.getOccupation());
        if (updatedUserDTO.getRating() != null) user.setRating(updatedUserDTO.getRating());

        user.setLast_update(Instant.now());

        User updatedUser = userRepository.save(user);
        log.info("✅ Usuário atualizado: {}", updatedUser);

        return UserMapper.mapToUserDTO(updatedUser);
    }

    @Override
    public UserDTO deleteUser(Long userId) {
        log.info("🗑️ Deletando usuário com ID: {}", userId);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    log.warn("❌ Usuário com ID {} não encontrado para exclusão", userId);
                    return new ResourceNotFoundException("User with id " + userId + " not found");
                });

        userRepository.delete(user);
        log.info("✅ Usuário deletado com sucesso: {}", user);
        return UserMapper.mapToUserDTO(user);
    }

    @Override
    public boolean authenticateUser(String email, String password, String role) {
        log.info("🔐 Autenticando usuário com e-mail: {} e role: {}", email, role);

        Optional<User> userOptional = userRepository.findByMail(email);

        if (userOptional.isEmpty()) {
            log.warn("❌ Usuário com e-mail {} não encontrado", email);
            return false;
        }

        User user = userOptional.get();

        if (!passwordEncoder.matches(password, user.getPwd())) {
            log.warn("❌ Senha inválida para e-mail: {}", email);
            return false;
        }

        if (!user.getRole().equals(role)) {
            log.warn("❌ Role inválida para e-mail: {}. Esperado: {}, Recebido: {}", email, user.getRole(), role);
            return false;
        }

        log.info("✅ Autenticação bem-sucedida para usuário: {}", email);
        return true;
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByMail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o e-mail: " + email));

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setRole(user.getRole());
        dto.setName(user.getName());
        dto.setEmail(user.getMail());
        dto.setPassword("");
        dto.setAreasOfActivity(user.getAreas_of_activity());
        dto.setCurrentCompany(user.getCurrent_company());
        dto.setCertificates(user.getCertificates());
        dto.setOccupation(user.getOccupation());
        dto.setCreatedAt(user.getCreated_date());
        dto.setUpdatedAt(user.getLast_update());
        dto.setRating(user.getRating());

        return dto;
    }
}