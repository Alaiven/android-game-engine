package com.wp.androidgameengine.game;

import android.content.Context;

import com.wp.androidgameengine.R;
import com.wp.androidgameengine.engine.objects.BaseGame;
import com.wp.androidgameengine.engine.objects.DynamicLayer;
import com.wp.androidgameengine.engine.objects.GameObject;
import com.wp.androidgameengine.engine.objects.Map;
import com.wp.androidgameengine.engine.objects.TextureLayer;
import com.wp.androidgameengine.engine.watchdog.collections.GuardedArrayList;
import com.wp.androidgameengine.game.threads.GameThread;



public class Game extends BaseGame {

    GameObject rootObject;

    public Game(Context c){
        super(c);
        setGameThread(new GameThread(rootObject));
    }


    public void init(){
        GuardedArrayList<Integer> textureList = new GuardedArrayList<>();
        GuardedArrayList<Integer> soundList = new GuardedArrayList<>();

        textureList.add(R.drawable.back);
        textureList.add(R.drawable.dragon);
        textureList.add(R.drawable.line1);
        textureList.add(R.drawable.line2);

        soundList.add(R.raw.coin);

        loadResources(textureList, soundList);

        rootObject = setUpMap();
    }

    private Map setUpMap(){
        TextureLayer tl1 = new TextureLayer(1, 2, 32, 32, R.drawable.line1 , (float)0.8);
        TextureLayer tl2 = new TextureLayer(1, 2, 32, 32, R.drawable.line2, (float)0.2);
        TextureLayer[] myTextureLayerTab = new TextureLayer[]{tl1, tl2};
        DynamicLayer dl = new DynamicLayer(1, 468, 720, 468, 720, myTextureLayerTab, 30);
        Map myMap = new Map();
        myMap.addLayer(dl);
        return myMap;
    }


}
