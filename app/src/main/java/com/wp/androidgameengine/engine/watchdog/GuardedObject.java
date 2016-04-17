package com.wp.androidgameengine.engine.watchdog;

import android.app.Notification;
import android.util.Log;

import com.wp.androidgameengine.engine.watchdog.collections.GuardedArrayList;

import java.util.Objects;

/**
 * This is the object initialization watchdog. It logs every object initialization where the flag
 * is set to True. Every object in the ingine should derive from this class, or call
 * staticguard method (For API classes). When deriving, all classes should call super() in
 * constructors.
 */
public class GuardedObject {

    private static boolean isActive;

    public static void setIsActive(boolean isActive) {
        GuardedObject.isActive = isActive;
    }

    public GuardedObject(){
        log(this);
    }

    public static void staticGuard(Object obj){
        log(obj);
    }

    private static void log(Object obj){
        if(GuardedObject.isActive) {
            Log.e("===INIT WATCHDOG===", String.format("Initialized %s object!", obj.getClass().getSimpleName()));
        }
    }
}

