package com.school;

class Course {
    int courseId;
    String courseName;

    public void setDetails(int id, String name){
        this.courseId= id;
        this.courseName= name;
    }
    
    public void displayDetails(){
        System.out.println("Course ID: "+ this.courseId + " Name: "+ this.courseName);
    }

}