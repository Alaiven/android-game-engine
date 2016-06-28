package com.wp.androidgameengine.engine.objects.components.animation;

import com.wp.androidgameengine.engine.objects.components.IComponent;

public interface IAnimationFactory {
    IComponent create(AnimationFrame ... frames);
}
