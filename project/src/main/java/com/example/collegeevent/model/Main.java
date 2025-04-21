package com.example.collegeevent.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventManagementSystem ems = new EventManagementSystem();
        List<Club> clubs = new ArrayList<>();
        List<FacultyAdvisor> advisors = new ArrayList<>();

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
                case 1:  // Add Club
                    System.out.print("Enter Club ID: ");
                    int clubId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Club Name: ");
                    String clubName = scanner.nextLine();
                    clubs.add(new Club(clubId, clubName, null));
                    System.out.println("Club added successfully!");
                    break;

                case 2:  // Remove Club
                    System.out.print("Enter Club ID to remove: ");
                    int removeId = scanner.nextInt();
                    clubs.removeIf(c -> c.getId() == removeId);
                    System.out.println("Club removed successfully!");
                    break;

                case 3:  // List Clubs
                    System.out.println("\n--- Clubs ---");
                    for (Club club : clubs) {
                        System.out.println(club);
                    }
                    break;

                case 4:  // Add Faculty Advisor
                    System.out.print("Enter Faculty ID: ");
                    int facultyId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Faculty Name: ");
                    String facultyName = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    advisors.add(new FacultyAdvisor(facultyId, facultyName, department));
                    System.out.println("Faculty advisor added successfully!");
                    break;

                case 5:  // Remove Faculty Advisor
                    System.out.print("Enter Faculty ID to remove: ");
                    int removeFacultyId = scanner.nextInt();
                    advisors.removeIf(a -> a.getFacultyId() == removeFacultyId);
                    System.out.println("Faculty advisor removed successfully!");
                    break;

                case 6:  // List Faculty Advisors
                    System.out.println("\n--- Faculty Advisors ---");
                    for (FacultyAdvisor advisor : advisors) {
                        System.out.println(advisor);
                    }
                    break;

                case 7:  // Assign Faculty Advisor to Club
                    System.out.print("Enter Club ID: ");
                    int assignClubId = scanner.nextInt();
                    System.out.print("Enter Faculty ID: ");
                    int assignFacultyId = scanner.nextInt();

                    Club clubToAssign = null;
                    FacultyAdvisor advisorToAssign = null;

                    for (Club c : clubs) {
                        if (c.getId() == assignClubId) {
                            clubToAssign = c;
                            break;
                        }
                    }

                    for (FacultyAdvisor a : advisors) {
                        if (a.getFacultyId() == assignFacultyId) {
                            advisorToAssign = a;
                            break;
                        }
                    }

                    if (clubToAssign != null && advisorToAssign != null) {
                        clubToAssign.setFacultyAdvisor(advisorToAssign);
                        System.out.println("Faculty advisor assigned to club!");
                    } else {
                        System.out.println("Invalid club or faculty ID.");
                    }
                    break;

                case 8:  // Add Event
                    System.out.print("Enter Event ID: ");
                    int eventId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Event Name: ");
                    String eventName = scanner.nextLine();
                    System.out.print("Enter Event Date (YYYY-MM-DD): ");
                    String eventDate = scanner.nextLine();
                    Event event = new Event(eventId, eventName, eventDate);
                    ems.uploadEvent(event);
                    System.out.println("Event added successfully!");
                    break;

                case 9:  // Approve Event
                    System.out.print("Enter Event ID to approve: ");
                    int approveId = scanner.nextInt();
                    for (Event e : ems.getEvents()) {
                        if (e.getId() == approveId) {
                            ems.approveEvent(e);
                            System.out.println("Event approved!");
                            break;
                        }
                    }
                    break;

                case 10:  // Reject Event
                    System.out.print("Enter Event ID to reject: ");
                    int rejectId = scanner.nextInt();
                    for (Event e : ems.getEvents()) {
                        if (e.getId() == rejectId) {
                            ems.rejectEvent(e);
                            System.out.println("Event rejected!");
                            break;
                        }
                    }
                    break;

                case 11:  // Send Notification
                    System.out.print("Enter Event ID to send notification: ");
                    int notificationId = scanner.nextInt();
                    for (Event e : ems.getEvents()) {
                        if (e.getId() == notificationId) {
                            ems.sendPushNotification(e);
                            System.out.println("Notification sent!");
                            break;
                        }
                    }
                    break;

                case 12:  // List Events
                    System.out.println("\n--- Events ---");
                    for (Event e : ems.getEvents()) {
                        System.out.println(e);
                    }
                    break;

                case 0:  // Exit
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
