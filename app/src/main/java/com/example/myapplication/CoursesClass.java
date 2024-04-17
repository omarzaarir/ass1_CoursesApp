package com.example.myapplication;

public class CoursesClass {
    String Title,teacher;
    int number_of_course,completed;

    CoursesClass(String Title,String teacher,int number_of_course,int completed){
        this.completed=completed;
        this.number_of_course=number_of_course;
        this.teacher=teacher;
        this.Title=Title;
    }
}
