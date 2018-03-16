package com.shirashyad.golfstroketracker;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;

import com.shirashyad.golfstroketracker.storage.room.AppDatabase;
import com.shirashyad.golfstroketracker.storage.room.entity.Course;
import com.shirashyad.golfstroketracker.storage.room.entity.CourseDetails;

import java.util.List;

/**
 * Created by chandra.shirashyad on 12/10/17.
 */

public class DataRepository {

    private static DataRepository sInstance;

    private final AppDatabase mDatabase;
    private MediatorLiveData<List<Course>> mObservableCourses;

    private DataRepository(final AppDatabase database) {
        mDatabase = database;
        mObservableCourses = new MediatorLiveData<>();

        mObservableCourses.addSource(mDatabase.courseDao().getAllCourses(),
                courseEntities -> {
                    if (mDatabase.getDatabaseCreated().getValue() != null) {
                        mObservableCourses.postValue(courseEntities);
                    }
                });
    }

    public static DataRepository getInstance(final AppDatabase database) {
        if (sInstance == null) {
            synchronized (DataRepository.class) {
                if (sInstance == null) {
                    sInstance = new DataRepository(database);
                }
            }
        }
        return sInstance;
    }

    /**
     * Get the list of products from the database and get notified when the data changes.
     */
    public LiveData<List<Course>> getCourses() {
        return mObservableCourses;
    }

    public LiveData<Course> getCourse(final int courseId) {
        return mDatabase.courseDao().getCourse(courseId);
    }

    public LiveData<List<CourseDetails>> getCourseDetails(final int courseId) {
        return mDatabase.courseDetailsDao().getCourseDetails(courseId);
    }
}
