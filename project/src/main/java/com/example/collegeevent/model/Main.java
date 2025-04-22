package com.example.collegeevent.model;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.collegeevent.repository.ClubRepository;
import com.example.collegeevent.repository.EventRepository;
import com.example.collegeevent.repository.FacultyAdvisorRepository;

@Component
public class Main implements CommandLineRunner {

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private FacultyAdvisorRepository facultyAdvisorRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Event Management System ===");
            System.out.println("1. Add Club");
            System.out.println("2. Remove Club");
            System.out.println("3. List Clubs");
            System.out.println("4. Add Faculty Advisor");
            System.out.println("5. Remove Faculty Advisor");
            System.out.println("6. List Faculty Advisors");
            System.out.println("7. Assign Faculty Advisor to Club");
            System.out.println("8. Add Event");
            System.out.println("9. Approve Event");
            System.out.println("10. Reject Event");
            System.out.println("11. Send Notification");
            System.out.println("12. List Events");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Club Name: ");
                    String clubName = scanner.nextLine();
                    clubRepository.save(new Club(clubName, null));
                    System.out.println("Club added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Club ID to remove: ");
                    Long removeClubId = scanner.nextLong();
                    clubRepository.deleteById(removeClubId);
                    System.out.println("Club removed successfully!");
                    break;

                case 3:
                    System.out.println("\n--- Clubs ---");
                    clubRepository.findAll().forEach(club ->
                            System.out.println(club.getId() + ": " + club.getName()));
                    break;

                case 4:
                    System.out.print("Enter Name: ");
                    String facultyName = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();
                    facultyAdvisorRepository.save(new FacultyAdvisor(facultyName, email, password));
                    System.out.println("Faculty advisor added successfully!");
                    break;

                case 5:
                    System.out.print("Enter Faculty ID to remove: ");
                    Long removeFacultyId = scanner.nextLong();
                    facultyAdvisorRepository.deleteById(removeFacultyId);
                    System.out.println("Faculty advisor removed successfully!");
                    break;

                case 6:
                    System.out.println("\n--- Faculty Advisors ---");
                    facultyAdvisorRepository.findAll().forEach(advisor ->
                            System.out.println(advisor.getId() + ": " + advisor.getName()));
                    break;

                case 7:
                    System.out.print("Enter Club ID: ");
                    Long assignClubId = scanner.nextLong();
                    System.out.print("Enter Faculty ID: ");
                    Long assignFacultyId = scanner.nextLong();

                    Optional<Club> clubToAssign = clubRepository.findById(assignClubId);
                    Optional<FacultyAdvisor> advisorToAssign = facultyAdvisorRepository.findById(assignFacultyId);

                    if (clubToAssign.isPresent() && advisorToAssign.isPresent()) {
                        Club club = clubToAssign.get();
                        club.setFacultyAdvisor(advisorToAssign.get());
                        clubRepository.save(club);
                        System.out.println("Faculty advisor assigned to club!");
                    } else {
                        System.out.println("Invalid club or faculty ID.");
                    }
                    break;

                case 8:
                    System.out.print("Enter Event Name: ");
                    String eventName = scanner.nextLine();
                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Event Date (YYYY-MM-DD): ");
                    String eventDate = scanner.nextLine();
                    System.out.print("Enter Club ID for the Event: ");
                    Long clubId = scanner.nextLong();

                    Optional<Club> eventClub = clubRepository.findById(clubId);
                    if (eventClub.isPresent()) {
                        Event event = new Event(eventName, description, eventDate, eventClub.get());
                        eventRepository.save(event);
                        System.out.println("Event added successfully!");
                    } else {
                        System.out.println("Club not found.");
                    }
                    break;

                case 9:
                    System.out.print("Enter Event ID to approve: ");
                    Long approveId = scanner.nextLong();
                    eventRepository.findById(approveId).ifPresent(event -> {
                        // event.setStatus("Approved");
                        eventRepository.save(event);
                        System.out.println("Event approved!");
                    });
                    break;

                case 10:
                    System.out.print("Enter Event ID to reject: ");
                    Long rejectId = scanner.nextLong();
                    eventRepository.findById(rejectId).ifPresent(event -> {
                        // event.setStatus("Rejected");
                        eventRepository.save(event);
                        System.out.println("Event rejected!");
                    });
                    break;

                case 11:
                    System.out.print("Enter Event ID to notify: ");
                    Long notificationId = scanner.nextLong();
                    eventRepository.findById(notificationId).ifPresent(event ->
                            System.out.println("Push notification sent for event: " + event.getName()));
                    break;

                case 12:
                    System.out.println("\n--- Events ---");
                    eventRepository.findAll().forEach(event ->
                            System.out.println("[" + event.getId() + "] " + event.getName() +
                                    " on " + event.getDate() + " - Status: " ));
                    break;

                case 0:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
        scanner.close();
    }
}