package com.wp.androidgameengine.game.commands;

/*

@startuml

interface ICommand{
    +Execute()
}

class JumpCommand{
    physics : Physics
    +Execute()
}

class Physics{
    Jump()
}

ICommand <|-- JumpCommand

JumpCommand -- Physics : uses

@enduml

 */



public interface ICommand {
    void Execute();
}
