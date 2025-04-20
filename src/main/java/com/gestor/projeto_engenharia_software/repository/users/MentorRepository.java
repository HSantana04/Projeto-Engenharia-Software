package com.gestor.projeto_engenharia_software.repository.users;

import com.gestor.projeto_engenharia_software.entity.users.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
}
