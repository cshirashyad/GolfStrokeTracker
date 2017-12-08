package com.shirashyad.golfstroketracker.storage.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.shirashyad.golfstroketracker.storage.room.entity.Course;

import java.util.List;

/**
 * Created by chandra.shirashyad on 11/26/17.
 */

@Dao
public interface CourseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addCourse(Course course);

    @Query("select * from course")
    public List<Course> getAllCourse();

    @Query("select * from course where id = :courseId")
    public List<Course> getCourse(long courseId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateCourse(Course course);

    @Query("delete from course")
    void removeAllCourses();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Course> courses);

}
