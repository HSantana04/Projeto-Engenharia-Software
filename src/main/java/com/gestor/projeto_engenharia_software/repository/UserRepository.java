package com.gestor.projeto_engenharia_software.repository;

import com.gestor.projeto_engenharia_software.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
