package com.wp.androidgameengine.engine.objects;

import com.wp.androidgameengine.engine.threads.ThreadCommunicator;
import com.wp.androidgameengine.engine.watchdog.GuardedObject;
import com.wp.androidgameengine.engine.watchdog.collections.GuardedArrayList;

import java.util.Collections;

public abstract class GameObject extends GuardedObject {

    /*

    @startuml

    class GameObject{
        +update(timeDelta:long, tc : ThreadCommunicator)
        #onUpdate(timeDelta:long, tc : ThreadCommunicator)
    }

    class Entity{
        #onUpdate(timeDelta:long, tc : ThreadCommunicator)
        #customUpdate(timeDelta:long, tc : ThreadCommunicator)
    }

    class Player{
        #customUpdate(timeDelta:long, tc : ThreadCommunicator)
    }

    GameObject <|-- Entity

       Entity <|-- Player

    @enduml

     */

     /*

    @startuml

    class GameObject{
        -items: GuardedArrayList<GameObject>;
        #update(timeDelta:long, tc : ThreadCommunicator)
    }

    class Layer{
        #update(timeDelta:long, tc : ThreadCommunicator)
    }

    class Map{
        #update(timeDelta:long, tc : ThreadCommunicator)
    }

    GameObject <|-- Layer

    GameObject <|-- Map

    Map "0..*" o-- GameObject : contains

    Map "0..*" o-- Layer : contains
    @enduml

     */


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

    public void removeItem(GameObject item){
        items.remove(item);
    }

    public GameObject(){
        super();
    }

    public void update(long timeDelta, ThreadCommunicator tc){
            for (GameObject go : items) {
                go.onUpdate(timeDelta, tc);
                go.update(timeDelta, tc);
            }
    }

    protected abstract void onUpdate(long timeDelta, ThreadCommunicator tce);

}
