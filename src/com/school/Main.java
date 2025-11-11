package com.school;

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
    Student student3 = new Student("Charlie Chocolate", "Grade 11");
        registrationService.registerStudent(student1);
        registrationService.registerStudent(student2);
    registrationService.registerStudent(student3);

        // Create and register teachers
        Teacher teacher1 = new Teacher("Dr. Emily Carter", "Physics");
        registrationService.registerTeacher(teacher1);

        // Create and register staff
        Staff staff1 = new Staff("Mr. John Davis", "Librarian");
        registrationService.registerStaff(staff1);

        // Display all registered people
        displaySchoolDirectory(registrationService.getAllPeople());

    // Create and register courses with capacities
    Course course1 = registrationService.createCourse("Intro to Quantum Physics", 2);
    Course course2 = registrationService.createCourse("Advanced Algorithms", 1);

    // Enroll students in courses (test capacity limits)
    registrationService.enrollStudentInCourse(student1, course1); // should succeed
    registrationService.enrollStudentInCourse(student2, course1); // should succeed
    registrationService.enrollStudentInCourse(student3, course1); // should fail (over capacity)

    // After enrollments, display course details (capacity and count)
    System.out.println("\n--- Course Enrollment Summary ---");
    for (Course c : registrationService.getCourses()) {
        c.displayDetails();
    }

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