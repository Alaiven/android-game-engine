package com.wp.androidgameengine.engine.objects.components.animation;

import com.wp.androidgameengine.engine.objects.Texture;
import com.wp.androidgameengine.engine.objects.components.IComponent;
import com.wp.androidgameengine.engine.objects.components.IComposable;
import com.wp.androidgameengine.engine.watchdog.GuardedObject;

class SteadyAnimation extends GuardedObject implements IComponent {

    private final Texture texture;
    private IAnimable animable;

    SteadyAnimation(Texture texture){
        super();

        this.texture = texture;
    }

    @Override
    public void perform(IComposable composable, long timeDelta) {
        animable = (IAnimable)composable;
        animable.setCurrentAnimationFrame(texture);
    }

    @Override
    public IComponent duplicate() {
        return new SteadyAnimation(new Texture(texture.getPosition().duplicate(), texture.getDimensions().duplicate(), texture.getTextureId()));
    }
}
