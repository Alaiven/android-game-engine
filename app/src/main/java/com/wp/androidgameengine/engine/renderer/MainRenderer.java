package com.wp.androidgameengine.engine.renderer;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import com.wp.androidgameengine.engine.RenderingObject;
import com.wp.androidgameengine.engine.threads.ThreadCommunicator;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by msz93 on 25.04.2016.
 */
public class MainRenderer implements GLSurfaceView.Renderer {


    private final ThreadCommunicator tc;

    public MainRenderer(ThreadCommunicator tc) {
        this.tc = tc;
    }


    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glClearColor(0.2f, 0.0f, 0.0f, 1.0f);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

        while(!tc.IsConsumeEmpty()) {
            RenderingObject ro = tc.Consume();
        }
    }

}
