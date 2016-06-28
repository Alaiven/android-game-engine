package com.wp.androidgameengine.engine.objects.components.animation;

import com.wp.androidgameengine.engine.objects.components.IComponent;
import com.wp.androidgameengine.engine.objects.components.IComposable;
import com.wp.androidgameengine.engine.watchdog.GuardedObject;

public class Animation extends GuardedObject implements IComponent {

    /*

    @startuml

    interface IAnimationFactory{
        #create(animationFrames:AnimationFrame[])
    }

    class AnimationFactory{
        +create(animationFrames:AnimationFrame[])
    }


    interface IComponent{
    }

    class Animation{
    }

    class SteadyAnimation{
    }




    IComponent <|-- Animation
    IComponent <|-- SteadyAnimation

    IAnimationFactory <|-- AnimationFactory

    IAnimationFactory ..> IComponent : use

    AnimationFactory ..> Animation : create

    AnimationFactory ..> SteadyAnimation : create

    @enduml


     */



    private IAnimable animable;

    private final AnimationFrame[] animationFrames;

    private final int frameCount;

    private int currentFrameIndex = 0;

    private AnimationFrame currentFrame;

    private int acturalDuration;

    Animation(AnimationFrame[] animationFrames){
        super();
        this.animationFrames = animationFrames;
        this.frameCount = animationFrames.length;

        currentFrame = animationFrames[0];

        resetDuration();
    }

    @Override
    public void perform(IComposable composable, long timeDelta) {
        animable = (IAnimable)composable;

        acturalDuration -= timeDelta;

        if(acturalDuration <= 0){
            currentFrame = animationFrames[++currentFrameIndex % frameCount];
            resetDuration();
        }

        animable.setCurrentAnimationFrame(currentFrame.toTexture());
    }

    @Override
    public IComponent duplicate() {

        AnimationFrame[] arr = new AnimationFrame[animationFrames.length];

        for (int i = 0; i < animationFrames.length; i++) {
            arr[i] = animationFrames[i].duplicate();
        }

        return new Animation(arr);
    }

    private void resetDuration(){
        acturalDuration = currentFrame.getDuration();
    }
}
