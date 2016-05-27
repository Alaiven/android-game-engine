package com.wp.androidgameengine.engine.objects;

import com.wp.androidgameengine.engine.threads.ThreadCommunicator;
import com.wp.androidgameengine.engine.watchdog.collections.GuardedLinkedList;

import java.util.Queue;

/**
 * Created by Rafał on 19.05.2016.
 */
public class DynamicLayer extends Layer {

    public Queue<TextureLayer> myQueue = new GuardedLinkedList<TextureLayer>();

    public DynamicLayer(int layerID, float deviceWidth, float deviceHeight, float layerWidth, float layerHeight, TextureLayer[] textures, float pxMS) {
        super(layerID, deviceWidth, deviceHeight, layerWidth, layerHeight, textures, pxMS);

        // funkcja prawdopodobienstwa
        // queue = new guarded list
        //linkedlist z funkcji

        probabilityFunction(getTextures().length);

        for(int i=0; i <textures.length; i++)
            myQueue.offer(textures[i]);
    }



    public int probabilityFunction(int texturesSize){

        // RANDOM PO WIELKOSCI TABLICY
        // PRZYKLAD 5 TEXTUR KAZDA MA SWOJE PRAWDOPODOBIENSTWO

        return 0;
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
