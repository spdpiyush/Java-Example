package com.learn.data;

import java.util.List;

public class Student {

    private String name;
    private int gradeLevel;
    private String gender;
    private double gpa;
    private List<String> activities;
    private int noteBooks;

    public Student(String name, int gradeLevel, String gender, double gpa, List<String> activities) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.gender = gender;
        this.gpa = gpa;
        this.activities = activities;
    }

    public Student(String name, int gradeLevel, String gender, double gpa, List<String> activities, int noteBooks) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.gender = gender;
        this.gpa = gpa;
        this.activities = activities;
        this.noteBooks = noteBooks;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void printActivities() {
        System.out.println(activities);
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    public int getNoteBooks() {
        return noteBooks;
    }

    public void setNoteBooks(int noteBooks) {
        this.noteBooks = noteBooks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gradeLevel='" + gradeLevel + '\'' +
                ", gender='" + gender + '\'' +
                ", gpa=" + gpa +
                ", activities=" + activities +
                '}';
    }
}
