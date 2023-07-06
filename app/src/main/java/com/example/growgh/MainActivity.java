package com.example.growgh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button,feeds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.upload);
        feeds=findViewById(R.id.btn_feed);
        button.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this,Upload.class));
        });
        feeds.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this,Feeds.class));
        });




    }
}