package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class course extends AppCompatActivity {
    TextView Course_numberOfComplete,Course_teacher,Course_Title;
    ListView Course_lecturesListview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        Course_numberOfComplete =findViewById(R.id.Course_numberOfComplete);
        Course_teacher=findViewById(R.id.Course_teacher);
        Course_Title=findViewById(R.id.Course_Title);
        Course_lecturesListview=findViewById(R.id.Course_lecturesListview);

        String Title = getIntent().getStringExtra("Title");
        Course_Title.setText(Title);
        String Completed = getIntent().getStringExtra("Completed");
        String Number_of_course = getIntent().getStringExtra("Number_of_course");
        Course_numberOfComplete.setText(Number_of_course+"/"+Completed);
        String Teacher = getIntent().getStringExtra("Teacher");
        Course_teacher.setText(Teacher);

        enterLinksOffrance();
        enterLinksOfgeographic();
        enterLinksOfspanich();
        enterLinksOfmath();
        enterLinksOfArabic();
        enterLinksOfEnglish();
        enterLinksOftechnology();
        enterLinksOfMath2();
        enterLinksOfanimation();
        enterLinksOfcoding();


        ArrayList<String> coursesClasses=new ArrayList<>();
        for (String c:stringMapMap.get(Title).keySet()) {
            coursesClasses.add(c);
        }


        CourseListviewAdapter courseListviewAdapter=new CourseListviewAdapter(this,R.layout.course_listview_item,coursesClasses);
        Course_lecturesListview.setAdapter(courseListviewAdapter);

        Course_lecturesListview.setOnItemClickListener((parent, view, position, id) -> {
                String s=stringMapMap.get(Title).get(coursesClasses.get(position));
                Uri uri = Uri.parse(s); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
        });
    }
    Map<String,Map<String,String>> stringMapMap=new HashMap<String,Map<String,String>>();

