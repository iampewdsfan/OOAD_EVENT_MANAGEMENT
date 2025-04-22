package com.example.collegeevent.controller;

import com.example.collegeevent.model.Club;
import com.example.collegeevent.model.Event;
import com.example.collegeevent.repository.ClubRepository;
import com.example.collegeevent.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ClubRepository clubRepository;

    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("clubs", clubRepository.findAll());
        return "admin";
    }

    @GetMapping("/admin/addClub")
    public String addClubPage() {
        return "addclub";
    }

    @PostMapping("/admin/addClub")
    public String addClub(@RequestParam String name) {
        Club club = new Club();
        club.setName(name);
        clubRepository.save(club);
        return "addclub";
    }

    @GetMapping("/admin/addEvent")
    public String addEventPage() {
        return "addevent";
    }

    @PostMapping("/admin/addEvent")
    public String addEvent(@RequestParam String name, @RequestParam String date) {
        Event event = new Event();
        event.setName(name);
        event.setDate(date);
        event.setApproved(false);
        eventRepository.save(event);
        return "addevent";
    }

    @GetMapping("/admin/events")
    public String viewEvents(Model model) {
        List<Event> events = eventRepository.findAll();
        model.addAttribute("events", events);
        return "viewevents";
    }

    @GetMapping("/admin/clubs")
    public String viewClubs(Model model) {
        model.addAttribute("clubs", clubRepository.findAll());
        return "viewclubs";
    }

    @PostMapping("/admin/approveEvent")
    public String approveEvent(@RequestParam Long id) {
        Event event = eventRepository.findById(id).orElse(null);
        if (event != null) {
            event.setApproved(true);
            eventRepository.save(event);
        }
        return "redirect:/admin/events";
    }

    @GetMapping("/admin/approvedEvents")
    public String viewApprovedEvents(Model model) {
        List<Event> approvedEvents = eventRepository.findByApproved(true);
        model.addAttribute("events", approvedEvents);
        return "approvedevents";
    }
}