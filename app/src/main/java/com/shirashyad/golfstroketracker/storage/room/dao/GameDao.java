package com.shirashyad.golfstroketracker.storage.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.shirashyad.golfstroketracker.storage.room.entity.Game;

import java.util.List;

/**
 * Created by chandra.shirashyad on 11/26/17.
 */

@Dao
public interface GameDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addGame(Game game);

    @Query("select * from game")
    public List<Game> getAllGame();

    @Query("select * from game where id = :gameId")
    public Game getGame(int gameId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateGame(Game game);

    @Query("delete from game")
    void removeAllGame();
}
