package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("\n--- School Directory ---");
        if (people.isEmpty()) {
            System.out.println("No people in the directory.");
            return;
        }
        for (Person person : people) {
            person.displayDetails();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- School Administration & Attendance System (SOLID-SRP Demo) ---");

        // Initialize services
        FileStorageService storageService = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(storageService);
        AttendanceService attendanceService = new AttendanceService(storageService, registrationService);

        // Create and register students
        Student student1 = new Student("Alice Wonderland", "Grade 10");
        Student student2 = new Student("Bob The Builder", "Grade 9");
        registrationService.registerStudent(student1);
        registrationService.registerStudent(student2);

        // Create and register teachers
        Teacher teacher1 = new Teacher("Dr. Emily Carter", "Physics");
        registrationService.registerTeacher(teacher1);

        // Create and register staff
        Staff staff1 = new Staff("Mr. John Davis", "Librarian");
        registrationService.registerStaff(staff1);

        // Display all registered people
        displaySchoolDirectory(registrationService.getAllPeople());

        // Create and register courses
        Course course1 = new Course("Intro to Quantum Physics");
        Course course2 = new Course("Advanced Algorithms");
        registrationService.createCourse(course1);
        registrationService.createCourse(course2);

        System.out.println("\n\n--- Available Courses ---");
        for (Course c : registrationService.getCourses()) {
            c.displayDetails();
        }

        // Mark attendance using the AttendanceService
        attendanceService.markAttendance(student1.getId(), course1.getCourseId(), "Present");
        attendanceService.markAttendance(student2.getId(), course1.getCourseId(), "Absent");
        attendanceService.markAttendance(student1.getId(), course2.getCourseId(), "Daydreaming");

        // Display attendance records
        attendanceService.displayAttendanceLog();
        attendanceService.displayAttendanceLog(student1);
        attendanceService.displayAttendanceLog(course1);

        // Save all data to files
        System.out.println("\n\n--- Saving Data to Files ---");
        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();
    }
}