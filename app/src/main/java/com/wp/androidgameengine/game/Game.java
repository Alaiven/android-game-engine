package com.wp.androidgameengine.game;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

import com.wp.androidgameengine.R;
import com.wp.androidgameengine.engine.events.Events;
import com.wp.androidgameengine.engine.objects.BaseGame;
import com.wp.androidgameengine.engine.objects.Position;
import com.wp.androidgameengine.engine.objects.Sound;
import com.wp.androidgameengine.engine.objects.components.animation.Animation;
import com.wp.androidgameengine.engine.objects.components.animation.AnimationFrame;
import com.wp.androidgameengine.engine.objects.components.physics.Physics;
import com.wp.androidgameengine.engine.objects.map.DynamicLayer;
import com.wp.androidgameengine.engine.objects.map.Map;
import com.wp.androidgameengine.engine.objects.map.MapTexture;
import com.wp.androidgameengine.engine.objects.device.DeviceInfo;
import com.wp.androidgameengine.engine.objects.player.Player;
import com.wp.androidgameengine.engine.watchdog.collections.GuardedArrayList;
import com.wp.androidgameengine.game.threads.GameThread;


public class Game extends BaseGame {

    private final DeviceInfo deviceInfo;

    private final Events events;

    public Game(Context c, DeviceInfo di){
        super(c);
        deviceInfo = di;

        events = new Events();

        setGameThread(new GameThread(this.getRootObject(), events));
    }

    public void init(){
        GuardedArrayList<Integer> textureList = new GuardedArrayList<>();
        GuardedArrayList<Integer> soundList = new GuardedArrayList<>();

        addTextures(textureList);
        addSounds(soundList);

        loadResources(textureList, soundList);

        rootObject.addItem(setUpMap());
        rootObject.addItem(setUpPlayer());

        addListeners();
    }



    private Map setUpMap(){
        MapTexture tl1 = new MapTexture(64, 64, R.drawable.floor1, 0.1f);
        MapTexture tl2 = new MapTexture(64, 64, R.drawable.floor2, 0.1f);
        MapTexture tl3 = new MapTexture(64, 64, R.drawable.floor3, 0.8f);

        MapTexture cl1 = new MapTexture(128, 128, R.drawable.cloud1, 0.1f);
        MapTexture cl2 = new MapTexture(128, 128, R.drawable.blank, 0.9f);

        MapTexture[] groundArr = new MapTexture[]{tl1, tl2, tl3};
        DynamicLayer ground = new DynamicLayer(deviceInfo, 0, 0, deviceInfo.height - 64, groundArr, 0.5f);

        MapTexture[] cloudArr = new MapTexture[] {cl1, cl2};

        DynamicLayer clouds1 = new DynamicLayer(deviceInfo, 1, 0, deviceInfo.height - 200, cloudArr, 0.15f);
        DynamicLayer clouds2 = new DynamicLayer(deviceInfo, 1, 0, deviceInfo.height - 300, cloudArr, 0.1f);

        Map myMap = new Map();

        myMap.addLayer(ground);
        myMap.addLayer(clouds1);
        myMap.addLayer(clouds2);

        return myMap;
    }

    private Player setUpPlayer(){
        Player p = new Player(new Position(20, deviceInfo.height - 138));

        AnimationFrame af1 = new AnimationFrame(128, 128, R.drawable.dino1, 100);
        AnimationFrame af2 = new AnimationFrame(128, 128, R.drawable.dino2, 100);

        Animation an = new Animation(new AnimationFrame[] {af1, af2});

        Sound jump = new Sound(R.raw.jump);
        Physics ph = new Physics(deviceInfo.height - 10, jump);

        p.addComponent(an);
        p.addComponent(ph);

        return p;
    }

    private void addTextures(GuardedArrayList<Integer> textures){
        //HERE GOES EVERY TEXTURE

        textures.add(R.drawable.floor1);
        textures.add(R.drawable.floor2);
        textures.add(R.drawable.floor3);
        textures.add(R.drawable.dino1);
        textures.add(R.drawable.dino2);
        textures.add(R.drawable.cloud1);
        textures.add(R.drawable.blank);
    }

    private void addSounds(GuardedArrayList<Integer> sounds) {
        //HERE GOES EVERY SOUND

        sounds.add(R.raw.jump);
    }

    private void addListeners(){
        getView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        events.setScreenPressed(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        events.setScreenPressed(false);
                        break;
                }
                return true;
            }
        });
    }




}
