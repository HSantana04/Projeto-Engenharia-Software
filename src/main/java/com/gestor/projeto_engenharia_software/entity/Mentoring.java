package com.gestor.projeto_engenharia_software.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mentorings")
public class Mentoring {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer mentor_id;
    @Column(nullable = false)
    private Integer mentored_id;
    @Column(nullable = false)
    private Integer topic_id;
    @Column(nullable = false)
    private boolean concluded;
    @Column(nullable = false)
    private OffsetDateTime scheduled_date;
    @Column(nullable = false)
    private Instant created_date;
    @Column(nullable = false)
    private Instant last_update;
    @Column
    private Integer rating;


}
