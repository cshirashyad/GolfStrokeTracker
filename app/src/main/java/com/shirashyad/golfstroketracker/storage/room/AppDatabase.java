package com.shirashyad.golfstroketracker.storage.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.shirashyad.golfstroketracker.storage.room.dao.CourseDao;
import com.shirashyad.golfstroketracker.storage.room.dao.CourseDetailsDao;
import com.shirashyad.golfstroketracker.storage.room.dao.GameDao;
import com.shirashyad.golfstroketracker.storage.room.dao.StrokeDao;
import com.shirashyad.golfstroketracker.storage.room.dao.UserDao;
import com.shirashyad.golfstroketracker.storage.room.entity.Course;
import com.shirashyad.golfstroketracker.storage.room.entity.CourseDetails;
import com.shirashyad.golfstroketracker.storage.room.entity.Game;
import com.shirashyad.golfstroketracker.storage.room.entity.Stroke;
import com.shirashyad.golfstroketracker.storage.room.entity.User;

import java.util.List;

/**
 * Created by chandra.shirashyad on 11/26/17.
 */

@Database(entities = {Course.class, CourseDetails.class, Game.class, Stroke.class, User.class
}, version = 16, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract CourseDao courseDao();
    public abstract CourseDetailsDao courseDetailsDao();
    public abstract GameDao gameDao();
    public abstract StrokeDao strokeDao();
    public abstract UserDao userDao();

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context, AppDatabase.class, "userdatabase")
                            //Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                            // For now allow queries on the main thread.
                            // Don't do this on a real app!
                            .allowMainThreadQueries()
                            // recreate the database if necessary
                            .fallbackToDestructiveMigration()
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    // Generate the data for pre-population
                                    AppDatabase database = AppDatabase.getDatabase(context);

                                    insertCourses(database, DataPrepopulator.getCourseList());
                                    insertCourseDetailss(database, DataPrepopulator.getCourseDetailsList());
                                }
                            })
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private static void insertCourses(final AppDatabase database, final List<Course> courses) {
        database.runInTransaction(() -> {
            database.courseDao().insertAll(courses);
        });
    }

    private static void insertCourseDetailss(final AppDatabase database, final List<CourseDetails> courseDetails) {
        database.runInTransaction(() -> {
            database.courseDetailsDao().insertAll(courseDetails);
        });
    }

}
