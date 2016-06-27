package com.wp.androidgameengine.engine.threads;

import android.opengl.GLSurfaceView;

import com.wp.androidgameengine.engine.watchdog.GuardedObject;

public abstract class BaseThread extends GuardedObject implements Runnable {

    protected ThreadCommunicator threadCommunicator;
    private boolean enabled = true;
    private boolean stop = false;
    private boolean pause = false;
    private GLSurfaceView surfaceView;


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

    public long lastTime = 0;

    @Override
    public void run(){
        while(!stop && !pause){
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            long currentTime = System.currentTimeMillis();

            if(this.enabled && lastTime != 0){
                this.doLoopAction(currentTime - lastTime);
                surfaceView.requestRender();
            }

            lastTime = currentTime;
        }
    }

    public abstract void doLoopAction(long timeDelta);

    public void onPause(){
        pause = true;
    }

    public void onResume(){
        pause = false;
    }


    public void setSurfaceView(GLSurfaceView surfaceView) {
        this.surfaceView = surfaceView;
    }
}
