package com.shirashyad.golfstroketracker.storage.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.shirashyad.golfstroketracker.storage.room.entity.Stroke;

import java.util.List;

/**
 * Created by chandra.shirashyad on 11/26/17.
 */

@Dao
public interface StrokeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addStroke(Stroke stroke);

    @Query("select * from stroke")
    public List<Stroke> getAllStroke();

    @Query("select * from stroke where id = :strokeId")
    public List<Stroke> getStroke(long strokeId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateStroke(Stroke stroke);

    @Query("delete from stroke where gameId = :gameId")
    void removeAllStrokes(long gameId);
}
