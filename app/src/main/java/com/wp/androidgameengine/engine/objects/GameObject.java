package com.wp.androidgameengine.engine.objects;

import com.wp.androidgameengine.engine.threads.ThreadCommunicator;
import com.wp.androidgameengine.engine.watchdog.GuardedObject;
import com.wp.androidgameengine.engine.watchdog.collections.GuardedArrayList;

public abstract class GameObject extends GuardedObject {

    protected GuardedArrayList<GameObject> items;

    public GuardedArrayList<GameObject> getItems() {
        return items;
    }

    public GameObject(){
        super();
        items = new GuardedArrayList<>();
    }

    public void update(int timeDelta, ThreadCommunicator tc){
        for (GameObject go: items) {
            go.onUpdate(timeDelta, tc);
            go.update(timeDelta, tc);
        }
    }

    public abstract void onUpdate(int timeDelta, ThreadCommunicator tc);

}
