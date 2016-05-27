package com.wp.androidgameengine.engine.objects;

import com.wp.androidgameengine.engine.threads.ThreadCommunicator;
import com.wp.androidgameengine.engine.watchdog.collections.GuardedLinkedList;

import java.util.Queue;
import java.util.Random;

/**
 * Created by Rafał on 19.05.2016.
 */
public class DynamicLayer extends Layer {

    private Queue<TextureLayer> myQueue = new GuardedLinkedList<TextureLayer>();
    Random randomGenerator;

    public DynamicLayer(int layerID, float deviceWidth, float deviceHeight, float layerWidth, float layerHeight, TextureLayer[] textures, float pxMS) {
        super(layerID, deviceWidth, deviceHeight, layerWidth, layerHeight, textures, pxMS);

        // funkcja prawdopodobienstwa
        // queue = new guarded list
        //linkedlist z funkcji

        randomGenerator = new Random();

        for(int i=0; i <textures.length; i++)
            myQueue.offer(textures[i]);
    }


    //TODO PRZEROBIC NA O(1)
    private TextureLayer getNextTexture(){

        TextureLayer resultTexture = null;

        float acc = 0f;

        float random = randomGenerator.nextFloat();

        for (TextureLayer tl: getTextures()) {
            acc += tl.getProbability();
            if(acc >= random){
                resultTexture = tl;
                break;
            }
        }

        return resultTexture;
    }

    @Override
    protected void onUpdate(long timeDelta, ThreadCommunicator tc) {

       // cos z  getPxMS() i time delta jesli true to {
        //cos z pxMS
        //if(timeDelta COS Z PXMS) {
        TextureLayer txt = myQueue.poll();
        myQueue.offer(txt);
    }

}
