package com.example.collegeevent.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class FacultyAdvisor extends User {

    @OneToMany(mappedBy = "facultyAdvisor", cascade = CascadeType.ALL)
    private List<Club> clubs;

    public FacultyAdvisor() {
    }

    public FacultyAdvisor(String name, String email, String password) {
        super(name, email, password);
    }

    // Getters and Setters
    public List<Club> getClubs() {
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }
}