package com.shirashyad.golfstroketracker.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.shirashyad.golfstroketracker.R;

public class CourseDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCourse(view);
            }
        };

        Button addCourseBtn = findViewById(R.id.addCourseBtn);
        addCourseBtn.setOnClickListener(clickListener);

    }

    public void addCourse(View view) {
    }

}
