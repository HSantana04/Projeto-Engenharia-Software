package com.gestor.projeto_engenharia_software.service.users;

import com.gestor.projeto_engenharia_software.dto.users.MentorDTO;
import com.gestor.projeto_engenharia_software.entity.users.Mentor;

import java.util.List;


public interface MentorService {
    MentorDTO createMentor(MentorDTO mentor);

    MentorDTO getMentorById(Long mentorId);

    List<Mentor> getAllMentors();

    MentorDTO updateMentor(Long mentorId, MentorDTO updatedMentor);

    MentorDTO deleteMentor(Long mentorId);
}
