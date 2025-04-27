package com.gestor.projeto_engenharia_software.dto.users;

import jakarta.validation.constraints.*;

import java.util.List;

public record DadosCadastroMentor(
        @NotNull
        Long id,

        @NotBlank
        String name,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Size(min = 6)
        String password,

        List<String> areasOfActivity,

        String currentCompany,

        List<String> certificates,

        String occupation,



        String createdAt,

        String updatedAt
) {
}
