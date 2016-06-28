package com.wp.androidgameengine.engine.watchdog.collections;

import com.wp.androidgameengine.engine.watchdog.GuardedObject;

import java.util.ArrayList;
import java.util.Collection;

public class GuardedArrayList<E> extends ArrayList<E> {

    public GuardedArrayList(){
        super();
        GuardedObject.staticInitGuard(this);
    }

    public GuardedArrayList(Collection<? extends E> collection){
        super(collection);
        GuardedObject.staticInitGuard(this);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        GuardedObject.staticExitGuard(this);
    }
}
