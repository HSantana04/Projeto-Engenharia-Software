package com.gestor.projeto_engenharia_software.service.impl;

import com.gestor.projeto_engenharia_software.dto.MentoringDTO;
import com.gestor.projeto_engenharia_software.entity.Mentoring;
import com.gestor.projeto_engenharia_software.exception.ResourceNotFoundException;
import com.gestor.projeto_engenharia_software.mapper.MentoringMapper;
import com.gestor.projeto_engenharia_software.repository.MentoringRepository;
import com.gestor.projeto_engenharia_software.service.MentoringService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MentoringServiceImpl implements MentoringService {

    private MentoringRepository mentoringRepository;

    @Override
    public MentoringDTO createMentoring(MentoringDTO mentoringDTO) {
        mentoringDTO.setCreatedAt(Instant.now());
        mentoringDTO.setUpdatedAt(Instant.now());
        Mentoring mentoring = MentoringMapper.mapToMentoring(mentoringDTO);
        Mentoring savedMentoring = mentoringRepository.save(mentoring);
        return MentoringMapper.mapToMentoringDTO(savedMentoring);
    }

    @Override
    public MentoringDTO getMentoringById(Long mentoringId) {
        Mentoring mentoring = mentoringRepository.findById(mentoringId)
                .orElseThrow(() -> new ResourceNotFoundException("Mentoring with id " + mentoringId + " not found"));
        return MentoringMapper.mapToMentoringDTO(mentoring);
    }

    @Override
    public List<MentoringDTO> getAllMentorings() {
        List<Mentoring> mentorings = mentoringRepository.findAll();
        return mentorings.stream().map(MentoringMapper::mapToMentoringDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MentoringDTO updateMentoring(Long mentoringId, MentoringDTO updatedMentoringDTO) {
        Mentoring mentoring = mentoringRepository.findById(mentoringId)
                .orElseThrow(() -> new RuntimeException("Mentoria não encontrada"));

        if (updatedMentoringDTO.getName() != null) mentoring.setName(updatedMentoringDTO.getName());
        if (updatedMentoringDTO.getMentorID() != null) mentoring.setMentor_id(updatedMentoringDTO.getMentorID());
        if (updatedMentoringDTO.getMentoredID() != null) mentoring.setMentored_id(updatedMentoringDTO.getMentoredID());
        if (updatedMentoringDTO.getTopicID() != null) mentoring.setTopic_id(updatedMentoringDTO.getTopicID());
        if (updatedMentoringDTO.getConcluded() != null) mentoring.setConcluded(updatedMentoringDTO.getConcluded());
        if (updatedMentoringDTO.getScheduledDate() != null) mentoring.setScheduled_date(updatedMentoringDTO.getScheduledDate());
        mentoring.setLast_update(Instant.now());
        if (updatedMentoringDTO.getRating() != null) mentoring.setRating(updatedMentoringDTO.getRating());

        return MentoringMapper.mapToMentoringDTO((mentoringRepository.save(mentoring)));
    }

    @Override
    public MentoringDTO deleteMentoring(Long mentoringId) {
        Mentoring mentoring = mentoringRepository.findById(mentoringId)
                .orElseThrow(() -> new ResourceNotFoundException("Mentoring with id " + mentoringId + " not found"));
        mentoringRepository.delete(mentoring);
        return MentoringMapper.mapToMentoringDTO(mentoring);
    }

    @Override
    public List<Mentoring> getMentoringByMentoredId(Integer mentoredId) {
        return mentoringRepository.findByMentored_id(mentoredId);
    }
}
