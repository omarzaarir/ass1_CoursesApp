package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CourseListviewAdapter extends ArrayAdapter<String> {
    private ArrayList<String> coursesClasses;
    private Context context;
    private  int mRe;
    public CourseListviewAdapter(@NonNull Context context, int resource,  @NonNull ArrayList<String> objects) {
        super(context, resource, objects);

        this.coursesClasses=objects;
        this.context= context;
        mRe=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View inflater= LayoutInflater.from(context).inflate(mRe,null,true);

        TextView textView=inflater.findViewById(R.id.leactier_title);

        textView.setText(coursesClasses.get(position)+"-");

        return inflater;
    }
}
