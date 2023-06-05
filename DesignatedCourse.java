package dev.m3s.programming2.homework3;

import java.util.Calendar;

public class DesignatedCourse {

    private Course course;
    private boolean responsible;
    private int year;

    public DesignatedCourse() {

    }

    public DesignatedCourse(Course course, boolean resp, int year) {
        setCourse(course);
        responsible = resp;
        setYear(year);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        if (course != null) {
            this.course = course;
        }
    }

    public boolean isResponsible() {
        return responsible;
    }

    public void setResponsible(boolean responsible) {
        this.responsible = responsible;
    }

    public boolean getResponsible() {
        return responsible;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 2000 && year <= Calendar.getInstance().get(Calendar.YEAR)+1) {
            this.year = year;
        }
    }

    public String toString() {
        return " [ course =" + course.toString() + ", year = " + year + " ] ";
    }

}