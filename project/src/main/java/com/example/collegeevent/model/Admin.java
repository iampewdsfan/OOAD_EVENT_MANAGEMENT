package com.example.collegeevent.model;
import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Club> clubs;
    private EventManagementSystem ems;

    public Admin(EventManagementSystem ems) {
        this.clubs = new ArrayList<>();
        this.ems = ems;
    }

    public void addClub(Club club) {
        clubs.add(club);
        System.out.println("Club added: " + club);
    }
    
    public void addEvent(Club club) {
        clubs.add(club);
        System.out.println("Club added: " + club);
    }

    public void removeClub(Club club) {
        clubs.remove(club);
        System.out.println("Club removed: " + club);
    }

    public void listClubs() {
        System.out.println("Listing clubs:");
        for (Club club : clubs) {
            System.out.println(club);
        }
    }
    public List<Club> getClubs() {
        return clubs;
    }
    
}

