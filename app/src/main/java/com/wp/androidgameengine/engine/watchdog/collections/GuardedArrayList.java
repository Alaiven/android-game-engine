package com.wp.androidgameengine.engine.watchdog.collections;

import com.wp.androidgameengine.engine.watchdog.GuardedObject;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by maciek on 18.04.16.
 */
public class GuardedArrayList<E> extends ArrayList<E> {

    public GuardedArrayList(){
        super();
        GuardedObject.staticGuard(this);
    }

    public GuardedArrayList(Collection<? extends E> collection){
        super(collection);
        GuardedObject.staticGuard(this);
    }
}
