package com.shirashyad.golfstroketracker;

import android.app.Application;

import com.shirashyad.golfstroketracker.storage.room.AppDatabase;

/**
 * Created by chandra.shirashyad on 12/10/17.
 */

public class GolfStrokeTrackerApp extends Application {
    private AppExecutors mAppExecutors;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppExecutors = new AppExecutors();
    }

    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this, mAppExecutors);
    }

}
