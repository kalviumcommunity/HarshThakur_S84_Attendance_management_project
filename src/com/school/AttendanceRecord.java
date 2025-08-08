package com.school;
public class AttendanceRecord {
    private int StudentId;
    private int CourseId;
    private String status;

        public AttendanceRecord(int StudentId, int CourseId, String status){
            this.StudentId = StudentId;
            this.CourseId = CourseId;

            if("Present".equalsIgnoreCase(status) || "Absent".equalsIgnoreCase(status)){
                this.status = status;
            }else{
                this.status = "Invalid";
                System.out.println("Warning: Invalid attendance status provided. Set to 'Invalid");
            }
        }

        public void displayRecord(){
            System.out.println("Attendance: Student ID " + StudentId + " in Course ID C" + CourseId + " - Status" + status);
        }
}
