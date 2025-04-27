package com.gestor.projeto_engenharia_software.dto.users;

import com.gestor.projeto_engenharia_software.entity.users.Mentor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.List;


public record MentorDTO(
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

        String updatedAt,

        @Positive
        float rating
) {
    public MentorDTO(Mentor mentor) {
        this(
                mentor.getId(),
                mentor.getName(),
                mentor.getEmail(),
                mentor.getPassword(),
                mentor.getAreasOfActivity(),
                mentor.getCurrentCompany(),
                mentor.getCertificates(),
                mentor.getOccupation(),
                mentor.getCreatedAt(),
                mentor.getUpdatedAt(),
                mentor.getRating()
        );
    }
}

