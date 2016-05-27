package com.wp.androidgameengine.engine.threads;

import com.wp.androidgameengine.engine.threads.ThreadCommunicator;
import com.wp.androidgameengine.engine.watchdog.GuardedObject;

/**
 * Created by maciek on 20.04.16.
 */
public abstract class BaseThread extends GuardedObject implements Runnable {


    protected ThreadCommunicator threadCommunicator;
    private boolean enabled = true;
    private boolean stop = false;
    private boolean pause = false;

    public void setThreadCommunicator(ThreadCommunicator threadCommunicator) {
        this.threadCommunicator = threadCommunicator;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setStop(boolean stop){
        this.stop = stop;
    }

    public BaseThread(){
        super();
    }

    public long lastTime;

    @Override
    public void run(){
        while(!stop && !pause){
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            if(this.enabled){

                long currentTime = System.currentTimeMillis();

                this.doLoopAction(currentTime - lastTime);

                lastTime = currentTime;
            }
        }
    }

    public abstract void doLoopAction(long timeDelta);

    public void onPause(){
        pause = true;
    }

    public void onResume(){
        pause = false;
    }


}
