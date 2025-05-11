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
import java.util.Optional;
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
                .orElseThrow(() -> new ResourceNotFoundException("Mentoring with id " + mentoringId + " not found"));
        mentoring.setName(updatedMentoringDTO.getName());
        mentoring.setMail(updatedMentoringDTO.getEmail());
        mentoring.setPwd(updatedMentoringDTO.getPassword());
        mentoring.setLast_update(Instant.now());
        Mentoring updatedMentoring = mentoringRepository.save(mentoring);
        return MentoringMapper.mapToMentoringDTO(updatedMentoring);
    }

    @Override
    public MentoringDTO deleteMentoring(Long mentoringId) {
        Mentoring mentoring = mentoringRepository.findById(mentoringId)
                .orElseThrow(() -> new ResourceNotFoundException("Mentoring with id " + mentoringId + " not found"));
        mentoringRepository.delete(mentoring);
        return MentoringMapper.mapToMentoringDTO(mentoring);
    }

    @Override
    public MentoringDTO getMentoringByMentoredId(Integer mentoredId) {
        return null;
    }
}
