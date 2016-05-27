package com.wp.androidgameengine.engine.objects;

import com.wp.androidgameengine.engine.threads.ThreadCommunicator;

/**
 * Created by Rafał on 19.05.2016.
 */
public class Map extends GameObject {
//
// doladywowane textury
// ilosc textur
// przewijanie zaleznie od czasu
// kilka  poziomow

    //array list dodawanie layerow


    public Map() {
    }

    public void addLayer(Layer layer){
        items.add(layer.getLayerID(), layer);
    }

    public void getLayer(Layer layer){
        items.get(layer.getLayerID());
    }

    @Override
    protected void onUpdate(long timeDelta, ThreadCommunicator tc) {
        //nic sie nie dzieje
    }
}
