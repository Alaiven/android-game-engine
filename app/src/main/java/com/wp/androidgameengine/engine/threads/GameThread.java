package com.wp.androidgameengine.engine.threads;

import com.wp.androidgameengine.engine.watchdog.GuardedObject;

/**
 * Created by maciek on 20.04.16.
 */
public class GameThread extends BaseThread {

    public GameThread(ThreadCommunicator tc){
        super(tc);
    }

    @Override
    public void doLoopAction() {


    }
}
