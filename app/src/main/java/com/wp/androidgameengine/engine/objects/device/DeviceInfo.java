package com.wp.androidgameengine.engine.objects.device;

public class DeviceInfo {

    private final int width;
    private final int height;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public DeviceInfo(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
