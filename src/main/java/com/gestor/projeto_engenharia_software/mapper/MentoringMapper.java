package com.gestor.projeto_engenharia_software.mapper;

import com.gestor.projeto_engenharia_software.dto.MentoringDTO;
import com.gestor.projeto_engenharia_software.entity.Mentoring;

public class MentoringMapper {

    public static MentoringDTO mapToMentoringDTO(Mentoring mentoring) {
        return new MentoringDTO(
                mentoring.getId(),
                mentoring.getName(),
                mentoring.getMentor_id(),
                mentoring.getMentored_id(),
                mentoring.getTopic_id(),
                mentoring.isConcluded(),
                mentoring.getScheduled_date(),
                mentoring.getCreated_date(),
                mentoring.getLast_update(),
                mentoring.getRating()
        );
    }

    public static Mentoring mapToMentoring(MentoringDTO mentoringDTO) {
        return new Mentoring(
                mentoringDTO.getId(),
                mentoringDTO.getName(),
                mentoringDTO.getMentorID(),
                mentoringDTO.getMentoredID(),
                mentoringDTO.getTopicID(),
                mentoringDTO.getConcluded(),
                mentoringDTO.getScheduledDate(),
                mentoringDTO.getCreatedAt(),
                mentoringDTO.getUpdatedAt(),
                mentoringDTO.getRating()
        );
    }
}
