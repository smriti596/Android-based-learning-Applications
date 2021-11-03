package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView textView1= (TextView) findViewById(R.id.menu_item_1);
        String s1= (String) textView1.getText();
        Log.v("MainActivity",s1);

        // Find second menu item TextView and print the text to the logs
        TextView textView2= (TextView) findViewById(R.id.menu_item_2);
        String s2= (String) textView2.getText();
        Log.v("MainActivity",s2);

        // Find third menu item TextView and print the text to the logs
        TextView textView3= (TextView) findViewById(R.id.menu_item_3);
        String s3= (String) textView3.getText();
        Log.v("MainActivity",s3);

    }
}