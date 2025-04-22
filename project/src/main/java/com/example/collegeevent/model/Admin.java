package com.example.collegeevent.model;

import jakarta.persistence.Entity;

@Entity
public class Admin extends User {

    // You can add admin-specific fields here if needed

    public Admin() {
    }

    public Admin(String name, String email, String password) {
        super(name, email, password);
    }
}