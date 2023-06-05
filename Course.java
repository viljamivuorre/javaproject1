package dev.m3s.programming2.homework3;

public class Course {

    private String name = ConstantValues.NO_TITLE;
    private String courseCode = ConstantValues.NOT_AVAILABLE;
    private Character courseBase = ' ';
    private int courseType;
    private int period;
    private double credits;
    private boolean numericGrade;

    public Course() {

    }

    public Course(String name, final int code, Character courseBase, final int type,
     final int period, final double credits, boolean numericGrade) {
        setName(name);
        setCourseCode(code, courseBase);
        setCourseType(type);
        setPeriod(period);
        setCredits(credits);
        this.numericGrade = numericGrade;
    }

    public Course(Course course) {
        setName(course.getName());
        courseCode = course.getCourseCode();
        courseBase = course.getCourseBase();
        setCourseType(course.getCourseType());
        setPeriod(course.getPeriod());
        setCredits(course.getCredits());
        numericGrade = course.isNumericGrade();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && name != "") {
            this.name = name;
        }
    }

    public String getCourseTypeString() {
        if (courseType == ConstantValues.OPTIONAL) {
            return "Optional";
        } else {
            return "Mandatory";
        }
    }

    public int getCourseType() {
        return courseType;
    }

    public void setCourseType(final int type) {
        if (type == 0 || type == 1) {
            courseType = type;
        }
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(final int courseCode, Character courseBase) {
        if (courseBase != null) {
            if (courseCode > 0 && courseCode < 1000000 && "APS".indexOf(courseBase) != -1 ) {
                this.courseCode = String.valueOf(courseCode) + courseBase;
                this.courseBase = courseBase;
            }
        }
    }

    public Character getCourseBase() {
        return courseBase;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(final int period ) {
        if (period >= ConstantValues.MIN_PERIOD && period <= ConstantValues.MAX_PERIOD) {
            this.period = period;
        }
    }

    public double getCredits() {
        return credits;
    }

    private void setCredits(final double credits) {
        if (credits > ConstantValues.MIN_CREDITS && credits <= ConstantValues.MAX_COURSE_CREDITS) {
            this.credits = credits;
        }
    }

    public boolean isNumericGrade() {
        return numericGrade;
    }

    public void setNumericGrade(boolean numericGrade) {
        this.numericGrade = numericGrade;
    }

    public String toString() {
        return " [" + courseCode + " (" + String.format("%1$ 5.2f", credits) + " cr), " + "\"" + name + "\"" + ". " + getCourseTypeString() + ", period: " + period + ".] ";
    }

}