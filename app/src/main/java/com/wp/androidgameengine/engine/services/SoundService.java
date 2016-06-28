package com.wp.androidgameengine.engine.services;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.SparseIntArray;
import android.widget.Toast;

import com.wp.androidgameengine.engine.objects.Sound;
import com.wp.androidgameengine.engine.watchdog.GuardedObject;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

 /*

    @startuml

    class SoundService{
        -current : SoundService
        -SoundService()
        +getInstance()
    }

    @enduml

    */


public class SoundService extends GuardedObject {

    private static SoundService current;

    private final SoundPool sp;
    private static Context context;

    private final SparseIntArray soundDictionary;

    private SoundService() {
        super();
        sp = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundDictionary = new SparseIntArray();
    }

    public void init(ArrayList<Integer> sounds){
        for (Integer i: sounds) {
            loadSound(i);
        }
    }

    private void loadSound(Integer soundId){
        soundDictionary.put(soundId, sp.load(context, soundId, 1));
    }

    public void playSound(Sound s){
        sp.play(soundDictionary.get(s.getSoundId()), 1, 1, 1, 0, 1.0f);
    }

    public static void setContext(Context c){
        SoundService.context = c;
    }

    public static SoundService getInstance(){
        if(current == null){
            current = new SoundService();
        }
        return current;
    }

    public void onDestroy(){
        sp.release();
    }



}
