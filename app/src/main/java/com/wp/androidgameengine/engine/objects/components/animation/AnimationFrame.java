package com.wp.androidgameengine.engine.objects.components.animation;

import com.wp.androidgameengine.engine.objects.Texture;


public class AnimationFrame extends Texture {

    private final int duration;

    public AnimationFrame(int width, int height, int textureId, int duration) {
        super(0,0, width, height, textureId);

        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public Texture toTexture(){
        return this;
    }
}
