package com.gestor.projeto_engenharia_software.entity.users;

import com.gestor.projeto_engenharia_software.dto.users.DadosAtualizarMentor;
import com.gestor.projeto_engenharia_software.dto.users.DadosCadastroMentor;
import com.gestor.projeto_engenharia_software.dto.users.ManagerDTO;
import com.gestor.projeto_engenharia_software.dto.users.MentorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mentors")
public class Mentor {
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCurrentCompany() {
        return currentCompany;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getRole() {
        return role;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public float getRating() {
        return rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCurrentCompany(String currentCompany) {
        this.currentCompany = currentCompany;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setAreasOfActivity(List<String> areasOfActivity) {
        this.areasOfActivity = areasOfActivity;
    }

    public void setCertificates(List<String> certificates) {
        this.certificates = certificates;
    }

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
    private Float rating;
    @ElementCollection
    private List<String> areasOfActivity;

    @ElementCollection
    private List<String> certificates;

    public List<String> getAreasOfActivity() {
        return areasOfActivity;
    }

    public List<String> getCertificates() {
        return certificates;
    }

    public Mentor(DadosCadastroMentor dados) {
        this.id = dados.id();
        this.name = dados.name();
        this.email = dados.email();
        this.password = dados.password();
        this.currentCompany = dados.currentCompany();
        this.occupation = dados.occupation();
        this.role = "mentor";
        this.createdAt = String.valueOf(LocalDateTime.now());
        this.updatedAt = String.valueOf(LocalDateTime.now());
        this.rating = 0f;
        this.areasOfActivity = dados.areasOfActivity();

    }

    public void atualizarInformacoes(DadosAtualizarMentor dados) {
        if (dados.name() != null) {
            this.name = dados.name();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.password() != null) {
            this.password = dados.password();
        }
        if (dados.areasOfActivity() != null) {
            this.areasOfActivity = dados.areasOfActivity();
        }
        if (dados.currentCompany() != null) {
            this.currentCompany = dados.currentCompany();
        }
        if (dados.certificates() != null) {
            this.certificates = dados.certificates();
        }
        if (dados.occupation() != null) {
            this.occupation = dados.occupation();
        }
        if (dados.rating() != null) {
            this.rating = dados.rating();
        }

        this.updatedAt = String.valueOf(LocalDateTime.now());

    }


}
