package com.school;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Staff> staffMembers;
    private List<Course> courses;
    private FileStorageService storageService;

    public RegistrationService(FileStorageService storageService) {
        this.storageService = storageService;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void registerStudent(Student student) {
        students.add(student);
    }

    public void registerTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void registerStaff(Staff staff) {
        staffMembers.add(staff);
    }

    public void createCourse(Course course) {
        courses.add(course);
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Staff> getStaffMembers() {
        return staffMembers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Student findStudentById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Course findCourseById(int id) {
        return courses.stream()
                .filter(course -> course.getCourseId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Person> getAllPeople() {
        List<Person> allPeople = new ArrayList<>();
        allPeople.addAll(students);
        allPeople.addAll(teachers);
        allPeople.addAll(staffMembers);
        return allPeople;
    }

    public void saveAllRegistrations() {
        // Save each type of registration to its respective file
        storageService.saveData(students, "students.txt");
        storageService.saveData(teachers, "teachers.txt");
        storageService.saveData(staffMembers, "staff.txt");
        storageService.saveData(courses, "courses.txt");
    }
}