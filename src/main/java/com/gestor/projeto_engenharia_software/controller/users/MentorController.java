package com.gestor.projeto_engenharia_software.controller.users;

import com.gestor.projeto_engenharia_software.dto.users.DadosAtualizarMentor;
import com.gestor.projeto_engenharia_software.dto.users.DadosCadastroMentor;
import com.gestor.projeto_engenharia_software.dto.users.DadosExibirAtualizacao;
import com.gestor.projeto_engenharia_software.dto.users.MentorDTO;
import com.gestor.projeto_engenharia_software.entity.users.Mentor;
import com.gestor.projeto_engenharia_software.repository.users.MentorRepository;
import com.gestor.projeto_engenharia_software.service.users.MentorService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users/mentor")
@Setter
@Getter
public class MentorController {

    @Autowired
    private MentorRepository repository;

    @Autowired
    private MentorService mentorService;

    @Transactional
    @PostMapping
    public ResponseEntity<MentorDTO> cadastrarMentor(@RequestBody DadosCadastroMentor dados, UriComponentsBuilder uriBuilder){
        var mentor = new Mentor(dados);
        mentor.setRole("mentor");
        repository.save(mentor);
        MentorDTO savedMentor = mentorService.createMentor(new MentorDTO(mentor));
        return new ResponseEntity<>(savedMentor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MentorDTO> buscarMentorPorId(@PathVariable Long id) {
        MentorDTO mentor = mentorService.getMentorById(id);
        return ResponseEntity.ok(mentor);
    }

    @GetMapping
    public ResponseEntity<List<MentorDTO>> listar() {
        // Buscar todos os médicos ativos
        List<Mentor> mentors = repository.findAll(); // Ou repository.findAll() se não tiver o filtro de 'ativo'

        // Mapear para DadosListagemMedico
        List<MentorDTO> MentorDTO = mentors.stream()
                .map(MentorDTO::new)
                .collect(Collectors.toList());
        System.out.println(MentorDTO);

        return ResponseEntity.ok(MentorDTO);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody DadosAtualizarMentor dados){
        var mentor = repository.getReferenceById(id);
        mentor.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosExibirAtualizacao(mentor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        var mentor = repository.getReferenceById(id);
        repository.delete(mentor);
        return ResponseEntity.noContent().build();
    }

}
