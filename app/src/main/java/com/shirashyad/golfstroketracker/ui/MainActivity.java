package com.shirashyad.golfstroketracker.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.shirashyad.golfstroketracker.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button playGolf = findViewById(R.id.playGolfBtn);
        playGolf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectCourse(view);
            }
        });
        Button addCourseBtn = findViewById(R.id.addCourseBtn);
        addCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCourse(view);
            }
        });
    }

    public void addCourse(View view) {
        Intent intent = new Intent(this, CourseDetailsActivity.class);
        startActivity(intent);
    }

    public void selectCourse(View view) {
        Intent intent = new Intent(this, SelectCourseActivity.class);
        startActivity(intent);
    }

}
