package com.wp.androidgameengine.engine.threads;

import android.app.Activity;

import com.wp.androidgameengine.R;
import com.wp.androidgameengine.engine.Texture;

public class GameThread extends BaseThread {

    private final Activity ha;

    public GameThread(ThreadCommunicator tc, Activity hostActivity) {
        super(tc);
        this.ha = hostActivity;
    }

    @Override
    public void doLoopAction() {

        if (threadCommunicator.IsFrameConsumed()) {


            threadCommunicator.setSwappingFlag(false);

            for (int i = 0; i < 100; i++) {
                Texture ro = new Texture((float)Math.random() * 400, (float)Math.random() * 400, 32, 32, R.drawable.dragon);
                Texture ro1 = new Texture((float)Math.random() * 400, (float)Math.random() * 400, 32, 32, R.drawable.back);
                threadCommunicator.Produce(ro);
                threadCommunicator.Produce(ro1);
            }
        }
    }
}
