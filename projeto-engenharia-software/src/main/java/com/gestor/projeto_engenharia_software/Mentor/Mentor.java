package com.gestor.projeto_engenharia_software.Mentor;

import jakarta.persistence.*;

import javax.swing.*;
import java.util.List;

@Table(name = "Mentor")
@Entity(name = "Mentor")
public class Mentor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String password;

    @Column(name = "area_of_activity")
    private List<String> areasOfActivity;

    @Column(name = "current_company")
    private String currentCompany;

    @Column(name = "certificate")
    private List<String> certificates;

    @Column(nullable = false)
    private String occupation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getAreasOfActivity() {
        return areasOfActivity;
    }

    public void setAreasOfActivity(List<String> areasOfActivity) {
        this.areasOfActivity = areasOfActivity;
    }

    public String getCurrentCompany() {
        return currentCompany;
    }

    public void setCurrentCompany(String currentCompany) {
        this.currentCompany = currentCompany;
    }

    public List<String> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<String> certificates) {
        this.certificates = certificates;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
