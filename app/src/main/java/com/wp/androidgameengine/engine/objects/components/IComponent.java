package com.wp.androidgameengine.engine.objects.components;

import com.wp.androidgameengine.engine.events.Events;

public interface IComponent{

    void perform(long timeDelta, Events e);

    void setComposable(IComposable composable);
}
