package dev.m3s.programming2.homework3;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Course course = new Course("aaa", 11111, 'A', 1, 4, 30.0, false);
        Course course2 = new Course("aaa", 11111, 'A', 1, 4, 30.0, true);
        Course course3 = new Course("aaa", 11111, 'A', 1, 4, 30.0, true);
        Course course4 = new Course("aaa", 11111, 'A', 1, 4, 30.0, true);
        Course course5 = new Course("aaa", 11111, 'A', 1, 4, 30.0, true);
        Course course6 = new Course("aaa", 11111, 'A', 1, 4, 30.0, true);
        Course course7 = new Course("aaa", 11111, 'A', 1, 4, 30.0, true);
        Course course8 = new Course("aaa", 11111, 'A', 1, 4, 30.0, true);
        Course course9 = new Course("aaa", 11111, 'A', 1, 4, 30.0, true);
        Course course10 = new Course("aaa", 11111, 'A', 1, 4, 30.0, true);
        Course course11 = new Course("aaa", 11111, 'A', 1, 4, 30.0, true);
        Course course12 = new Course("aaa", 11111, 'A', 1, 4, 30.0, true);
        Course course13 = new Course("aaa", 11111, 'A', 1, 4, 30.0, true);
        Course course14 = new Course("aaa", 11111, 'A', 1, 4, 30.0, true);
        Course course15 = new Course("aaa", 11111, 'A', 1, 4, 30.0, true);
        Course course16 = new Course("aaa", 11111, 'A', 1, 4, 30.0, true);
        StudentCourse studentCourse = new StudentCourse(course, 'A', 2017);
        StudentCourse studentCourse2 = new StudentCourse(course2, 5, 2017);
        StudentCourse studentCourse3 = new StudentCourse(course3, 5, 2017);
        StudentCourse studentCourse4 = new StudentCourse(course4, 5, 2017);
        StudentCourse studentCourse5 = new StudentCourse(course5, 5, 2017);
        StudentCourse studentCourse6 = new StudentCourse(course6, 5, 2017);
        StudentCourse studentCourse7 = new StudentCourse(course7, 5, 2017);
        StudentCourse studentCourse8 = new StudentCourse(course8, 5, 2017);
        StudentCourse studentCourse9 = new StudentCourse(course9, 5, 2017);
        StudentCourse studentCourse10 = new StudentCourse(course10, 5, 2017);
        StudentCourse studentCourse11 = new StudentCourse(course11, 5, 2017);
        StudentCourse studentCourse12 = new StudentCourse(course12, 5, 2017);
        StudentCourse studentCourse13 = new StudentCourse(course13, 5, 2017);
        StudentCourse studentCourse14 = new StudentCourse(course14, 5, 2017);
        StudentCourse studentCourse15 = new StudentCourse(course15, 5, 2017);
        StudentCourse studentCourse16 = new StudentCourse(course16, 5, 2017);
        Student student = new Student("duck", "donald");
        ArrayList<StudentCourse> courses = new ArrayList<StudentCourse>();
        courses.add(studentCourse);
        courses.add(studentCourse2);
        courses.add(studentCourse3);
        courses.add(studentCourse4);
        courses.add(studentCourse5);
        courses.add(studentCourse6);
        courses.add(studentCourse7);
        courses.add(studentCourse8);
        courses.add(studentCourse9);
        courses.add(studentCourse10);
        courses.add(studentCourse11);
        courses.add(studentCourse12);
        courses.add(studentCourse13);
        courses.add(studentCourse14);
        courses.add(studentCourse15);
        courses.add(studentCourse16);
        student.addCourses(0, courses);
        student.addCourses(1, courses);
        student.setTitleOfThesis(0, "kakka");
        student.setTitleOfThesis(1, "kakka");
        student.setStartYear(2012);
        System.out.println(student.setGraduationYear(2012));
        System.out.println(student);
        int cmp = Character.getNumericValue('8');
        System.out.println(cmp);
    }

}
