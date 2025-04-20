package com.gestor.projeto_engenharia_software.service.users;

import com.gestor.projeto_engenharia_software.dto.users.MentorDTO;

import java.util.List;

public interface MentorService {
    MentorDTO createMentor(MentorDTO mentor);

    MentorDTO getMentorById(Long mentorId);

    List<MentorDTO> getAllMentors();

    MentorDTO updateMentor(Long mentorId, MentorDTO updatedMentor);

    MentorDTO deleteMentor(Long mentorId);
}
