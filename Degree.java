package dev.m3s.programming2.homework3;

import java.util.List;
import java.util.ArrayList;

public class Degree {
    
    private static final int MAX_COURSES = 50;
    private String degreeTitle = ConstantValues.NO_TITLE;
    private String titleOfThesis = ConstantValues.NO_TITLE;
    private List<StudentCourse> myCourses = new ArrayList<StudentCourse>();

    public Degree() {
        
    }

    public List<StudentCourse> getCourses() {
        return myCourses;
    }

    public void addStudentCourses(List<StudentCourse> courses) {
        if (courses != null) {
            for (StudentCourse course : courses) {
                addStudentCourse(course);
            }
        }
    }

    public boolean addStudentCourse(StudentCourse course) {
        if (course != null && myCourses.size() < MAX_COURSES) {
            myCourses.add(course);
            return true; 
        }
        return false;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        if (degreeTitle != null) {
            this.degreeTitle = degreeTitle;
        }
    }

    public String getTitleOfThesis() {
        return titleOfThesis;
    }

    public void setTitleOfThesis(String titleOfThesis) {
        if (titleOfThesis != null) {
            this.titleOfThesis = titleOfThesis;
        }
    }

    public double getCreditsByBase(Character base) {
        double result = 0;
        for (StudentCourse course : myCourses) {
            if (course != null && course.getCourse().getCourseBase() == base) {
                if (course.getCourse() != null && isCourseCompleted(course)) {
                    result += course.getCourse().getCredits();
                }
            }
        }
        return result;
    }

    public double getCreditsByType(final int courseType) {
        double result = 0;
        for (StudentCourse course : myCourses) {
            if (course != null && course.getCourse().getCourseType() == courseType) {
                if (course.getCourse() != null && isCourseCompleted(course)) {
                    result += course.getCourse().getCredits();
                }
            }
        }
        return result;
    }

    public double getCredits() {
        double result = 0;
        for (StudentCourse course : myCourses) {
            if (course != null && course.getCourse() != null && isCourseCompleted(course)) {
                result += course.getCourse().getCredits();
            }
        }
        return result;
    }

    private boolean isCourseCompleted(StudentCourse c) {
        if (c != null) {
            return c.isPassed();
        }
        return false;
    }

    public List<Double> getGPA(int type) {
        List<Double> result = new ArrayList<Double>();
        double sum = 0.0;
        double count = 0.0;
        if (type == ConstantValues.OPTIONAL || type == ConstantValues.MANDATORY) {
            for (StudentCourse course : myCourses) {
                if (course != null && course.getCourse() != null && course.getCourse().getCourseType() == type) {
                    if (course.getCourse().isNumericGrade()) {
                        sum += course.getGradeNum();
                        count++;
                    }
                }
            }
        } else if (type == ConstantValues.ALL) {
            for (StudentCourse course : myCourses) {
                if (course != null && course.getCourse() != null) {
                    if (course.getCourse().isNumericGrade()) {
                        sum += course.getGradeNum();
                        count++;
                    }
                }
            }
        }
        result.add(0, sum);
        result.add(1, count);
        result.add(2, sum/count);
        return result;
    }

    public void printCourses() {
        int i = 1;
        for (StudentCourse course : myCourses) {
            System.out.println(i + ". " + course.toString() + "\n");
            i++;
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Degree [Title: \"" + degreeTitle + "\" (courses: " + myCourses.size() + ")\n" +
        "Thesis title: \"" + titleOfThesis + "\"");
        int i = 1;
        for (StudentCourse course : myCourses) {
            builder.append("\n" + i + ". " + course.toString());
            i++;
        }
        builder.append("]");
        return builder.toString();
    }

}
