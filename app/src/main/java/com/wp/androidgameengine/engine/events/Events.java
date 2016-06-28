package com.wp.androidgameengine.engine.events;


import com.wp.androidgameengine.engine.watchdog.GuardedObject;

public class Events extends GuardedObject {

    private boolean screenPressed;

    public Events(){
        super();
    }

    public boolean isScreenPressed() {
        return screenPressed;
    }

    public void setScreenPressed(boolean screenPressed) {
        this.screenPressed = screenPressed;
    }
}
