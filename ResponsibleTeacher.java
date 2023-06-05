package dev.m3s.programming2.homework3;

import java.util.List;
import java.util.ArrayList;

public class ResponsibleTeacher extends Employee implements Teacher {

    private List<DesignatedCourse> courses = new ArrayList<DesignatedCourse>();

    public ResponsibleTeacher(String lname, String fname) {
        super(lname, fname);
    }

    public String getEmployeeIdString() {
        return "OY_TEACHER_";
    }

    public String getCourses() {
        StringBuilder builder = new StringBuilder();
        for (DesignatedCourse course : courses) {
            if (course != null && course.getCourse() != null) {
                if (course.isResponsible()) {
                    builder.append("Responsible teacher: ");
                } else {
                    builder.append("Teacher: ");
                }
                builder.append(course.toString() + "\n");
            }
        }
        return builder.toString();
    }

    public void setCourses(List<DesignatedCourse> courses) {
        if (courses != null) {
            this.courses = courses;
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Teacher id: " + super.getIdString() + "\n")
                .append(" First name: " + super.getFirstName() + ", Last name: " + super.getLastName() + "\n") 
                .append(" Birthdate: " + super.getBirthDate() + "\n")
                .append(" Salary: " + String.format("%.2f", super.calculatePayment()) + " \n")
                .append("Teacher for courses: \n")
                .append(getCourses()); 
        return builder.toString();
    }

}