//     "Optional Courses","france,geographic,spanich,coding,animation"
//     "My Courses","Math2,technology,English,Arabic,math"

    private void enterLinksOffrance(){

        Map<String,String> france=new HashMap<>();
        france.put("French Greetings (French Essentials Lesson 1)","https://www.youtube.com/watch?v=hd0_GZHHWeE&list=PLV1-QgpUU7N2TVWS6gEVMqEfAFjAl-DV6");
        france.put("French Numbers 1 to 20 (French Essentials Lesson 2)","https://www.youtube.com/watch?v=H2-REbL2OU0&list=PLV1-QgpUU7N2TVWS6gEVMqEfAFjAl-DV6&index=2");
        france.put("The French Alphabet (French Essentials Lesson 3)","https://www.youtube.com/watch?v=PaOVHdpRAK8&list=PLV1-QgpUU7N2TVWS6gEVMqEfAFjAl-DV6&index=3");
        france.put("The French Days of the Week (French Essentials Lesson 4)","https://www.youtube.com/watch?v=PaOVHdpRAK8&list=PLV1-QgpUU7N2TVWS6gEVMqEfAFjAl-DV6&index=4");
        france.put("The French Months of the Year (French Essentials Lesson 5)","https://www.youtube.com/watch?v=PaOVHdpRAK8&list=PLV1-QgpUU7N2TVWS6gEVMqEfAFjAl-DV6&index=5");
        france.put("The French Weather & Seasons (French Essentials Lesson 6)","https://www.youtube.com/watch?v=PaOVHdpRAK8&list=PLV1-QgpUU7N2TVWS6gEVMqEfAFjAl-DV6&index=6");
        france.put("French Definite Article / How to say THE in French (French Essentials Lesson 7)","https://www.youtube.com/watch?v=PaOVHdpRAK8&list=PLV1-QgpUU7N2TVWS6gEVMqEfAFjAl-DV6&index=7");
        france.put("French indefinite Article (French Essentials Lesson 8)","https://www.youtube.com/watch?v=PaOVHdpRAK8&list=PLV1-QgpUU7N2TVWS6gEVMqEfAFjAl-DV6&index=8");
        france.put("French Subject Pronouns (French Essentials Lesson 9)","https://www.youtube.com/watch?v=PaOVHdpRAK8&list=PLV1-QgpUU7N2TVWS6gEVMqEfAFjAl-DV6&index=9");
        france.put("Être & Avoir (French Essentials Lesson 10)","https://www.youtube.com/watch?v=PaOVHdpRAK8&list=PLV1-QgpUU7N2TVWS6gEVMqEfAFjAl-DV6&index=10");
        france.put("Aller (to go) + prepositions (French Essentials Lesson 11)","https://www.youtube.com/watch?v=PaOVHdpRAK8&list=PLV1-QgpUU7N2TVWS6gEVMqEfAFjAl-DV6&index=11");

        stringMapMap.put("france",france);
    }
    private void enterLinksOfgeographic(){

        Map<String,String> map=new HashMap<>();
        map.put("Crash Course Geography Preview","https://www.youtube.com/watch?v=Di5vJwH0VZ8&list=PL8dPuuaLjXtO85Sl24rSiVQ93q7vcntNF");
        map.put("What is Geography? Crash Course Geography #1","https://www.youtube.com/watch?v=93LLwiMjDko&list=PL8dPuuaLjXtO85Sl24rSiVQ93q7vcntNF&index=2");
        map.put("What is a Map? Crash Course Geography #2","https://www.youtube.com/watch?v=iHEMOdRo5u8&list=PL8dPuuaLjXtO85Sl24rSiVQ93q7vcntNF&index=3");
        map.put("What is space and how do we study it? Crash Course Geography #3","https://www.youtube.com/watch?v=mtq2PG67w4E&list=PL8dPuuaLjXtO85Sl24rSiVQ93q7vcntNF&index=4");
        map.put("What is Physical Geography? Crash Course Geography #4","https://www.youtube.com/watch?v=vlVVaZhRAEA&list=PL8dPuuaLjXtO85Sl24rSiVQ93q7vcntNF&index=5");
        map.put("How Does the Earth Move? Crash Course Geography #5","https://www.youtube.com/watch?v=vlVVaZhRAEA&list=PL8dPuuaLjXtO85Sl24rSiVQ93q7vcntNF&index=6");
        map.put("What Does the Atmosphere Do? Crash Course Geography #6","https://www.youtube.com/watch?v=vlVVaZhRAEA&list=PL8dPuuaLjXtO85Sl24rSiVQ93q7vcntNF&index=7");
        map.put("How Does Air Temperature Shape a Place? Crash Course Geography #7","https://www.youtube.com/watch?v=vlVVaZhRAEA&list=PL8dPuuaLjXtO85Sl24rSiVQ93q7vcntNF&index=8");
        map.put("Where Does Wind Come From? Crash Course Geography #8","https://www.youtube.com/watch?v=vlVVaZhRAEA&list=PL8dPuuaLjXtO85Sl24rSiVQ93q7vcntNF&index=9");
        map.put("How Do Oceans Circulate? Crash Course Geography #9","https://www.youtube.com/watch?v=vlVVaZhRAEA&list=PL8dPuuaLjXtO85Sl24rSiVQ93q7vcntNF&index=10");
        map.put("What is a Cloud? Crash Course Geography #10","https://www.youtube.com/watch?v=vlVVaZhRAEA&list=PL8dPuuaLjXtO85Sl24rSiVQ93q7vcntNF&index=11");

        stringMapMap.put("geographic",map);
    }
    private void enterLinksOfspanich(){
        Map<String,String> map=new HashMap<>();
        map.put("Learn THE GREETINGS in Spanish","https://www.youtube.com/watch?v=Fkoansd4Ni0&list=PLYitpHBq-8SXrpjOHu6nU60Uq6QQ6NpIH");
        map.put("PERSONAL INFORMATION in Spanish","https://www.youtube.com/watch?v=4DoK7K9g7mE&list=PLYitpHBq-8SXrpjOHu6nU60Uq6QQ6NpIH&index=2");
        map.put("SER, TENER & LLAMARSE in Spanish ","https://www.youtube.com/watch?v=lnZOzKxDFQo&list=PLYitpHBq-8SXrpjOHu6nU60Uq6QQ6NpIH&index=3");
        map.put("Learn POR, PARA & PORQUE in Spanish","https://www.youtube.com/watch?v=IyZpY2knYxw&list=PLYitpHBq-8SXrpjOHu6nU60Uq6QQ6NpIH&index=4");
        map.put("Learn THE SIMPLE PRESENT in Spanish","https://www.youtube.com/watch?v=IyZpY2knYxw&list=PLYitpHBq-8SXrpjOHu6nU60Uq6QQ6NpIH&index=5");
        map.put("ARTICLES & PREPOSITIONS in Spanish","https://www.youtube.com/watch?v=IyZpY2knYxw&list=PLYitpHBq-8SXrpjOHu6nU60Uq6QQ6NpIH&index=6");
        map.put("SER, ESTAR & HAY in Spanish","https://www.youtube.com/watch?v=IyZpY2knYxw&list=PLYitpHBq-8SXrpjOHu6nU60Uq6QQ6NpIH&index=7");
        map.put("THE WEATHER in Spanish","https://www.youtube.com/watch?v=IyZpY2knYxw&list=PLYitpHBq-8SXrpjOHu6nU60Uq6QQ6NpIH&index=8");
        map.put("THE SUPERLATIVES in Spanish","https://www.youtube.com/watch?v=IyZpY2knYxw&list=PLYitpHBq-8SXrpjOHu6nU60Uq6QQ6NpIH&index=9");
        map.put("COLORS, CLOTHES & DAILY OBJECTS in Spanish","https://www.youtube.com/watch?v=IyZpY2knYxw&list=PLYitpHBq-8SXrpjOHu6nU60Uq6QQ6NpIH&index=10");
        map.put("ESTO, ESTE...THE DEMONSTRATIVES in Spanish","https://www.youtube.com/watch?v=IyZpY2knYxw&list=PLYitpHBq-8SXrpjOHu6nU60Uq6QQ6NpIH&index=11");

        stringMapMap.put("spanich",map);
    }
    private void enterLinksOfcoding(){
        Map<String,String> map=new HashMap<>();

        map.put("Harvard CS50 – Full Computer Science University Course","https://www.youtube.com/watch?v=8mAITcNt710&list=PLWKjhJtqVAblfum5WiQblKPwIbqYXkDoC");
        map.put("C++ Programming Course - Beginner to Advanced","https://www.youtube.com/watch?v=8jLOx1hD3_o&list=PLWKjhJtqVAblfum5WiQblKPwIbqYXkDoC&index=2");
        map.put("Frontend Web Development Bootcamp Course ","https://www.youtube.com/watch?v=zJSY8tbf_ys&list=PLWKjhJtqVAblfum5WiQblKPwIbqYXkDoC&index=3");
        map.put("APIs for Beginners 2023 - How to use an API (Full Course / Tutorial)","https://www.youtube.com/watch?v=zJSY8tbf_ys&list=PLWKjhJtqVAblfum5WiQblKPwIbqYXkDoC&index=4");
        map.put("Machine Learning for Everybody – Full Course","https://www.youtube.com/watch?v=zJSY8tbf_ys&list=PLWKjhJtqVAblfum5WiQblKPwIbqYXkDoC&index=5");
        map.put("Computer & Technology Basics Course for Absolute Beginners","https://www.youtube.com/watch?v=zJSY8tbf_ys&list=PLWKjhJtqVAblfum5WiQblKPwIbqYXkDoC&index=6");
        map.put("Learn JavaScript - Full Course for Beginners","https://www.youtube.com/watch?v=zJSY8tbf_ys&list=PLWKjhJtqVAblfum5WiQblKPwIbqYXkDoC&index=7");
        map.put("Data Structures Easy to Advanced Course - Full Tutorial from a Google","https://www.youtube.com/watch?v=zJSY8tbf_ys&list=PLWKjhJtqVAblfum5WiQblKPwIbqYXkDoC&index=8");
        map.put("Flutter Course for Beginners – 37-hour Cross Platform App Development","https://www.youtube.com/watch?v=zJSY8tbf_ys&list=PLWKjhJtqVAblfum5WiQblKPwIbqYXkDoC&index=10");
        map.put("Full Stack Web Development for Beginners (Full Course on HTML,CSS, JavaScript, Node.js, MongoDB)","https://www.youtube.com/watch?v=nu_pCVPKzTk&list=PLWKjhJtqVAblfum5WiQblKPwIbqYXkDoC&index=12");

        stringMapMap.put("coding",map);
    }
    private void enterLinksOfanimation(){

        Map<String,String> map=new HashMap<>();
        map.put("How to Animate ANYTHING - 4 Types of Motion","https://www.youtube.com/watch?v=iZBKWoSTVX8&list=PL5xtQ0kWJKFTkj4onkLmsY5WGinTLcPH8");
        map.put("The #1 Animation Principle (How To In-Between)","https://www.youtube.com/watch?v=6UXjRCORV44&list=PL5xtQ0kWJKFTkj4onkLmsY5WGinTLcPH8&index=2");
        map.put("Introduction to CHARACTER ANIMATION - Keys Extremes and Breakdowns","https://www.youtube.com/watch?v=6UXjRCORV44&list=PL5xtQ0kWJKFTkj4onkLmsY5WGinTLcPH8&index=3");
        map.put("Simple 2D Animation Practice | Head Turn Exercise","https://www.youtube.com/watch?v=6UXjRCORV44&list=PL5xtQ0kWJKFTkj4onkLmsY5WGinTLcPH8&index=4");
        map.put("How to Animate SLOW MOTION - 2D Animation Tutorial","https://www.youtube.com/watch?v=6UXjRCORV44&list=PL5xtQ0kWJKFTkj4onkLmsY5WGinTLcPH8&index=5");
        map.put("All About TIMING CHARTS for Beginners - 2D Animation Guide","https://www.youtube.com/watch?v=6UXjRCORV44&list=PL5xtQ0kWJKFTkj4onkLmsY5WGinTLcPH8&index=6");
        map.put("How Animation Works - 3 Basic Principles","https://www.youtube.com/watch?v=6UXjRCORV44&list=PL5xtQ0kWJKFTkj4onkLmsY5WGinTLcPH8&index=7");
        map.put("Make Animation Look NATURAL - The CHAIN PRINCIPLE","https://www.youtube.com/watch?v=6UXjRCORV44&list=PL5xtQ0kWJKFTkj4onkLmsY5WGinTLcPH8&index=8");
        map.put("Master ANIMATION POSING With This Formula ft. Clip Studio Paint Ver. 3.0","https://www.youtube.com/watch?v=6UXjRCORV44&list=PL5xtQ0kWJKFTkj4onkLmsY5WGinTLcPH8&index=9");
        map.put("How I Animate 2D Clothing FAST in OpenToonz Using New Tourbox LITE","https://www.youtube.com/watch?v=6UXjRCORV44&list=PL5xtQ0kWJKFTkj4onkLmsY5WGinTLcPH8&index=10");
        stringMapMap.put("animation",map);
    }
    private void enterLinksOfMath2(){

        Map<String,String> map=new HashMap<>();
        map.put("Transition to Advanced Math: 01 Introduction I 55 min","https://www.youtube.com/watch?v=e9hexV2tS7c&list=PLiyVurqwtq0bYubT9oI2IO9El3lPx-ZLh");
        map.put("Transition to Advanced Math: 02 Introduction II 39 min","https://www.youtube.com/watch?v=iygxphbdUmQ&list=PLiyVurqwtq0bYubT9oI2IO9El3lPx-ZLh&index=2");
        map.put("Transition to Advanced Math: 03 Introduction III 41 min","https://www.youtube.com/watch?v=iygxphbdUmQ&list=PLiyVurqwtq0bYubT9oI2IO9El3lPx-ZLh&index=3");
        map.put("Transition to Advanced Math: 04 Propositional Calculus I 55 min","https://www.youtube.com/watch?v=iygxphbdUmQ&list=PLiyVurqwtq0bYubT9oI2IO9El3lPx-ZLh&index=4");
        map.put("Transition to Advanced Math: 05 Propositional Calculus II 60 min","https://www.youtube.com/watch?v=iygxphbdUmQ&list=PLiyVurqwtq0bYubT9oI2IO9El3lPx-ZLh&index=5");
        map.put("Transition to Advanced Math: 06 Predicate Calculus 39 min","https://www.youtube.com/watch?v=iygxphbdUmQ&list=PLiyVurqwtq0bYubT9oI2IO9El3lPx-ZLh&index=6");
        map.put("Transition to Advanced Math: 07 ZF Axioms of Set Theory 33 min","https://www.youtube.com/watch?v=iygxphbdUmQ&list=PLiyVurqwtq0bYubT9oI2IO9El3lPx-ZLh&index=7");
        map.put("Transition to Advanced Math: 08 Proof Techniques I Introduction 46 min","https://www.youtube.com/watch?v=iygxphbdUmQ&list=PLiyVurqwtq0bYubT9oI2IO9El3lPx-ZLh&index=8");
        map.put("Transition to Advanced Math: 09 Proof Techniques II Direct Proofs 54 min","https://www.youtube.com/watch?v=iygxphbdUmQ&list=PLiyVurqwtq0bYubT9oI2IO9El3lPx-ZLh&index=9");
        map.put("Transition to Advanced Math: 10 Proof Techniques III Proof by Contrapositon, Contradiction 46 min","https://www.youtube.com/watch?v=iygxphbdUmQ&list=PLiyVurqwtq0bYubT9oI2IO9El3lPx-ZLh&index=10");

        stringMapMap.put("Math2",map);
    }
    private void enterLinksOftechnology(){

        Map<String,String> map=new HashMap<>();
        map.put("نقطة الوصول اللاسلكي مقابل راوتر Wi-Fi","https://www.youtube.com/watch?v=OxiY4yf6GGg&list=PL7zRJGi6nMRzHkyXpGZJg3KfRSCrF15Jg");
        map.put("ما هو هوت سبوت؟","https://www.youtube.com/watch?v=ktxC3vDukbc&list=PL7zRJGi6nMRzHkyXpGZJg3KfRSCrF15Jg&index=2");
        map.put("PING Command - Troubleshooting Networks","https://www.youtube.com/watch?v=ktxC3vDukbc&list=PL7zRJGi6nMRzHkyXpGZJg3KfRSCrF15Jg&index=3");
        map.put("وأوضح اللوحات الأم","https://www.youtube.com/watch?v=ktxC3vDukbc&list=PL7zRJGi6nMRzHkyXpGZJg3KfRSCrF15Jg&index=4");
        map.put("Tri-Band WiFi Router Explained.","https://www.youtube.com/watch?v=ktxC3vDukbc&list=PL7zRJGi6nMRzHkyXpGZJg3KfRSCrF15Jg&index=5");
        map.put("تزايدي مقابل التفاضلية النسخ الاحتياطي ، وشرح كامل","https://www.youtube.com/watch?v=ktxC3vDukbc&list=PL7zRJGi6nMRzHkyXpGZJg3KfRSCrF15Jg&index=6");
        map.put("ما هو جدار الحماية؟","https://www.youtube.com/watch?v=ktxC3vDukbc&list=PL7zRJGi6nMRzHkyXpGZJg3KfRSCrF15Jg&index=7");
        map.put("شرح أمان كلمة مرور WiFi (لاسلكي) - WEP ، WPA ، WPA2 ، WPA3 ، WPS","https://www.youtube.com/watch?v=ktxC3vDukbc&list=PL7zRJGi6nMRzHkyXpGZJg3KfRSCrF15Jg&index=8");
        map.put("DDNS - Dynamic DNS Explained","https://www.youtube.com/watch?v=ktxC3vDukbc&list=PL7zRJGi6nMRzHkyXpGZJg3KfRSCrF15Jg&index=9");
        map.put("Cable vs DSL vs Fiber Internet Explained","https://www.youtube.com/watch?v=ktxC3vDukbc&list=PL7zRJGi6nMRzHkyXpGZJg3KfRSCrF15Jg&index=10");


        stringMapMap.put("technology",map);
    }
    private void enterLinksOfEnglish(){

        Map<String,String> map=new HashMap<>();
        map.put("المستوى الاول, لمقدمة","https://www.youtube.com/watch?v=CbPy_CjJR90&list=PL2IkMHFHWdEqi0jiLXTEakULNDXGc-q_B");
        map.put("المستوى الاول استخدامقبل الاسم ( a - an)","https://www.youtube.com/watch?v=sX7eLnvedMo&list=PL2IkMHFHWdEqi0jiLXTEakULNDXGc-q_B&index=3");
        map.put("المستوى الاول الاسم ( مفرد - جمع )","https://www.youtube.com/watch?v=sX7eLnvedMo&list=PL2IkMHFHWdEqi0jiLXTEakULNDXGc-q_B&index=4");
        map.put("المستوى الأول ( ضمائر الفاعل )","https://www.youtube.com/watch?v=sX7eLnvedMo&list=PL2IkMHFHWdEqi0jiLXTEakULNDXGc-q_B&index=5");
        map.put("English Grammar Subjective Pronouns + 'Be' Verb","https://www.youtube.com/watch?v=sX7eLnvedMo&list=PL2IkMHFHWdEqi0jiLXTEakULNDXGc-q_B&index=6");
        map.put("English Grammar: Subjective Pronouns + Be + Not","https://www.youtube.com/watch?v=sX7eLnvedMo&list=PL2IkMHFHWdEqi0jiLXTEakULNDXGc-q_B&index=7");
        map.put("English Grammar: Be Verb Pronoun Questions","https://www.youtube.com/watch?v=sX7eLnvedMo&list=PL2IkMHFHWdEqi0jiLXTEakULNDXGc-q_B&index=8");
        map.put("English Grammar: Review #1 - Subjective Pronouns","https://www.youtube.com/watch?v=sX7eLnvedMo&list=PL2IkMHFHWdEqi0jiLXTEakULNDXGc-q_B&index=9");
        map.put("Grammar Check Up #1","https://www.youtube.com/watch?v=sX7eLnvedMo&list=PL2IkMHFHWdEqi0jiLXTEakULNDXGc-q_B&index=10");
        map.put("English Grammar: What + Be Verb Questions","https://www.youtube.com/watch?v=sX7eLnvedMo&list=PL2IkMHFHWdEqi0jiLXTEakULNDXGc-q_B&index=11");

        stringMapMap.put("English",map);
    }
    private void enterLinksOfArabic(){

        Map<String,String> map=new HashMap<>();
        map.put("Harvard CS50 – Full Computer Science University Course","https://www.youtube.com/watch?v=8mAITcNt710&list=PLWKjhJtqVAblfum5WiQblKPwIbqYXkDoC");
        stringMapMap.put("Arabic",map);
    }
    private void enterLinksOfmath(){

        Map<String,String> map=new HashMap<>();
        map.put("Harvard CS50 – Full Computer Science University Course","https://www.youtube.com/watch?v=8mAITcNt710&list=PLWKjhJtqVAblfum5WiQblKPwIbqYXkDoC");
        stringMapMap.put("math",map);
    }
     private void clearMemoryMap(){
        stringMapMap.clear();
    }

    @Override
    protected void onStop() {
        super.onStop();
        clearMemoryMap();
    }
}
