package com.gestor.projeto_engenharia_software.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String role;
    private String name;
    private String email;
    private String password;
    private String areasOfActivity;
    private String currentCompany;
    private String certificates;
    private String occupation;
    private Instant createdAt;
    private Instant updatedAt;
    private Integer rating;
}
