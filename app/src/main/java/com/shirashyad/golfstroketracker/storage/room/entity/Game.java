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
    @PrimaryKey
    public final int id;
    public String gameDate;
    public int courseId;

    public Game(int id, String gameDate, int courseId) {
        this.id = id;
        this.gameDate = gameDate;
        this.courseId = courseId;
    }
}
