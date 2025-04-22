package com.example.collegeevent.model;

import jakarta.persistence.*;

@Entity
public class Member extends User {

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    // Constructors
    public Member() {
    }

    public Member(String name, String email, String password, Club club) {
        super(name, email, password);
        this.club = club;
    }

    // Getters and Setters
    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}