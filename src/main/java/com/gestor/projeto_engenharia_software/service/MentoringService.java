package com.gestor.projeto_engenharia_software.service;

import com.gestor.projeto_engenharia_software.dto.MentoringDTO;
import com.gestor.projeto_engenharia_software.entity.Mentoring;

import java.util.List;

public interface MentoringService {
    MentoringDTO createMentoring(MentoringDTO user);

    MentoringDTO getMentoringById(Long userId);

    List<MentoringDTO> getAllMentorings();

    MentoringDTO updateMentoring(Long userId, MentoringDTO updatedMentoring);

    MentoringDTO deleteMentoring(Long userId);

    List<Mentoring> getMentoringByMentoredId(Integer mentoredId);
}
