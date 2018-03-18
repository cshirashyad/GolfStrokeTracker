package com.shirashyad.golfstroketracker.storage.room.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by chandra.shirashyad on 11/23/17.
 */

@Entity
public class User {
    @PrimaryKey
    public final int id;
    public String firstName;
    public String lastName;
    public String email;


    public User(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
