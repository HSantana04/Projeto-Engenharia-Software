package com.gestor.projeto_engenharia_software.repository.users;

import com.gestor.projeto_engenharia_software.entity.users.Mentored;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentoredRepository extends JpaRepository<Mentored, Long> {
}
