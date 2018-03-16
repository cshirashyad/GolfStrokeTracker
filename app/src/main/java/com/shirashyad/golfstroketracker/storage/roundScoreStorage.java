package com.shirashyad.golfstroketracker.storage;

import com.shirashyad.golfstroketracker.storage.room.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chandra.shirashyad on 1/2/18.
 *
 * This is to hold the round score during the play until the user decides to persist the data to DB
 *
 */

public class roundScoreStorage {
    int userId;
    int courseId;
    Map<String, Integer> hole1Stroke = new HashMap<>(6);
    Map<String, Integer> hole2Stroke = new HashMap<>(6);
    Map<String, Integer> hole3Stroke = new HashMap<>(6);
    Map<String, Integer> hole4Stroke = new HashMap<>(6);
    Map<String, Integer> hole5Stroke = new HashMap<>(6);
    Map<String, Integer> hole6Stroke = new HashMap<>(6);
    Map<String, Integer> hole7Stroke = new HashMap<>(6);
    Map<String, Integer> hole8Stroke = new HashMap<>(6);
    Map<String, Integer> hole9Stroke = new HashMap<>(6);
    Map<String, Integer> hole10Stroke = new HashMap<>(6);
    Map<String, Integer> hole11Stroke = new HashMap<>(6);
    Map<String, Integer> hole12Stroke = new HashMap<>(6);
    Map<String, Integer> hole13Stroke = new HashMap<>(6);
    Map<String, Integer> hole14Stroke = new HashMap<>(6);
    Map<String, Integer> hole15Stroke = new HashMap<>(6);
    Map<String, Integer> hole16Stroke = new HashMap<>(6);
    Map<String, Integer> hole17Stroke = new HashMap<>(6);
    Map<String, Integer> hole18Stroke = new HashMap<>(6);

    public int getUserId() {
        return userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public Map<String, Integer> getHole1Stroke() {
        return hole1Stroke;
    }

    public Map<String, Integer> getHole2Stroke() {
        return hole2Stroke;
    }

    public Map<String, Integer> getHole3Stroke() {
        return hole3Stroke;
    }

    public Map<String, Integer> getHole4Stroke() {
        return hole4Stroke;
    }

    public Map<String, Integer> getHole5Stroke() {
        return hole5Stroke;
    }

    public Map<String, Integer> getHole6Stroke() {
        return hole6Stroke;
    }

    public Map<String, Integer> getHole7Stroke() {
        return hole7Stroke;
    }

    public Map<String, Integer> getHole8Stroke() {
        return hole8Stroke;
    }

    public Map<String, Integer> getHole9Stroke() {
        return hole9Stroke;
    }

    public Map<String, Integer> getHole10Stroke() {
        return hole10Stroke;
    }

    public Map<String, Integer> getHole11Stroke() {
        return hole11Stroke;
    }

    public Map<String, Integer> getHole12Stroke() {
        return hole12Stroke;
    }

    public Map<String, Integer> getHole13Stroke() {
        return hole13Stroke;
    }

    public Map<String, Integer> getHole14Stroke() {
        return hole14Stroke;
    }

    public Map<String, Integer> getHole15Stroke() {
        return hole15Stroke;
    }

    public Map<String, Integer> getHole16Stroke() {
        return hole16Stroke;
    }

    public Map<String, Integer> getHole17Stroke() {
        return hole17Stroke;
    }

    public Map<String, Integer> getHole18Stroke() {
        return hole18Stroke;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setHole1Stroke(int longShots, int pitchShots, int chipShots, int fairwayBunkerShots, int greensideBunkerShots, int penalties, int putts) {
        this.hole1Stroke.put("longShot", longShots);
        this.hole1Stroke.put("pitchShot", pitchShots);
        this.hole1Stroke.put("chipShot", chipShots);
        this.hole1Stroke.put("fairwayBunkerShot", fairwayBunkerShots);
        this.hole1Stroke.put("greensideBunkerShot", greensideBunkerShots);
        this.hole1Stroke.put("penalty", penalties);
        this.hole1Stroke.put("putt", putts);
    }

    public void setHole2Stroke(int longShots, int pitchShots, int chipShots, int fairwayBunkerShots, int greensideBunkerShots, int penalties, int putts) {
        this.hole1Stroke.put("longShot", longShots);
        this.hole1Stroke.put("pitchShot", pitchShots);
        this.hole1Stroke.put("chipShot", chipShots);
        this.hole1Stroke.put("fairwayBunkerShot", fairwayBunkerShots);
        this.hole1Stroke.put("greensideBunkerShot", greensideBunkerShots);
        this.hole1Stroke.put("penalty", penalties);
        this.hole1Stroke.put("putt", putts);
    }
}
