package com.wp.androidgameengine.game.threads;

import com.wp.androidgameengine.engine.objects.GameObject;
import com.wp.androidgameengine.engine.threads.BaseThread;


public class GameThread extends BaseThread {

    private final GameObject rootObject;

    public GameThread(GameObject rootObject) {
        super();
        this.rootObject = rootObject;
    }

    @Override
    public void doLoopAction(long timeDelta) {

        if (threadCommunicator.IsFrameConsumed()) {

            threadCommunicator.setSwappingFlag(false);

            this.rootObject.update(timeDelta, threadCommunicator);
        }
    }
}
