package com.wp.androidgameengine.game.threads;

import android.app.Activity;

import com.wp.androidgameengine.R;
import com.wp.androidgameengine.engine.objects.GameObject;
import com.wp.androidgameengine.engine.objects.Texture;
import com.wp.androidgameengine.engine.threads.BaseThread;
import com.wp.androidgameengine.engine.threads.ThreadCommunicator;


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

            for (int i = 0; i < 100; i++) {
                Texture ro = new Texture((float)Math.random() * 400, (float)Math.random() * 400, 32, 32, R.drawable.dragon);
                Texture ro1 = new Texture((float)Math.random() * 400, (float)Math.random() * 400, 32, 32, R.drawable.back);
                threadCommunicator.Produce(ro);
                threadCommunicator.Produce(ro1);
            }
        }
    }
}
