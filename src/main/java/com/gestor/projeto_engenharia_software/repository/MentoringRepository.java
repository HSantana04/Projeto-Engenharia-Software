package com.gestor.projeto_engenharia_software.repository;

import com.gestor.projeto_engenharia_software.entity.Mentoring;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MentoringRepository extends JpaRepository<Mentoring, Long> {
    List<Mentoring> findByMentored_id(Integer mentoredID);
}
