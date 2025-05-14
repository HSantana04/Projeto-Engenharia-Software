package com.gestor.projeto_engenharia_software.controller;

import com.gestor.projeto_engenharia_software.dto.MentoringDTO;
import com.gestor.projeto_engenharia_software.service.MentoringService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/mentorings")
public class MentoringController {

    private MentoringService mentoringService;

    @PostMapping
    public ResponseEntity<MentoringDTO> createMentoring(@RequestBody MentoringDTO mentoringDTO) {
        MentoringDTO savedMentoring = mentoringService.createMentoring(mentoringDTO);
        return new ResponseEntity<>(savedMentoring, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MentoringDTO> getMentoringById(@PathVariable("id") Long mentoringId) {
        MentoringDTO mentoringDTO = mentoringService.getMentoringById(mentoringId);
        return ResponseEntity.ok(mentoringDTO);
    }

    @GetMapping
    public ResponseEntity<List<MentoringDTO>> getAllMentorings() {
        List<MentoringDTO> mentoringDTOs = mentoringService.getAllMentorings();
        return ResponseEntity.ok(mentoringDTOs);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<MentoringDTO> updateMentoring(@PathVariable("id") Long mentoringId,
                                                 @RequestBody MentoringDTO updatedMentoringDTO) {
        MentoringDTO mentoringDTO = mentoringService.updateMentoring(mentoringId, updatedMentoringDTO);
        return ResponseEntity.ok(mentoringDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMentoring(@PathVariable("id") Long mentoringId) {
        MentoringDTO mentoringDTO = mentoringService.deleteMentoring(mentoringId);
        return ResponseEntity.ok("Mentoring deleted successfully." + mentoringDTO);
    }
}
