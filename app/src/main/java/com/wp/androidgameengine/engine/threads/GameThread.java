package com.wp.androidgameengine.engine.threads;

import android.app.Activity;

import com.wp.androidgameengine.R;
import com.wp.androidgameengine.engine.RenderingObject;

/**
 * Created by maciek on 20.04.16.
 */
public class GameThread extends BaseThread {

    private final Activity ha;

    public GameThread(ThreadCommunicator tc, Activity hostActivity){

        super(tc);
        this.ha = hostActivity;


    }


    RenderingObject ro = new RenderingObject(50,50,32,32, R.drawable.dragon);

    @Override
    public void doLoopAction() {

        ro.setX((float)Math.random() * 100);
        ro.setY((float)Math.random() * 100);

        threadCommunicator.Produce(ro);

    }
}
