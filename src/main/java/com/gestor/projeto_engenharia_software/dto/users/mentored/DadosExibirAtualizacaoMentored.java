package com.gestor.projeto_engenharia_software.dto.users.mentor;

import com.gestor.projeto_engenharia_software.entity.users.Mentor;
import jakarta.validation.constraints.*;

import java.util.List;

public record DadosExibirAtualizacaoMentor(@NotNull
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



                                           String updatedAt,

                                           @Positive
                                     float rating) {
    public DadosExibirAtualizacaoMentor(Mentor mentor) {
        this(
                mentor.getId(),
                mentor.getName(),
                mentor.getEmail(),
                mentor.getPassword(),
                mentor.getAreasOfActivity(),
                mentor.getCurrentCompany(),
                mentor.getCertificates(),
                mentor.getOccupation(),
                mentor.getUpdatedAt(),
                mentor.getRating()
        );
    }
}
