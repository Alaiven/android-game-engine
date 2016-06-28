package com.wp.androidgameengine.game;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

import com.wp.androidgameengine.R;
import com.wp.androidgameengine.engine.objects.BaseGame;
import com.wp.androidgameengine.engine.objects.GameObject;
import com.wp.androidgameengine.engine.objects.Sound;
import com.wp.androidgameengine.engine.objects.Vec2;
import com.wp.androidgameengine.engine.objects.components.animation.AnimationFactory;
import com.wp.androidgameengine.engine.objects.components.animation.AnimationFrame;
import com.wp.androidgameengine.engine.objects.components.animation.IAnimationFactory;
import com.wp.androidgameengine.game.commands.ICommand;
import com.wp.androidgameengine.game.commands.JumpCommand;
import com.wp.androidgameengine.game.components.Physics;
import com.wp.androidgameengine.engine.objects.enemy.Enemy;
import com.wp.androidgameengine.engine.objects.enemy.EnemySpawner;
import com.wp.androidgameengine.engine.objects.map.DynamicLayer;
import com.wp.androidgameengine.engine.objects.map.Map;
import com.wp.androidgameengine.engine.objects.map.MapTexture;
import com.wp.androidgameengine.engine.objects.device.DeviceInfo;
import com.wp.androidgameengine.engine.objects.player.Player;
import com.wp.androidgameengine.engine.watchdog.collections.GuardedArrayList;
import com.wp.androidgameengine.game.threads.GameThread;
import com.wp.androidgameengine.game.components.SteadyMovement;


public class Game extends BaseGame {

    private final DeviceInfo deviceInfo;

    private ICommand jumpCommand;

    public Game(Context c, DeviceInfo di){
        super(c);
        deviceInfo = di;

        setGameThread(new GameThread(this.getRootObject()));
    }

    public void init(){
        GuardedArrayList<Integer> textureList = new GuardedArrayList<>();
        GuardedArrayList<Integer> soundList = new GuardedArrayList<>();

        addTextures(textureList);
        addSounds(soundList);

        loadResources(textureList, soundList);

        rootObject.addItem(setUpMap());
        rootObject.addItem(setUpPlayer());
        rootObject.addItems((GameObject[]) setUpEnemies());

        addListeners();
    }



    private final Vec2 x64 = new Vec2(64, 64);
    private final Vec2 x128 = new Vec2(128, 128);
    private final Vec2 x0 = new Vec2(0, 0);

    private Map setUpMap(){
        MapTexture tl1 = new MapTexture(x64, R.drawable.floor1, 0.1f);
        MapTexture tl2 = new MapTexture(x64, R.drawable.floor2, 0.1f);
        MapTexture tl3 = new MapTexture(x64, R.drawable.floor3, 0.8f);

        MapTexture cl1 = new MapTexture(x128, R.drawable.cloud1, 0.1f);
        MapTexture cl2 = new MapTexture(x128, R.drawable.blank, 0.9f);

        MapTexture[] groundArr = new MapTexture[]{tl1, tl2, tl3};
        DynamicLayer ground = new DynamicLayer(deviceInfo, 0, new Vec2(0, deviceInfo.getHeight() - 64), groundArr, 0.6f);

        MapTexture[] cloudArr = new MapTexture[] {cl1, cl2};

        DynamicLayer clouds1 = new DynamicLayer(deviceInfo, 1, new Vec2(0, deviceInfo.getHeight() - 200), cloudArr, 0.15f);
        DynamicLayer clouds2 = new DynamicLayer(deviceInfo, 1, new Vec2(0, deviceInfo.getHeight() - 300), cloudArr, 0.1f);

        Map myMap = new Map();

        myMap.addLayer(ground);
        myMap.addLayer(clouds1);
        myMap.addLayer(clouds2);

        return myMap;
    }

    private final IAnimationFactory af = new AnimationFactory();

    private Player setUpPlayer(){
        Player p = new Player(new Vec2(20, deviceInfo.getHeight() - 138), x128);

        AnimationFrame af1 = new AnimationFrame(x128, R.drawable.dino1, 100);
        AnimationFrame af2 = new AnimationFrame(x128, R.drawable.dino2, 100);

        Sound jump = new Sound(R.raw.jump);
        Physics ph = new Physics(deviceInfo.getHeight() - 10);

        jumpCommand = new JumpCommand(ph, jump);

        p.addComponent(af.create(af1, af2));
        p.addComponent(ph);

        return p;
    }


    private EnemySpawner[] setUpEnemies() {

        AnimationFrame afRock = new AnimationFrame(x128, R.drawable.rock1, 0);
        AnimationFrame af1 = new AnimationFrame(x128, R.drawable.skelet1, 100);
        AnimationFrame af2 = new AnimationFrame(x128, R.drawable.skelet2, 100);

        SteadyMovement sm = new SteadyMovement(0.6f);
        SteadyMovement sm1 = new SteadyMovement(0.65f);

        Enemy e = new Enemy(x0, x128, 0.7f, 0.5f);
        e.addComponent(af.create(afRock));
        e.addComponent(sm);

        Enemy e1 = new Enemy(x0, x128, 0.3f, 0.7f);
        e1.addComponent(af.create(af1, af2));
        e1.addComponent(sm1);

        EnemySpawner es = new EnemySpawner(deviceInfo, new Vec2(deviceInfo.getWidth() + 10, deviceInfo.getHeight() - 138), new Enemy[]{e, e1}, 3, 1000);

        return new EnemySpawner[] {es};
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
        textures.add(R.drawable.skelet1);
        textures.add(R.drawable.skelet2);
        textures.add(R.drawable.rock1);
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
                        jumpCommand.Execute();
                        break;
                }
                return true;
            }
        });
    }




}
