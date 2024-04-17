package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<CoursesClass> {
    private ArrayList<CoursesClass> coursesClasses;
    private Context context;
    private  int mRe;
    int[] ColorValues={0xFFB07777,0xFFB0A777,0xFF77A0B0,0xFF86B077};
    public MyListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<CoursesClass> objects) {
        super(context, resource, objects);
        this.coursesClasses=objects;
        this.context= context;
        mRe=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View inflater=LayoutInflater.from(context).inflate(mRe,null,true);

        TextView Title=inflater.findViewById(R.id.title);
        TextView Teacher=inflater.findViewById(R.id.teacher);
        TextView numberofcors=inflater.findViewById(R.id.numberOfcour);

        Title.setText(coursesClasses.get(position).Title);
        Teacher.setText(coursesClasses.get(position).teacher);
        numberofcors.setText(coursesClasses.get(position).number_of_course+"/"+coursesClasses.get(position).completed);

        if (mRe==R.layout.optinal_item){
            inflater.findViewById(R.id.cc).setBackgroundColor(ColorValues[(int) (position%3)]);
            numberofcors.setText("lectures");
            Teacher.setText(coursesClasses.get(position).completed+"");
        }

        return inflater;
    }
}
