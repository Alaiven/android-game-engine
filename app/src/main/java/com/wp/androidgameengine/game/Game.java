package com.wp.androidgameengine.game;

import android.content.Context;

import com.wp.androidgameengine.R;
import com.wp.androidgameengine.engine.objects.BaseGame;
import com.wp.androidgameengine.engine.objects.GameObject;
import com.wp.androidgameengine.engine.watchdog.collections.GuardedArrayList;
import com.wp.androidgameengine.game.threads.GameThread;

import java.util.ArrayList;


public class Game extends BaseGame {

    GameObject rootObject;

    public Game(Context c){
        super(c);
        setGameThread(new GameThread());
    }

    public void init(){
        GuardedArrayList<Integer> textureList = new GuardedArrayList<>();
        GuardedArrayList<Integer> soundList = new GuardedArrayList<>();

        textureList.add(R.drawable.back);
        textureList.add(R.drawable.dragon);

        soundList.add(R.raw.coin);

        loadResources(textureList, soundList);
    }

}
