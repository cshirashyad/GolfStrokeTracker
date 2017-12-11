package com.shirashyad.golfstroketracker.ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.shirashyad.golfstroketracker.GolfStrokeTrackerApp;
import com.shirashyad.golfstroketracker.R;
import com.shirashyad.golfstroketracker.databinding.ActivityTrackerBinding;
import com.shirashyad.golfstroketracker.storage.room.AppDatabase;

import java.util.ArrayList;
import java.util.List;

public class TrackerActivity extends AppCompatActivity {
    CourseListAdapter adapter;
    List arrayList= new ArrayList();
    ActivityTrackerBinding activityTrackerBinding;
    private AppDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);
        activityTrackerBinding = DataBindingUtil.setContentView((Activity) this, R.layout.activity_tracker);


        mDatabase = ((GolfStrokeTrackerApp) getApplication()).getDatabase();
        List<String> courses = mDatabase.courseDao().getAllCourseNames();
        arrayList.addAll(courses);

        adapter= new CourseListAdapter(arrayList);
        activityTrackerBinding.listView.setAdapter(adapter);
        activityTrackerBinding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        activityTrackerBinding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
                String value = (String)adapterView.getItemAtPosition(position);
                Toast.makeText(getApplication(), "Cool, you wanna play: " + value,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
