package com.wp.androidgameengine.engine.objects;

import com.wp.androidgameengine.engine.watchdog.GuardedObject;

public class Sound extends GuardedObject {
    private int soundId;

    public int getSoundId() {
        return soundId;
    }

    public Sound(int soundId){
        super();
        this.soundId = soundId;
    }

}
