package com.example.collegeevent.model;
public class FacultyAdvisor {
    private int facultyId;
    private String name;
    private String department;

    public FacultyAdvisor(int facultyId, String name, String department) {
        this.facultyId = facultyId;
        this.name = name;
        this.department = department;
    }

    // ✅ Getter method for name
    public String getName() {
        return name;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Faculty ID: " + facultyId + ", Name: " + name + ", Department: " + department;
    }
}
