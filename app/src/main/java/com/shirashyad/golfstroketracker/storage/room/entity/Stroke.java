package com.shirashyad.golfstroketracker.storage.room.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by chandra.shirashyad on 11/26/17.
 */

@Entity(tableName = "stroke",
        foreignKeys = {
                @ForeignKey(
                        entity = Game.class,
                        parentColumns = "id",
                        childColumns = "gameId",
                        onDelete = ForeignKey.RESTRICT
                ),
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "id",
                        childColumns = "userId",
                        onDelete = ForeignKey.RESTRICT
                )
        },
        indices = { @Index(value = "id")}
)
public class Stroke {
    @PrimaryKey
    public final int id;
    public int gameId;
    public int userId;
    public int longShot;
    public int longMissedShot;
    public int penalty;
    public int fairwayBunkerShot;
    public int pitchShot;
    public int greenSideBunkerShot;
    public int chipShot;
    public int putt;

    public Stroke(int id, int gameId, int userId, int longShot, int longMissedShot, int penalty, int fairwayBunkerShot, int pitchShot, int greenSideBunkerShot, int chipShot, int putt) {
        this.id = id;
        this.gameId = gameId;
        this.userId = userId;
        this.longShot = longShot;
        this.longMissedShot = longMissedShot;
        this.penalty = penalty;
        this.fairwayBunkerShot = fairwayBunkerShot;
        this.pitchShot = pitchShot;
        this.greenSideBunkerShot = greenSideBunkerShot;
        this.chipShot = chipShot;
        this.putt = putt;
    }
}
