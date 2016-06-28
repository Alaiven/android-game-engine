package com.wp.androidgameengine.engine.objects.components.physics;

import com.wp.androidgameengine.engine.objects.Position;
import com.wp.androidgameengine.engine.objects.components.IComposable;



public interface IMovable extends IComposable {
    void setCurrentPosition(Position p);

    Position getPosition();

    int getHeight();
}
