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
    private Long id;
    @Column(nullable = false)
    private String role;
    @Column()
    private String name;
    @Column(nullable = false, unique = true)
    private String mail;
    @Column(nullable = false)
    private String pwd;
    @Column
    private String areas_of_activity;
    @Column
    private String current_company;
    @Column
    private String certificates;
    @Column
    private String occupation;
    @Column(nullable = false)
    private Instant created_date;
    @Column(nullable = false)
    private Instant last_update;
    @Column
    private Integer rating;

}
