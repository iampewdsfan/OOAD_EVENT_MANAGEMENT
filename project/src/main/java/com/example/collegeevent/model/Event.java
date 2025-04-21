package com.example.collegeevent.model;
public class Event {
    private int id;
    private String name;
    private String date;
    private String status;  // Add status field

    // Constructor
    public Event(int id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.status = "Pending";  // Default status
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Getter for Name
    public String getName() {
        return name;
    }

    // Getter for Date
    public String getDate() {
        return date;
    }

    // Getter for Status
    public String getStatus() {
        return status;
    }

    // Setter for Status
    public void setStatus(String status) {
        this.status = status;
    }

    // Method to approve the event
    public void approve() {
        this.status = "Approved";  // Change the status to "Approved"
    }

    // Method to reject the event
    public void reject() {
        this.status = "Rejected";  // Change the status to "Rejected"
    }

    @Override
    public String toString() {
        return "Event ID: " + id + ", Name: " + name + ", Date: " + date ;
    }
}
