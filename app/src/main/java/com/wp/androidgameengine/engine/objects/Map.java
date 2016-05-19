package com.wp.androidgameengine.engine.objects;

import com.wp.androidgameengine.engine.watchdog.GuardedObject;

/**
 * Created by Rafał on 19.05.2016.
 */
public class Map extends GuardedObject {
//
// doladywowane textury
// ilosc textur
// przewijanie zaleznie od czasu
// kilka  poziomow


    // level 0 = podziemia, level 1 = ziemia, level 2 = niebo
    private Layer level0, level1, level2;
    private int id;
    private float currentTime;

    public Map(Layer level0, Layer level1, Layer level2, int id, float currentTime) {
        this.level0 = level0;
        this.level1 = level1;
        this.level2 = level2;
        this.id = id;
        this.currentTime = currentTime;
    }

    public Layer getLevel0() {
        return level0;
    }

    public void setLevel0(Layer level0) {
        this.level0 = level0;
    }

    public Layer getLevel1() {
        return level1;
    }

    public void setLevel1(Layer level1) {
        this.level1 = level1;
    }

    public Layer getLevel2() {
        return level2;
    }

    public void setLevel2(Layer level2) {
        this.level2 = level2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
    }
}
