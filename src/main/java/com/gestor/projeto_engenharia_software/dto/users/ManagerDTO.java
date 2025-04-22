package com.gestor.projeto_engenharia_software.dto.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ManagerDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private Instant createdAt;
    private Instant updatedAt;
}
