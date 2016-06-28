package com.wp.androidgameengine.engine.objects.components.animation;

import com.wp.androidgameengine.engine.objects.components.IComponent;
import com.wp.androidgameengine.engine.watchdog.GuardedObject;

public class AnimationFactory extends GuardedObject implements IAnimationFactory {

    @Override
    public IComponent create(AnimationFrame... frames) {
        if (frames.length > 1) {
            return new Animation(frames);
        } else {
            return new SteadyAnimation(frames[0].toTexture());
        }
    }

}
