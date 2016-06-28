package com.wp.androidgameengine.engine.objects;

import com.wp.androidgameengine.engine.events.Events;
import com.wp.androidgameengine.engine.threads.ThreadCommunicator;
import com.wp.androidgameengine.engine.watchdog.GuardedObject;
import com.wp.androidgameengine.engine.watchdog.collections.GuardedArrayList;

import java.util.Collections;

public abstract class GameObject extends GuardedObject {

    {
        items = new GuardedArrayList<>();
    }

    private GuardedArrayList<GameObject> items;

    public GuardedArrayList<GameObject> getItems() {
        return items;
    }

    public void addItem(GameObject item){
        items.add(item);
    }

    public void addItemOnIndex(int index, GameObject item){
        items.add(index, item);
    }

    public void addItems(GameObject ... items){
        Collections.addAll(this.items, items);
    }

    public GameObject(){
        super();
    }

    public void update(long timeDelta, ThreadCommunicator tc, Events e){
            for (GameObject go : items) {
                go.onUpdate(timeDelta, tc, e);
                go.update(timeDelta, tc, e);
            }
    }

    protected abstract void onUpdate(long timeDelta, ThreadCommunicator tc, Events e);

}
