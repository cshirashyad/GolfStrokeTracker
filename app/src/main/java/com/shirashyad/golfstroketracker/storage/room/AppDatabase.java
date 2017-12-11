package com.shirashyad.golfstroketracker.storage.room;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.shirashyad.golfstroketracker.AppExecutors;
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

    public abstract CourseDao courseDao();
    public abstract CourseDetailsDao courseDetailsDao();
    public abstract GameDao gameDao();
    public abstract StrokeDao strokeDao();
    public abstract UserDao userDao();

    private static AppDatabase sInstance;

    @VisibleForTesting
    public static final String DATABASE_NAME = "golf-tracker-db";

    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    public static AppDatabase getInstance(final Context context, final AppExecutors executors) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = buildDatabase(context.getApplicationContext(), executors);
                    sInstance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    /**
     * Build the database. {@link Builder#build()} only sets up the database configuration and
     * creates a new instance of the database.
     * The SQLite database is only created when it's accessed for the first time.
     */
    private static AppDatabase buildDatabase(final Context appContext,
                                             final AppExecutors executors) {
        return Room.databaseBuilder(appContext, AppDatabase.class, DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        executors.diskIO().execute(() -> {
                            // Add a delay to simulate a long-running operation
                            addDelay();
                            // Generate the data for pre-population
                            AppDatabase database = AppDatabase.getInstance(appContext, executors);
                            insertData(database, DataPrepopulator.getCourseList(), DataPrepopulator.getCourseDetailsList());
                            // notify that the database was created and it's ready to be used
                            database.setDatabaseCreated();
                        });
                    }
                })
                .allowMainThreadQueries()
                .build();
    }

    /**
     * Check whether the database already exists and expose it via {@link #getDatabaseCreated()}
     */
    private void updateDatabaseCreated(final Context context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            setDatabaseCreated();
        }
    }

    private void setDatabaseCreated(){
        mIsDatabaseCreated.postValue(true);
    }

    private static void insertData(final AppDatabase database, final List<Course> courses,
                                   final List<CourseDetails> courseDetails) {
        database.runInTransaction(() -> {
            database.courseDao().insertAll(courses);
            database.courseDetailsDao().insertAll(courseDetails);
        });
    }

    private static void addDelay() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ignored) {
        }
    }

    public LiveData<Boolean> getDatabaseCreated() {
        return mIsDatabaseCreated;
    }
}
