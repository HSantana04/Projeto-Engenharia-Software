package com.gestor.projeto_engenharia_software.mapper.users;

import com.gestor.projeto_engenharia_software.dto.users.MentorDTO;
import com.gestor.projeto_engenharia_software.entity.users.Mentor;

public class MentorMapper {

    public static MentorDTO mapToMentorDTO(Mentor mentor) {
        return new MentorDTO(
                mentor.getId(),
                mentor.getName(),
                mentor.getEmail(),
                mentor.getPassword(),
                mentor.getCurrentCompany(),
                mentor.getOccupation(),
                mentor.getRole(),
                mentor.getCreatedAt(),
                mentor.getUpdatedAt(),
                mentor.getRating()
        );
    }

    public static Mentor mapToMentor(MentorDTO mentorDTO) {
        return new Mentor(
                mentorDTO.getId(),
                mentorDTO.getName(),
                mentorDTO.getEmail(),
                mentorDTO.getPassword(),
                mentorDTO.getCurrentCompany(),
                mentorDTO.getOccupation(),
                mentorDTO.getRole(),
                mentorDTO.getCreatedAt(),
                mentorDTO.getUpdatedAt(),
                mentorDTO.getRating()
        );
    }
}
