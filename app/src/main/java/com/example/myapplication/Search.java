package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    LinearLayout My_Courses_notifications;
    GridLayout Search_GridLayout_Suggestions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Search_GridLayout_Suggestions=findViewById(R.id.Search_GridLayout_Suggestions);
        My_Courses_notifications=findViewById(R.id.My_Courses_notifications);

        ArrayList<CoursesClass> coursesClasses=new ArrayList<>();
        coursesClasses.add(new CoursesClass("Math","Tariq Alnono",7,20));
        coursesClasses.add(new CoursesClass("Arabic","Sami Alnono",10,21));
        coursesClasses.add(new CoursesClass("English","morad Abumoko",3,25));
        coursesClasses.add(new CoursesClass("technology","salsabel Ala`raj",4,15));
        coursesClasses.add(new CoursesClass("Math2","Tariq Alnono",1,20));
        coursesClasses.add(new CoursesClass("technology","salsabel Ala`raj",4,15));
        coursesClasses.add(new CoursesClass("Math","Tariq Alnono",7,20));

        MyListAdapter adapteroptional=new MyListAdapter(this,R.layout.optinal_item,coursesClasses);

        for (int i = 0; i < coursesClasses.size(); i++) {
            View view=adapteroptional.getView(i,null,null);
            Search_GridLayout_Suggestions.addView(view);
        }
    }
}