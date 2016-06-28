package com.wp.androidgameengine.game.threads;

import android.app.Activity;

import com.wp.androidgameengine.R;
import com.wp.androidgameengine.engine.events.Events;
import com.wp.androidgameengine.engine.objects.GameObject;
import com.wp.androidgameengine.engine.objects.Texture;
import com.wp.androidgameengine.engine.threads.BaseThread;
import com.wp.androidgameengine.engine.threads.ThreadCommunicator;


public class GameThread extends BaseThread {

    private final GameObject rootObject;
    private final Events events;

    public GameThread(GameObject rootObject, Events events) {
        super();
        this.rootObject = rootObject;
        this.events = events;
    }

    @Override
    public void doLoopAction(long timeDelta) {

        if (threadCommunicator.IsFrameConsumed()) {

            threadCommunicator.setSwappingFlag(false);

            this.rootObject.update(timeDelta, threadCommunicator, events);
        }
    }
}
