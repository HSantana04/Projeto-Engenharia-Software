package com.gestor.projeto_engenharia_software.service.users;

import com.gestor.projeto_engenharia_software.dto.users.MentoredDTO;

import java.util.List;

public interface MentoredService {
    MentoredDTO createMentored(MentoredDTO mentored);

    MentoredDTO getMentoredById(Long mentoredId);

    List<MentoredDTO> getAllMentoreds();

    MentoredDTO updateMentored(Long mentoredId, MentoredDTO updatedMentored);

    MentoredDTO deleteMentored(Long mentoredId);
}
