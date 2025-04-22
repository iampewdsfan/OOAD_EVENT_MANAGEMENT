package com.example.collegeevent.repository;

import com.example.collegeevent.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    // Method to find events by their approval status
    List<Event> findByApproved(boolean approved);
}