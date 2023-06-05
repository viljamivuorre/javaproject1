package dev.m3s.programming2.homework3;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.lang.StringBuilder;

public class Student extends Person {

    private int id;
    private int startYear;
    private int graduationYear;
    private List<Degree> degrees;

    public Student(String lname, String fname) {
        super(lname, fname);
        id = super.getRandomId(1, 100);
        startYear = Calendar.getInstance().get(Calendar.YEAR);
        degrees = new ArrayList<Degree>();
        degrees.add(new Degree());
        degrees.add(new Degree());
        degrees.add(new Degree());
    }

    public int getId() {
        return id;
    }

    public void setId(final int id ) {
        if (id > 0 && id <= 100) {
            this.id = id;
        }
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(final int startYear) {
        if (startYear > 2000 && startYear <= Calendar.getInstance().get(Calendar.YEAR)) {
            this.startYear = startYear;
        }
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public String setGraduationYear(final int graduationYear) {
        if (!canGraduate()) {
            return "Check amount of required credits";
        } else if (graduationYear < startYear || graduationYear > Calendar.getInstance().get(Calendar.YEAR)) {
            return "Check graduation year";
        }
        this.graduationYear = graduationYear;
        return "Ok";
    }

    public void setDegreeTitle(final int i, String dName) {
        if (i >= 0 && i <= 3 && dName != null) {
            degrees.get(i).setDegreeTitle(dName);
        } 
    }

    public boolean addCourse(final int i, StudentCourse course) {
        if (i >= 0 && i < 3) {
            return degrees.get(i).addStudentCourse(course);
        }
        return false;
    }

    public int addCourses(final int i, List<StudentCourse> courses) {
        if (i >= 0 && i < 3 && courses != null) {
            int before = degrees.get(i).getCourses().size();
            degrees.get(i).addStudentCourses(courses);
            int after = degrees.get(i).getCourses().size();
            return after-before;
        }
        return 0;
    }

    public void printCourses() {
        for (Degree degree : degrees) {
            degree.printCourses();
        }
    }

    public void printDegrees() {
        for (Degree degree : degrees) {
            System.out.println(degree);
        }
    }

    public void setTitleOfThesis(final int i, String title) {
        if (i >= 0 && i < 3) {
            degrees.get(i).setTitleOfThesis(title);
        }
    }

    public boolean hasGraduated() {
        return (graduationYear >= startYear && graduationYear <= Calendar.getInstance().get(Calendar.YEAR));
    }

    private boolean canGraduate() {
        return (degrees.get(0).getCreditsByType(ConstantValues.MANDATORY) >= ConstantValues.BACHELOR_MANDATORY 
            && degrees.get(0).getCredits() >= ConstantValues.BACHELOR_CREDITS 
            && degrees.get(1).getCreditsByType(ConstantValues.MANDATORY) >= ConstantValues.MASTER_MANDATORY 
            && degrees.get(1).getCredits() >= ConstantValues.MASTER_CREDITS
            && degrees.get(0).getTitleOfThesis() != ConstantValues.NO_TITLE 
            && degrees.get(1).getTitleOfThesis() != ConstantValues.NO_TITLE);
    }

    public int getStudyYears() {
        if (hasGraduated()) {
            return graduationYear - startYear;
        }
        return Calendar.getInstance().get(Calendar.YEAR) - startYear;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getIdString() + "\n")
               .append("First name: " + super.getFirstName() + ", Last name: " + super.getLastName() + "\n")
               .append("Date of birth: \"" + super.getBirthDate() + "\"\n");
        if (hasGraduated()) {
            builder.append("Status The student has graduated in: " + graduationYear + "\n");
        } else {
            builder.append("Status: The student has not graduated, yet\n");
        }
        if (hasGraduated()) {
            builder.append("Start year: " + startYear + " (studies have lasted for " + getStudyYears() + " years)\n");
        } else {
            builder.append("Start year: " + startYear + " (studies lasted for " + getStudyYears() + " years)\n");
        }
        ArrayList<Double> bcGPA = new ArrayList<Double>(degrees.get(0).getGPA(ConstantValues.ALL));
        ArrayList<Double> msGPA = new ArrayList<Double>(degrees.get(1).getGPA(ConstantValues.ALL));
        double gpa = (bcGPA.get(0)+msGPA.get(0))/(bcGPA.get(1)+msGPA.get(1));
        builder.append("Total credits: " + (degrees.get(0).getCredits()+degrees.get(1).getCredits()) + " (GPA = " + 
                       String.format("%.2f", gpa) + ")\n")
               .append("Bachelor credits: " + degrees.get(0).getCredits() + "\n");
        if (degrees.get(0).getCredits() >= ConstantValues.BACHELOR_CREDITS) {
               builder.append("Total bachelor credits completed ("+ degrees.get(0).getCredits() + "/180.0)\n");
        } else {
            builder.append("Missing bachelor's credits " + ((Double)(180-degrees.get(0).getCredits())) + " ("+ degrees.get(0).getCredits() + "/180.0)\n");
        }
        if (degrees.get(0).getCreditsByType(ConstantValues.MANDATORY) >= ConstantValues.BACHELOR_MANDATORY) {
            builder.append("All mandatory bachelor credits completed (" 
            + degrees.get(0).getCreditsByType(ConstantValues.MANDATORY) + "/150.0)\n");
        } else {
            builder.append("Missing mandatory bachelor's credits " + (ConstantValues.BACHELOR_MANDATORY-degrees.get(0).getCreditsByType(ConstantValues.MANDATORY)) 
            + " (" + degrees.get(0).getCreditsByType(ConstantValues.MANDATORY) + "/150.0)\n");
        }
        builder.append("GPA of Bachelor studies: " + String.format("%.2f", bcGPA.get(2)) + "\n")
               .append("Title of BSc Thesis: \"" + degrees.get(0).getTitleOfThesis() + "\"\n")
               .append("Master credits: " + degrees.get(1).getCredits() + "\n");
        if (degrees.get(1).getCredits() >= ConstantValues.MASTER_CREDITS) {
               builder.append("Total master's credits completed ("+ degrees.get(1).getCredits() + "/120.0)\n");
        } else {
            builder.append("Missing master's credits " + ((Double)(120-degrees.get(1).getCredits())) + " ("+ degrees.get(1).getCredits() + "/120.0)\n");
        }
        if (degrees.get(1).getCreditsByType(ConstantValues.MANDATORY) >= ConstantValues.MASTER_MANDATORY) {
            builder.append("All mandatory master credits completed (" 
            + degrees.get(1).getCreditsByType(ConstantValues.MANDATORY) + "/50.0)\n");
        } else {
            builder.append("Missing mandatory master's credits " + (ConstantValues.MASTER_MANDATORY-degrees.get(1).getCreditsByType(ConstantValues.MANDATORY)) 
            + " (" + degrees.get(1).getCreditsByType(ConstantValues.MANDATORY) + "/50.0)\n");
        }
        builder.append("GPA of master studies: " + String.format("%.2f", msGPA.get(2)) + "\n")
               .append("Title of MSc Thesis: \"" + degrees.get(1).getTitleOfThesis() + "\"");

        return builder.toString();
    }

    public String getIdString() {
        return "Student id: " + id;
    }

}