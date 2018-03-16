package com.shirashyad.golfstroketracker.storage.room.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by chandra.shirashyad on 11/28/17.
 */

@Entity(tableName = "courseDetails",
        foreignKeys = {
                @ForeignKey(
                        entity = Course.class,
                        parentColumns = "id",
                        childColumns = "courseId",
                        onDelete = ForeignKey.RESTRICT
                )
        },
        indices = { @Index(value = "id")}
)
public class CourseDetails {
    @PrimaryKey
    public final int id;
    public int courseId;
    public int hole;
    public int yardage;
    public int par;
    public String notes;

    public CourseDetails(int id, int courseId, int hole, int yardage, int par, String notes) {
        this.id = id;
        this.courseId = courseId;
        this.hole = hole;
        this.yardage = yardage;
        this.par = par;
        this.notes = notes;
    }
}
