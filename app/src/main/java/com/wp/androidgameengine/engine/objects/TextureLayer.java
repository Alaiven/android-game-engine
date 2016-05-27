package com.wp.androidgameengine.engine.objects;

/**
 * Created by Rafał on 27.05.2016.
 */
public class TextureLayer extends Texture {

    private float probability;

    public TextureLayer(float x, float y, float width, float height, int textureId, float probability) {
            super(x, y, width, height, textureId);
    }

    public float getProbability() {
        return probability;
    }

    public void setProbability(float probability) {
        this.probability = probability;
    }

}
