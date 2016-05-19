package com.wp.androidgameengine.engine.services;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.widget.Toast;

import com.wp.androidgameengine.engine.objects.Sound;
import com.wp.androidgameengine.engine.watchdog.GuardedObject;

import java.util.Dictionary;
import java.util.HashMap;

/**
 * Created by maciek on 19.05.16.
 */
public class SoundService extends GuardedObject {

    private final SoundPool sp;
    private final Context context;

    private final HashMap<Integer, Integer> soundDictionary;

    private static SoundService instance;

    public static SoundService getService(Context c) {
        if(instance != null){
            return instance;
        }else{
            instance = new SoundService(c);
            return instance;
        }
    }

    private SoundService(Context c) {
        super();
        context = c;
        sp = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundDictionary = new HashMap<>();
    }

    public void loadSound(Sound s){
        soundDictionary.put(s.getSoundId(), sp.load(context, s.getSoundId(), 1));
    }

    public void playSound(Sound s){
        sp.play(soundDictionary.get(s.getSoundId()), 1, 1, 1, 0, 1.0f);
    }

    public void destroy(){
        sp.release();
    }



}
