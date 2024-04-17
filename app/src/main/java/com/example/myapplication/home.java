package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.CustomFloatAttributes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class home extends AppCompatActivity {
    ListView mycourselistview;
    LinearLayout OptionalCourseslistview,welcome;
    ListView listView;
    ArrayList<String> strings;

    ImageView imageView3;

    SharedPreferences pref;

    String[] My_Courses,Optional_Courses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mycourselistview=findViewById(R.id.mycourselistview);
        OptionalCourseslistview=findViewById(R.id.OptionalCourseslistview);
        welcome=findViewById(R.id.welcome);
        imageView3=findViewById(R.id.imageView3);

        readingSharedPreferences();

        ArrayList<CoursesClass> Mycourseslist=new ArrayList<>();
        for (String s:My_Courses) {
           String Course= pref.getString(s,"null");
            if (!Course.equals("null")){
                Log.d("oomaro",Course+"-------");
                String[] Coursedata=Course.split("@");
                String teatcher=Coursedata[1];
                String le=Coursedata[0];
                int n=0;
                for (String r:le.split(",")) {
                    if (r.equals("0"))
                        break;
                    n++;
                }
                CoursesClass coursesClass=new CoursesClass(s,teatcher,n,le.split(",").length);
                Mycourseslist.add(coursesClass);
            }
        }

        ArrayList<CoursesClass> Optional_Courseslist=new ArrayList<>();
        for (String s:Optional_Courses) {
            String Course= pref.getString(s,"null");
            if (!Course.equals("null")){
                String[] Coursedata=Course.split("@");
                String teatcher=Coursedata[1];
                String le=Coursedata[0];
                int n=0;
                for (String r:le.split(",")) {
                    if (r.equals("0"))
                        break;
                    n++;
                }
                CoursesClass coursesClass=new CoursesClass(s,teatcher,n,le.split(",").length);
                Optional_Courseslist.add(coursesClass);
            }
        }


        AtomicReference<MyListAdapter> adapter= new AtomicReference<>(new MyListAdapter(this, R.layout.item_list, Mycourseslist));
        mycourselistview.setAdapter(adapter.get());

        AtomicReference<MyListAdapter> adapteroptional= new AtomicReference<>(new MyListAdapter(this, R.layout.optinal_item, Optional_Courseslist));
        setOptionalCourseslistview(Optional_Courseslist,adapteroptional,Mycourseslist,adapter);
        if (Optional_Courseslist.isEmpty()){
            CoursesClass coursesClass=new CoursesClass("pls waiting for update","",0,0);
            Optional_Courseslist.add(coursesClass);
            adapteroptional.set(new MyListAdapter(this, R.layout.optinal_item, Optional_Courseslist));
            OptionalCourseslistview.addView(adapteroptional.get().getView(0,null,null));
        }

        mycourselistview.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent=new Intent(this,course.class);
            intent.putExtra("Title",Mycourseslist.get(position).Title);
            intent.putExtra("Teacher",Mycourseslist.get(position).teacher);
            intent.putExtra("Completed",Mycourseslist.get(position).completed+"");
            intent.putExtra("Number_of_course",Mycourseslist.get(position).number_of_course+"");
            startActivity(intent);
        });

        welcome.setOnClickListener(e-> {
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
        });
        imageView3.setOnClickListener(e->{
            Intent intent=new Intent(this,Search.class);
            startActivity(intent);
        });
    }

    private void readingSharedPreferences(){
        pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        String mycoursesString= pref.getString("My Courses","null");
        String optionalcoursesString=pref.getString("Optional Courses","null");
        if (optionalcoursesString.equals("null")){
            Optional_Courses= new String[]{};
        }else {
            Optional_Courses=optionalcoursesString.split(",");
        }

        if (mycoursesString.equals("null")){
            My_Courses= new String[]{};
        }else {
            My_Courses=mycoursesString.split(",");
        }


    }
private void setOptionalCourseslistview(ArrayList<CoursesClass> Optional_Courseslist, AtomicReference<MyListAdapter> adapteroptional, ArrayList<CoursesClass> Mycourseslist, AtomicReference<MyListAdapter> adapter){
    for (int i = 0; i < Optional_Courseslist.size(); i++) {
        View view= adapteroptional.get().getView(i,null,null);
        int finalI = i;
        setonactionremoving(view, Optional_Courseslist,finalI,adapteroptional,Mycourseslist,adapter);
        OptionalCourseslistview.addView(view);
    }
    if (Optional_Courseslist.isEmpty()){
        CoursesClass coursesClass=new CoursesClass("pls waiting for update","",0,0);
        Optional_Courseslist.add(coursesClass);
        adapteroptional.set(new MyListAdapter(this, R.layout.optinal_item, Optional_Courseslist));
        OptionalCourseslistview.addView(adapteroptional.get().getView(0,null,null));
    }
}
private void setonactionremoving(View view, ArrayList<CoursesClass> Optional_Courseslist, int finalI, AtomicReference<MyListAdapter> adapteroptional, ArrayList<CoursesClass> Mycourseslist, AtomicReference<MyListAdapter> adapter){
    view.setOnClickListener(e->{
        CoursesClass coursesClass=Optional_Courseslist.remove(finalI);
        OptionalCourseslistview.removeAllViews();
        adapteroptional.set(new MyListAdapter(this, R.layout.optinal_item, Optional_Courseslist));
        setOptionalCourseslistview(Optional_Courseslist,adapteroptional,Mycourseslist,adapter);
        Mycourseslist.add(coursesClass);
        adapter.set(new MyListAdapter(this, R.layout.item_list, Mycourseslist));
        mycourselistview.setAdapter(adapter.get());
        String my= pref.getString("My Courses","null");
        String op= pref.getString("Optional Courses","null");
        if (!my.equals("null")){
            my=my+","+coursesClass.Title;
            SharedPreferences.Editor w= pref.edit().putString("My Courses",my);
            w.commit();
        }
        if (!op.equals("null")){
            String[] opArray=op.split(",");
            op=opArray[0];
            for (int i=1;i<opArray.length;i++) {
                if (opArray[i].equals(coursesClass.Title))
                    continue;
                op=op+","+opArray[i];
            }
            SharedPreferences.Editor w= pref.edit().putString("Optional Courses",op);
            w.commit();
        }
    });
}
}