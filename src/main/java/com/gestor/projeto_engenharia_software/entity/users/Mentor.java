package com.gestor.projeto_engenharia_software.entity.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mentors")
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    // TODO: salvar áreas de atividade (collection)
    @Column
    private String currentCompany;
    // TODO: salvar certificados (collection)
    @Column
    private String occupation;
    @Column(nullable = false)
    private String role;
    @Column(nullable = false)
    private String createdAt;
    @Column(nullable = false)
    private String updatedAt;
    @Column(nullable = false)
    private float rating;

}
