package dev.m3s.programming2.homework3;

import java.util.Calendar;

public class StudentCourse {

    private Course course;
    private int gradeNum;
    private int yearCompleted;

    public StudentCourse() {
        
    }

    public StudentCourse(Course course, final int gradeNum, final int yearCompleted) {
        this.course = course;
        setYear(yearCompleted);
        setGrade(gradeNum);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getGradeNum() {
        return gradeNum;
    }

    protected void setGrade(int gradeNum) {
        if (checkGradeValidity(gradeNum)) {
            this.gradeNum = gradeNum;
            if (getYear() == 0) {
                yearCompleted = Calendar.getInstance().get(Calendar.YEAR);
            }
        }
    }

    private boolean checkGradeValidity(final int gradeNum) {
        if (course.isNumericGrade()) {
            if (gradeNum >= 0 && gradeNum <= 5) {
                return true;
            }
        } else {
            if (gradeNum == 'F' || gradeNum == 'A') {
                return true;
            }
        }
        return false;
    }

    public boolean isPassed() {
        return ((gradeNum > 0 && gradeNum < 6) || gradeNum == 'A');
    }

    public int getYear() {
        return yearCompleted;
    }

    public void setYear(final int year) {
        if (year > 2000 && year <= Calendar.getInstance().get(Calendar.YEAR)) {
            yearCompleted = year;
        }
    }

    public String toString() { //s
        if (gradeNum == 0) {
            return course.toString() + " " + "Year: " + yearCompleted + ", " + "Grade: " + "\"Not graded\".]"; 
        }
        if (course.isNumericGrade()) {
            return course.toString() + " " + "Year: " + yearCompleted + ", " + "Grade: " + gradeNum + ".]";
        }
        return course.toString() + " " + "Year: " + yearCompleted + ", " + "Grade: " + (char)gradeNum + ".]";
    }

}
