package com.shirashyad.golfstroketracker.storage.keyvalue;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class CommonPreferences {
    private SharedPreferences sharedPreferences;
    public static final String GAMEID_IN_PROGRESS = "GAMEID_IN_PROGRESS";

    public CommonPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences("GolfTrackerPrefs", 0);
    }

    public int getGameidInProgress() {
        return sharedPreferences.getInt(GAMEID_IN_PROGRESS, 0);
    }

    public void setGameidInProgress(int gameId) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(GAMEID_IN_PROGRESS, gameId);
        editor.commit();
    }
}
