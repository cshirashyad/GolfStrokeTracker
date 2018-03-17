package com.shirashyad.golfstroketracker.storage.room.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by chandra.shirashyad on 11/26/17.
 */

@Entity
public class Course {
    @PrimaryKey
    public final int id;
    public String name;
    public String slope;
    public String rating;
    public int par;
    public int holes;

    public Course(int id, String name, String slope, String rating, int par, int holes) {
        this.id = id;
        this.name = name;
        this.slope = slope;
        this.rating = rating;
        this.par = par;
        this.holes = holes;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
