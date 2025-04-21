package com.example.collegeevent.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int userId;
    private String name;
    private List<String> subscribedTags;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.subscribedTags = new ArrayList<>();
    }

    public void subscribeToClub(Club club) {
        System.out.println(name + " subscribed to club: " + club);
    }

    public void subscribeToTag(String tag) {
        subscribedTags.add(tag);
        System.out.println(name + " subscribed to tag: " + tag);
    }

    public void viewEventTimeline() {
        System.out.println(name + " is viewing the event timeline...");
    }

    public void receiveNotifications() {
        System.out.println(name + " is receiving notifications...");
    }
}
