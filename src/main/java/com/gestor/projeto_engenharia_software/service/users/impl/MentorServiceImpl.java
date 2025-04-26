package com.gestor.projeto_engenharia_software.service.users.impl;

import com.gestor.projeto_engenharia_software.dto.users.MentorDTO;
import com.gestor.projeto_engenharia_software.entity.users.Mentor;
import com.gestor.projeto_engenharia_software.repository.users.MentorRepository;
import com.gestor.projeto_engenharia_software.service.users.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorServiceImpl implements MentorService {

    @Autowired
    private MentorRepository repository;

    @Override
    public MentorDTO createMentor(MentorDTO mentor) {
        // sua lógica aqui
        return mentor;
    }

    @Override
    public MentorDTO getMentorById(Long mentorId) {
        Mentor mentor = repository.findById(mentorId)
                .orElseThrow(() -> new RuntimeException("Mentor não encontrado"));

        return new MentorDTO(mentor);
    }

    @Override
    public List<Mentor> getAllMentors() {
        // Buscar todos os mentores do banco de dados
        List<Mentor> mentors = repository.findAll();
        System.out.println(mentors);

        // Converter cada Mentor para MentorDTO
        return mentors;
    }

    @Override
    public MentorDTO updateMentor(Long mentorId, MentorDTO updatedMentor) {
        return updatedMentor;
    }

    @Override
    public MentorDTO deleteMentor(Long mentorId) {
        return null;
    }
}
