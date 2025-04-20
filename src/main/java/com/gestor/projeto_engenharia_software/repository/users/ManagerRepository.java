package com.gestor.projeto_engenharia_software.repository.users;

import com.gestor.projeto_engenharia_software.entity.users.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
