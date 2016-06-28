package com.wp.androidgameengine.engine.objects.components;


public interface IComponent{

    void perform(IComposable composable, long timeDelta);

    IComponent duplicate();

}
