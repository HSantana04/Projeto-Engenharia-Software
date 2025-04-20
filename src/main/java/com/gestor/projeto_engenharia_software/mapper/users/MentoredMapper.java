package com.gestor.projeto_engenharia_software.mapper.users;

import com.gestor.projeto_engenharia_software.dto.users.MentoredDTO;
import com.gestor.projeto_engenharia_software.entity.users.Mentored;

public class MentoredMapper {

    public static MentoredDTO mapToMentoredDTO(Mentored mentored) {
        return new MentoredDTO(
                mentored.getId(),
                mentored.getName(),
                mentored.getEmail(),
                mentored.getPassword(),
                mentored.getRole(),
                mentored.getCreatedAt(),
                mentored.getUpdatedAt(),
                mentored.getRating()
        );
    }

    public static Mentored mapToMentored(MentoredDTO mentoredDTO) {
        return new Mentored(
                mentoredDTO.getId(),
                mentoredDTO.getName(),
                mentoredDTO.getEmail(),
                mentoredDTO.getPassword(),
                mentoredDTO.getRole(),
                mentoredDTO.getCreatedAt(),
                mentoredDTO.getUpdatedAt(),
                mentoredDTO.getRating()
        );
    }
}
