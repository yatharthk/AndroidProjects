package android.example.reportcardsapp;

public class ReportCard {
    private String studentName;
    private int courseID;
    private double marks;

    // default constructor
    public ReportCard(String studentName, int courseID, double marks) {
        this.studentName = studentName;
        this.courseID = courseID;
        this.marks = marks;
    }

    // Set grade for a course
    public void setCourseGrade(int courseID, double marks) {
        this.courseID = courseID;
        this.marks = marks;
    }

    // Getter for Student name
    public String getStudentName() {
        return studentName;
    }
    //Getter for CourseID
    public int getCourseID() {
        return courseID;
    }

    public double getMarks() {
        return marks;
    }
    //Getter for Grade
    public String getGrade() {
        String grade;
        if (marks >= 90.0) {
            grade = "A";
        } else if (marks < 90.0 && marks >= 80.0) {
            grade = "B";
        } else if (marks < 80.0 && marks >= 70.0) {
            grade = "C";
        } else if (marks < 70.0 && marks >= 60.0) {
            grade = "D";
        } else if (marks < 60.0) {
            grade = "Fail";
        } else {
            grade = "error";
        }
        return grade;

    }
    //Print to string

    @Override
    public String toString() {
        return "ReportCard{" +
                "StudentName='" + studentName + '\'' +
                ", CourseID=" + courseID +
                ", Grade=" + this.getGrade() +
                '}';
    }
}