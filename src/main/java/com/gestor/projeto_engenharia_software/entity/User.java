package com.gestor.projeto_engenharia_software.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(nullable = false)
    private String ROLE;
    @Column(nullable = false)
    private String NAME;
    @Column(nullable = false, unique = true)
    private String MAIL;
    @Column(nullable = false)
    private String PWD;
    @Column
    private String AREAS_OF_ACTIVITY;
    @Column
    private String CURRENT_COMPANY;
    @Column
    private String CERTIFICATES;
    @Column
    private String OCCUPATION;
    @Column(nullable = false)
    private Instant CREATED_DATE;
    @Column(nullable = false)
    private Instant LAST_UPDATE;
    @Column
    private Integer RATING;

}
