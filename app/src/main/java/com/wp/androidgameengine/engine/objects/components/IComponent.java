package com.wp.androidgameengine.engine.objects.components;

public interface IComponent{

    void perform(long timeDelta);

    void setComposable(IComposable composable);
}
