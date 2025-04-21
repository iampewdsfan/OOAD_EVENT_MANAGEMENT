package com.example.collegeevent.model;
import java.util.ArrayList;
import java.util.List;

public class Club {
    private int id;
    private String name;
    private FacultyAdvisor facultyAdvisor;
    private List<Member> members;

    // ✅ Constructor with FacultyAdvisor
    public Club(int id, String name, FacultyAdvisor facultyAdvisor) {
        this.id = id;
        this.name = name;
        this.facultyAdvisor = facultyAdvisor;
        this.members = new ArrayList<>();
    }

    // ✅ Constructor without FacultyAdvisor
    public Club(int id, String name) {
        this.id = id;
        this.name = name;
        this.members = new ArrayList<>();
    }

    // ✅ Method to set FacultyAdvisor dynamically
    public void setFacultyAdvisor(FacultyAdvisor facultyAdvisor) {
        this.facultyAdvisor = facultyAdvisor;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public FacultyAdvisor getFacultyAdvisor() {
        return facultyAdvisor;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    @Override
    public String toString() {
        return "Club ID: " + id + ", Name: " + name + ", Members: " + members.size() +
                (facultyAdvisor != null ? ", Advisor: " + facultyAdvisor.getName() : "");
    }
}
