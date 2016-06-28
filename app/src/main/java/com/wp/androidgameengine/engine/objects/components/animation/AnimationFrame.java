package com.wp.androidgameengine.engine.objects.components.animation;

import com.wp.androidgameengine.engine.objects.Texture;
import com.wp.androidgameengine.engine.objects.Vec2;


public class AnimationFrame extends Texture {

    private final int duration;

    public AnimationFrame(Vec2 dimensions, int textureId, int duration) {
        super(new Vec2(0, 0), dimensions, textureId);

        this.duration = duration;
    }

    int getDuration() {
        return duration;
    }

    Texture toTexture(){
        return this;
    }

    AnimationFrame duplicate(){
        return new AnimationFrame(getDimensions().duplicate(), getTextureId(), getDuration());
    }
}
