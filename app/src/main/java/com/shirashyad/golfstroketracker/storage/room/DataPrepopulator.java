package com.shirashyad.golfstroketracker.storage.room;

import com.shirashyad.golfstroketracker.storage.room.entity.Course;
import com.shirashyad.golfstroketracker.storage.room.entity.CourseDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chandra.shirashyad on 12/4/17.
 *
 * Generates data to pre-populate the database
 */
public class DataPrepopulator {

    public static List<Course> getCourseList() {
        List<Course> courses = new ArrayList<>(2);
        courses.add(new Course(
                1,
                "Fremont Park",
                "Unknown",
                "Unknown",
                32,
                9
        ));
        courses.add(new Course(
                2,
                "Pleasanton Fairgrounds",
                "Unknown",
                "Unknown",
                30,
                9
        ));
        courses.add(new Course(
                3,
                "Summit Point Golf Course",
                "Unknown",
                "Unknown",
                72,
                18
        ));
        return courses;
    }

    public static List<CourseDetails> getCourseDetailsList() {
        List<CourseDetails> courseDetails = new ArrayList() {
            {
                add(new CourseDetails(1, 1, 1, 0, 3, null));
                add(new CourseDetails(2, 1, 2, 0, 4, null));
                add(new CourseDetails(3, 1, 3, 0, 3, null));
                add(new CourseDetails(4, 1, 4, 0, 4, null));
                add(new CourseDetails(5, 1, 5, 0, 4, null));
                add(new CourseDetails(6, 1, 6, 0, 3, null));
                add(new CourseDetails(7, 1, 7, 0, 4, null));
                add(new CourseDetails(8, 1, 8, 0, 3, null));
                add(new CourseDetails(9, 1, 8, 0, 4, null));

                add(new CourseDetails(10, 2, 1, 0, 4, null));
                add(new CourseDetails(11, 2, 2, 0, 3, null));
                add(new CourseDetails(12, 2, 3, 0, 3, null));
                add(new CourseDetails(13, 2, 4, 0, 4, null));
                add(new CourseDetails(14, 2, 5, 0, 3, null));
                add(new CourseDetails(15, 2, 6, 0, 3, null));
                add(new CourseDetails(16, 2, 7, 0, 4, null));
                add(new CourseDetails(17, 2, 8, 0, 3, null));
                add(new CourseDetails(18, 2, 9, 0, 3, null));

                add(new CourseDetails(19, 3, 1, 0, 4, null));
                add(new CourseDetails(20, 3, 2, 0, 5, null));
                add(new CourseDetails(21, 3, 3, 0, 3, null));
                add(new CourseDetails(22, 3, 4, 0, 4, null));
                add(new CourseDetails(23, 3, 5, 0, 3, null));
                add(new CourseDetails(24, 3, 6, 0, 4, null));
                add(new CourseDetails(25, 3, 7, 0, 4, null));
                add(new CourseDetails(26, 3, 8, 0, 4, null));
                add(new CourseDetails(27, 3, 9, 0, 5, null));
                add(new CourseDetails(28, 3, 10, 0, 4, null));
                add(new CourseDetails(29, 3, 11, 0, 4, null));
                add(new CourseDetails(30, 3, 12, 0, 4, null));
                add(new CourseDetails(31, 3, 13, 0, 3, null));
                add(new CourseDetails(32, 3, 14, 0, 5, null));
                add(new CourseDetails(33, 3, 15, 0, 5, null));
                add(new CourseDetails(34, 3, 16, 0, 3, null));
                add(new CourseDetails(35, 3, 17, 0, 4, null));
                add(new CourseDetails(36, 3, 18, 0, 4, null));
            }
        };

        return courseDetails;
    }

}
