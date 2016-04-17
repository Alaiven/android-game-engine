package com.wp.androidgameengine.engine.watchdog.collections;

import com.wp.androidgameengine.engine.watchdog.GuardedObject;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by maciek on 18.04.16.
 */
public class GuardedLinkedList<E> extends LinkedList<E> {

    public GuardedLinkedList() {
        super();
        GuardedObject.staticInitGuard(this);
    }

    public GuardedLinkedList(Collection<? extends E> collection){
        super(collection);
        GuardedObject.staticInitGuard(this);
    }

    protected void finalize() throws Throwable{
        super.finalize();
        GuardedObject.staticExitGuard(this);
    }
}
