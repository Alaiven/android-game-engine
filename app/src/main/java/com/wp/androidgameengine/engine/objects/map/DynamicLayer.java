package com.wp.androidgameengine.engine.objects.map;

import com.wp.androidgameengine.engine.events.Events;
import com.wp.androidgameengine.engine.objects.Position;
import com.wp.androidgameengine.engine.objects.device.DeviceInfo;
import com.wp.androidgameengine.engine.threads.ThreadCommunicator;
import com.wp.androidgameengine.engine.watchdog.collections.GuardedLinkedList;

import java.util.Queue;
import java.util.Random;

public class DynamicLayer extends Layer {

    {
        randomGenerator = new Random();
        layerQueue = new GuardedLinkedList<>();
    }

    private final Queue<MapTexture> layerQueue;
    private final Random randomGenerator;
    private final int texturesOnScreen;
    private final DeviceInfo deviceInfo;


    public DynamicLayer(DeviceInfo di, int layerID, int x, int y, MapTexture[] textures, float pxMS) {
        super(layerID, x, y, textures, pxMS);

        deviceInfo = di;

        texturesOnScreen = deviceInfo.width / (int)textureWidth;

        setUp();
    }


    private void setUp(){
        int posX = layerX - textureWidth * 2;

        for (int i = 0; i < texturesOnScreen + 4; i++) {
            MapTexture texture = getNextTexture();
            layerQueue.offer(texture.clone(posX, layerY));
            posX += textureWidth;
        }
    }

    private int texturesOffScreen;
    private float lastPosition;
    private Position position;

    private void moveAndRender(float pixelsToMove, ThreadCommunicator tc) {
        texturesOffScreen = 0;
        lastPosition = 0;

        for(MapTexture tl : layerQueue){
            position = tl.getPosition();

            position.setX(position.getX() - pixelsToMove);

            if(position.getX() <= 2 * -textureWidth){
                texturesOffScreen++;
            }

            lastPosition = position.getX();
        }

        for (int i = 0; i < texturesOffScreen; i++) {
            lastPosition += textureWidth;

            MapTexture tl = layerQueue.poll();

            position = tl.getPosition();

            tl.setTextureId(getNextTexture().getTextureId());

            position.setX(lastPosition);

            layerQueue.offer(tl);
        }

        for(MapTexture tl : layerQueue){
            tc.Produce(tl);
        }
    }

    private float acc;
    private float random;

    //TODO PRZEROBIC NA O(1)
    private MapTexture getNextTexture(){

        MapTexture resultTexture = null;

        acc = 0f;

        random = randomGenerator.nextFloat();

        for (MapTexture tl: textures) {
            acc += tl.getProbability();
            if(acc >= random){
                resultTexture = tl;
                break;
            }
        }

        return resultTexture;
    }



    @Override
    protected void onUpdate(long timeDelta, ThreadCommunicator tc, Events e) {
            float pixelsToMove = pxMS * timeDelta;
            moveAndRender(pixelsToMove, tc);
    }



}
