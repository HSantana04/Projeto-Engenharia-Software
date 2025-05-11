package com.gestor.projeto_engenharia_software.repository;

import com.gestor.projeto_engenharia_software.entity.Mentoring;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MentoringRepository extends JpaRepository<Mentoring, Long> {
    Optional<Mentoring> findByName(String name);
}
