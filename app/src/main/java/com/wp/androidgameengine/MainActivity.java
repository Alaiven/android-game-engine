package com.wp.androidgameengine;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.wp.androidgameengine.engine.renderer.MainRenderer;
import com.wp.androidgameengine.engine.surface.MainSurfaceView;

import java.io.IOException;

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
            MainRenderer mainRenderer = new MainRenderer();

            mainSurfaceView.setEGLContextClientVersion(2);
            mainSurfaceView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
            mainSurfaceView.setRenderer(mainRenderer);
            this.setContentView(mainSurfaceView);

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
