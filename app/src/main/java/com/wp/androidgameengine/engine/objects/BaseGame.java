package com.wp.androidgameengine.engine.objects;

import android.content.Context;
import android.opengl.GLSurfaceView;

import com.wp.androidgameengine.R;
import com.wp.androidgameengine.engine.exceptions.NotLoadedException;
import com.wp.androidgameengine.engine.renderer.MainRenderer;
import com.wp.androidgameengine.engine.services.SoundService;
import com.wp.androidgameengine.engine.surface.MainSurfaceView;
import com.wp.androidgameengine.engine.threads.BaseThread;
import com.wp.androidgameengine.engine.threads.ThreadCommunicator;
import com.wp.androidgameengine.engine.watchdog.GuardedObject;
import com.wp.androidgameengine.engine.watchdog.collections.GuardedArrayList;

import java.util.ArrayList;

/**
 * Created by maciek on 19.05.16.
 */
public abstract class BaseGame extends GuardedObject {

    protected Context context;
    protected ThreadCommunicator threadCommunicator;
    protected Boolean loaded = false;
    protected BaseThread gameThread;

    private MainRenderer renderer;
    private SoundService soundService;
    private MainSurfaceView mainSurfaceView;

    public MainRenderer getRenderer() {
        return renderer;
    }

    public SoundService getSoundService(){
        return soundService;
    }

    public GLSurfaceView getView() {
        return mainSurfaceView;
    }

    public void setGameThread(BaseThread gameThread) {
        this.gameThread = gameThread;
        gameThread.setThreadCommunicator(threadCommunicator);
    }

    public BaseGame(Context c){
        super();
        context = c;
        threadCommunicator = new ThreadCommunicator();

        renderer = new MainRenderer(threadCommunicator, context);
        soundService = new SoundService(c);

        mainSurfaceView = new MainSurfaceView(context);
        mainSurfaceView.setEGLContextClientVersion(2);
        //mainSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
        mainSurfaceView.setRenderer(renderer);
    }

    protected void loadResources(ArrayList<Integer> textureList, ArrayList<Integer> soundList){
        renderer.init(textureList);
        soundService.init(soundList);
        loaded = true;
    }

    public void start(){
        if(loaded) {
            new Thread(gameThread).start();
        }else{
            throw new NotLoadedException("Resources are not loaded!");
        }
    }

    public void onResume(){
        gameThread.onResume();
        renderer.onResume();
        mainSurfaceView.onResume();
    }

    public void onPause(){
        gameThread.onPause();
        renderer.onPause();
        mainSurfaceView.onPause();
    }

    public void onDestroy(){
        soundService.onDestroy();
    }


}
