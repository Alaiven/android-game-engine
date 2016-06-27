package com.wp.androidgameengine.engine.objects.components.animation;


import com.wp.androidgameengine.engine.objects.Texture;
import com.wp.androidgameengine.engine.objects.components.IComposable;

public interface IAnimable extends IComposable {

    void setCurrentAnimationFrame(Texture texture);

}
