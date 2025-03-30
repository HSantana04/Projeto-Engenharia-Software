package com.gestor.projeto_engenharia_software.controller;

import com.gestor.projeto_engenharia_software.Mentor.Mentor;
import com.gestor.projeto_engenharia_software.Mentor.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class MentorController {

    @Autowired
    private MentorRepository repository;

    @GetMapping
    public List<Mentor> getAll(){
        List<Mentor> mentorList = repository.findAll();
        return mentorList;
    }
}
