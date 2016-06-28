package com.wp.androidgameengine.game.commands;

import com.wp.androidgameengine.engine.objects.Sound;
import com.wp.androidgameengine.engine.services.SoundService;
import com.wp.androidgameengine.game.components.Physics;

public class JumpCommand implements ICommand {

    private final Physics physics;
    private final Sound sound;

    public JumpCommand(Physics physics, Sound sound){
        this.physics = physics;
        this.sound = sound;
    }

    public void Execute(){
        physics.Jump();
        SoundService.getInstance().playSound(sound);
    }


}
