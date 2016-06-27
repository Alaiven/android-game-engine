package com.wp.androidgameengine.engine.objects.map;

import com.wp.androidgameengine.engine.objects.GameObject;
import com.wp.androidgameengine.engine.threads.ThreadCommunicator;

public class Map extends GameObject {

    public Map() {
        super();
    }

    public void addLayer(Layer layer){
        this.addItemOnIndex(layer.getLayerID(), layer);
    }

    @Override
    protected void onUpdate(long timeDelta, ThreadCommunicator tc) {
        //nic sie nie dzieje
    }
}
