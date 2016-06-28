package com.wp.androidgameengine.engine.objects.components.movable;

import com.wp.androidgameengine.engine.objects.Vec2;
import com.wp.androidgameengine.engine.objects.components.IComposable;

public interface IMovable extends IComposable {
    void setPosition(Vec2 position);

    Vec2 getPosition();

    Vec2 getDimensions();
}
