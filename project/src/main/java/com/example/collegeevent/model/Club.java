package com.example.collegeevent.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    private List<Event> events;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    private List<Member> members;

    @ManyToOne
    @JoinColumn(name = "faculty_advisor_id")
    private FacultyAdvisor facultyAdvisor;

    // Constructors
    public Club() {
    }

    public Club(String name, FacultyAdvisor facultyAdvisor) {
        this.name = name;
        this.facultyAdvisor = facultyAdvisor;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public FacultyAdvisor getFacultyAdvisor() {
        return facultyAdvisor;
    }

    public void setFacultyAdvisor(FacultyAdvisor facultyAdvisor) {
        this.facultyAdvisor = facultyAdvisor;
    }
}