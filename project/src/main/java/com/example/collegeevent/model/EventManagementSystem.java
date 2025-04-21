package com.example.collegeevent.model;
import java.util.ArrayList;
import java.util.List;

public class EventManagementSystem {
    private List<Event> events;
    private List<Event> approvedEvents = new ArrayList<>();


    public EventManagementSystem() {
        this.events = new ArrayList<>();
    }

    public void uploadEvent(Event event) {
    // Check if an event with the same ID already exists
    for (Event existingEvent : events) {
        if (existingEvent.getId() == event.getId()) {
            System.out.println("Error: Event with ID " + event.getId() + " already exists.");
            return; // Don't add the event if ID is duplicate
        }
    }

    // If no duplicate is found, add the event to the list
    events.add(event);
    System.out.println("Event uploaded: " + event);
}


    public void approveEvent(Event event) {
        if (!approvedEvents.contains(event)) {
        approvedEvents.add(event);
        }
    }

    public void rejectEvent(Event event) {
        events.remove(event);
        System.out.println("Event rejected: " + event);
    }

    public void sendPushNotification(Event event) {
        System.out.println("Push notification sent for event: " + event);
    }

    // ✅ Getter for events
    public List<Event> getEvents() {
        return events;
    }
    public List<Event> getApprovedEvents() {
        return approvedEvents;
    }
}
