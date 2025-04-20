package com.gestor.projeto_engenharia_software.dto.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MentorDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    // TODO: areasOfActivity
    private String currentCompany;
    // TODO: certificates
    private String occupation;
    private String role;
    private String createdAt;
    private String updatedAt;
    private float rating;
}
