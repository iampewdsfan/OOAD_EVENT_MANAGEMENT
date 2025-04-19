package com.example.collegeevent.model;
public class Member {
    private int memberId;
    private String name;
    private int age;
    private String role;

    public Member(int memberId, String name, int age, String role) {
        this.memberId = memberId;
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public String toString() {
        return "Member ID: " + memberId + ", Name: " + name + ", Age: " + age + ", Role: " + role;
    }
}
