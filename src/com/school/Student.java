package com.school;

class Student {
    int studentId;
    String studentName;

    public void setDetails(int id, String name){
        this.studentId= id;
        this.studentName= name;
    }
    
    public void displayDetails(){
        System.out.println("Student ID: "+ this.studentId + " Name: "+ this.studentName);
    }

}