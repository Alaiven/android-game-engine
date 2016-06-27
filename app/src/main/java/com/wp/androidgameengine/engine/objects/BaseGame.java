package com.wp.androidgameengine.engine.objects;

import android.content.Context;
import android.opengl.GLSurfaceView;

import com.wp.androidgameengine.engine.exceptions.NotLoadedException;
import com.wp.androidgameengine.engine.renderer.MainRenderer;
import com.wp.androidgameengine.engine.services.SoundService;
import com.wp.androidgameengine.engine.renderer.MainSurfaceView;
import com.wp.androidgameengine.engine.threads.BaseThread;
import com.wp.androidgameengine.engine.threads.ThreadCommunicator;
import com.wp.androidgameengine.engine.watchdog.GuardedObject;

import java.util.ArrayList;

public abstract class BaseGame extends GuardedObject {

    {
        rootObject = new GameObject() {
            @Override
            protected void onUpdate(long timeDelta, ThreadCommunicator tc) {
                update(timeDelta, tc);
            }
        };
    }


    protected Context context;
    protected ThreadCommunicator threadCommunicator;
    protected Boolean loaded = false;
    protected BaseThread gameThread;

    private MainRenderer renderer;
    private SoundService soundService;
    private MainSurfaceView mainSurfaceView;
    protected final GameObject rootObject;

    public GameObject getRootObject(){
        return rootObject;
    }

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
        gameThread.setSurfaceView(mainSurfaceView);
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
        mainSurfaceView.setRenderer(renderer);
        mainSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
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
