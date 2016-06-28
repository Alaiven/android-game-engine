package com.wp.androidgameengine.engine.objects.components.animation;

import com.wp.androidgameengine.engine.events.Events;
import com.wp.androidgameengine.engine.objects.components.IComponent;
import com.wp.androidgameengine.engine.objects.components.IComposable;
import com.wp.androidgameengine.engine.watchdog.GuardedObject;

public class Animation extends GuardedObject implements IComponent {

    private IAnimable animable;

    private final AnimationFrame[] animationFrames;

    private final int frameCount;

    private int currentFrameIndex = 0;

    private AnimationFrame currentFrame;

    private int acturalDuration;

    public Animation(AnimationFrame[] animationFrames){
        super();
        this.animationFrames = animationFrames;
        this.frameCount = animationFrames.length;

        currentFrame = animationFrames[0];

        resetDuration();
    }


    @Override
    public void perform(long timeDelta, Events e) {
        acturalDuration -= timeDelta;

        if(acturalDuration <= 0){
            currentFrame = animationFrames[++currentFrameIndex % frameCount];
            resetDuration();
        }

        animable.setCurrentAnimationFrame(currentFrame.toTexture());
    }

    @Override
    public void setComposable(IComposable composable) {
        animable = (IAnimable)composable;
    }

    private void resetDuration(){
        acturalDuration = currentFrame.getDuration();
    }
}
