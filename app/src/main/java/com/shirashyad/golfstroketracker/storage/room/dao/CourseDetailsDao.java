package com.shirashyad.golfstroketracker.storage.room.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.shirashyad.golfstroketracker.storage.room.entity.CourseDetails;

import java.util.List;

/**
 * Created by chandra.shirashyad on 11/28/17.
 */

@Dao
public interface CourseDetailsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addCourseDetails(CourseDetails courseDetails);

    @Query("select * from courseDetails")
    public LiveData<List<CourseDetails>> getAllCourseDetails();

    @Query("select * from courseDetails where id = :courseDetailsId")
    public LiveData<List<CourseDetails>> getCourseDetails(long courseDetailsId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateCourseDetails(CourseDetails courseDetails);

    @Query("delete from courseDetails where courseId = :courseId")
    void removeAllCourseDetails(long courseId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<CourseDetails> courseDetails);

}
