package com.wp.androidgameengine.engine.threads;

import com.wp.androidgameengine.engine.watchdog.GuardedObject;

/**
 * Created by maciek on 20.04.16.
 */
public class RenderingThread extends BaseThread{

    public RenderingThread(ThreadCommunicator tc){
        super(tc);
    }

    @Override
    public void doLoopAction() {

    }

}
