package com.wp.androidgameengine;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wp.androidgameengine.engine.renderer.MainRenderer;
import com.wp.androidgameengine.engine.surface.MainSurfaceView;
import com.wp.androidgameengine.engine.threads.GameThread;
import com.wp.androidgameengine.engine.threads.ThreadCommunicator;
import com.wp.androidgameengine.engine.watchdog.GuardedObject;
import com.wp.androidgameengine.engine.watchdog.collections.GuardedArrayList;

public class MainActivity extends AppCompatActivity {

    private MainSurfaceView mainSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mainSurfaceView = new MainSurfaceView(this);

        ActivityManager am = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
        ConfigurationInfo info = am.getDeviceConfigurationInfo();

        //boolean supportES2 = (info.reqGlEsVersion >= 0x20000);

        boolean supportES2 = true; //FOR EMULATOR!

        if(supportES2){

            ThreadCommunicator tc = new ThreadCommunicator();

            new Thread(new GameThread(tc, this)).start();

            MainRenderer mainRenderer = new MainRenderer(tc, this);

            GuardedArrayList<Integer> initList = new GuardedArrayList<>();

            //tablica stringow
            initList.add(R.drawable.dragon);
            initList.add(R.drawable.back);


            mainRenderer.init(initList);

            mainSurfaceView.setEGLContextClientVersion(2);
           // mainSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
            mainSurfaceView.setRenderer(mainRenderer);
            this.setContentView(mainSurfaceView);

            GuardedObject.setIsActive(true);

        }else{
            Log.e("OpenGLES 2", "Your device doesn't support ES2");
        }
    }

    protected void onResume()
    {
        super.onResume();
        mainSurfaceView.onResume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        mainSurfaceView.onPause();
    }
}
