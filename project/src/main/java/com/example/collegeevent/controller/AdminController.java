package com.example.collegeevent.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.collegeevent.model.Admin;
import com.example.collegeevent.model.Club;
import com.example.collegeevent.model.Event;
import com.example.collegeevent.model.EventManagementSystem;

@Controller
public class AdminController {

    private final EventManagementSystem ems = new EventManagementSystem();
    private final Admin admin = new Admin(ems);

    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("clubs", admin.getClubs());
        return "admin";
    }

    @GetMapping("/admin/addClub")
    public String addClubPage() {
        return "addclub";
    }

    @PostMapping("/admin/addClub")
    public String addClub(@RequestParam int id, @RequestParam String name) {
        Club club = new Club(id, name);
        admin.addClub(club);
        return "addclub";
    }

    @GetMapping("/admin/addEvent")
    public String addEventPage() {
        return "addevent";
    }
    @PostMapping("/admin/addEvent")
    public String addEvent(@RequestParam int id, @RequestParam String name, @RequestParam String date) {
        Event event = new Event(id, name, date);
        ems.uploadEvent(event);
        return "addevent";
    }


    @GetMapping("/admin/events")
    public String viewEvents(Model model) {
        model.addAttribute("events", ems.getEvents());
        return "viewevents";
    }
    @GetMapping("/admin/clubs")
    public String viewClubs(Model model) {
        model.addAttribute("clubs", admin.getClubs());
        return "viewclubs"; 
    }
    @PostMapping("/admin/approveEvent")
    public String approveEvent(@RequestParam int id) {
        for (Event e : ems.getEvents()) {
            if (e.getId() == id) {
                ems.approveEvent(e);
                break;
            }
        }
        return "redirect:/admin/events"; // Refresh the page
    }
    
    @GetMapping("/admin/approvedEvents")
    public String viewApprovedEvents(Model model) {
        model.addAttribute("events", ems.getApprovedEvents());
        return "approvedevents";
    }
}
