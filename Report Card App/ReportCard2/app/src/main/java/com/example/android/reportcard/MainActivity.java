package com.example.android.reportcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<reportCardClass> report=new ArrayList<>();
        report.add(new reportCardClass("A","English","87"));
        report.add(new reportCardClass("B","Maths","77"));
        report.add(new reportCardClass("A+","Computer","97"));
        report.add(new reportCardClass("C","Physics","60"));

        ReportAdapter adapter= new ReportAdapter(this,report);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);



    }
}