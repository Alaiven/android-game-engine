package com.wp.androidgameengine.engine.objects.map;

import com.wp.androidgameengine.engine.objects.Texture;
import com.wp.androidgameengine.engine.objects.Vec2;

public class MapTexture extends Texture {

    private float probability;

    public MapTexture(Vec2 dimensions, int textureId, float probability) {
            super(new Vec2(0, 0), dimensions, textureId);
        this.probability = probability;
    }

    private MapTexture(Vec2 position, Vec2 dimenstions, int textureId, float probability) {
        super(position, dimenstions, textureId);
        this.probability = probability;
    }

    float getProbability() {
        return probability;
    }

    public void setProbability(float probability) {
        this.probability = probability;
    }

    public MapTexture clone(Vec2 newPostion){
        return new MapTexture(newPostion, getDimensions(), getTextureId(), getProbability());
    }

}
