package com.wp.androidgameengine.engine.objects.device;

import android.util.Log;

/**
 * Created by msz93 on 26.06.2016.
 */

public abstract class Logger {

    public static void Log(Object item){
        Log.e("GAME", String.valueOf(item));
    }

}
