package com.wp.androidgameengine.game;

import android.content.Context;

import com.wp.androidgameengine.engine.objects.BaseGame;
import com.wp.androidgameengine.game.threads.GameThread;


public class Game extends BaseGame {


    public Game(Context c){
        super(c);
        setGameThread(new GameThread());
    }

    public void init(){

    }

}
