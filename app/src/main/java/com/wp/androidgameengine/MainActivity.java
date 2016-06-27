package com.wp.androidgameengine;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import com.wp.androidgameengine.engine.objects.device.DeviceInfo;
import com.wp.androidgameengine.game.Game;
import com.wp.androidgameengine.engine.watchdog.GuardedObject;

public class MainActivity extends Activity {

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();

        DeviceInfo di = new DeviceInfo(displayMetrics.widthPixels, displayMetrics.heightPixels);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        ActivityManager am = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
        ConfigurationInfo info = am.getDeviceConfigurationInfo();

        boolean supportES2 = (info.reqGlEsVersion >= 0x20000);



        //boolean supportES2 = true; //FOR EMULATOR!

        if(supportES2){

            game = new Game(this, di);

            this.setContentView(game.getView());

            game.init();

            GuardedObject.setIsActive(true);

            game.start();

        }else{
            Log.e("OpenGLES 2", "Your device doesn't support ES2");
        }
    }

    protected void onResume()
    {
        super.onResume();
        game.onResume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        game.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        game.onDestroy();
    }

}
