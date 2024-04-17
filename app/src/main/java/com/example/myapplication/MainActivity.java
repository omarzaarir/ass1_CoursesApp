package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.Login);

        login.setOnClickListener(e->{
            Intent intent=new Intent(this,home.class);
            startActivity(intent);
            finish();
        });

        DataLoadingInSharedPreferences();
    }
    private void DataLoadingInSharedPreferences() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = null;

        if (!(pref.contains("isloaded"))) {
            editor = pref.edit();
            editor.putBoolean("isloaded", true);

            editor.putString("math","1,1,1,1,1,1,1,1,1@Tariq Alnono");
            editor.putString("Arabic","1,0,0,0,0,0,0,0,0,0,0@Sami Alnono");
            editor.putString("English","0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0@morad Abumoko");
            editor.putString("technology","1,1,1,1,0,0,0,0,0,0,0,0@salsabel Ala`raj");
            editor.putString("Math2","1,1,1,1,1,1,1,1,0,0,0,0,0@Tariq Alnono");

            editor.putString("france","0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0@Tariq Alnono");
            editor.putString("geographic","0,0,0,0,0,0,0,0,0,0@salabel Ala`raj");
            editor.putString("spanich","0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0@morad Abumoko");
            editor.putString("coding","0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0@Sami Alnono");
            editor.putString("animation","0,0,0,0,0,0,0,0,0,0,0,0@salsabel Ala`raj");

            editor.putString("My Courses","Math2,technology,English,Arabic,math");
            editor.putString("Optional Courses","france,geographic,spanich,coding,animation");
            editor.putString("All Courses","Math2,technology,English,Arabic,math,france,geographic,spanich,coding,animation");

            editor.commit();
        }

    }
}