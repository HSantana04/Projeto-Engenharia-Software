package com.gestor.projeto_engenharia_software.dto.users;

import jakarta.validation.constraints.*;

import java.util.List;

public record DadosAtualizarMentor(

        @NotNull
        Long id,


        String name,

        @Email
        String email,

        @NotBlank
        @Size(min = 6)
        String password,

        List<String> areasOfActivity,

        String currentCompany,

        List<String> certificates,

        String occupation,

        @Positive
        Float rating,


        String updatedAt
) {
}

