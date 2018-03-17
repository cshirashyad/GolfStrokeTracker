package com.shirashyad.golfstroketracker.storage.room.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by chandra.shirashyad on 11/23/17.
 */

@Entity(tableName = "game",
        foreignKeys = {
                @ForeignKey(
                        entity = Course.class,
                        parentColumns = "id",
                        childColumns = "courseId",
                        onDelete = ForeignKey.RESTRICT
                )},
        indices = { @Index(value = "id")}
)
public class Game {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String gameDate;
    public int courseId;

    public Game(String gameDate, int courseId) {
        this.gameDate = gameDate;
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
