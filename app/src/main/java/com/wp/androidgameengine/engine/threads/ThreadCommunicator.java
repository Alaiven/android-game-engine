package com.wp.androidgameengine.engine.threads;

import com.wp.androidgameengine.engine.Texture;
import com.wp.androidgameengine.engine.watchdog.GuardedObject;
import com.wp.androidgameengine.engine.watchdog.collections.GuardedLinkedList;

import java.util.Queue;

/**
 * Created by maciek on 20.04.16.
 *
 * This class is responsible for passing rendering objects from game thread to rendering thread.
 * It aims to implement producer / consumer behaviour, but in a "back buffer" way, so it doesn't block any queue.
 *
 */
public class ThreadCommunicator extends GuardedObject {


    private Queue<Texture> producerQueue;
    private Queue<Texture> consumerQueue;

    private Boolean swappingFlag = true;


    public ThreadCommunicator(){
        consumerQueue = new GuardedLinkedList<>();
        producerQueue = new GuardedLinkedList<>();
    }

    public void Produce(Texture obj){
        producerQueue.add(obj);
    }

    public Texture Consume(){
        return consumerQueue.poll();
    }

    public Boolean IsConsumeEmpty(){
        return consumerQueue.isEmpty();
    }

    public Boolean IsFrameConsumed(){
        return swappingFlag;
    }

    public void setSwappingFlag(Boolean swappingFlag) {
        this.swappingFlag = swappingFlag;
    }

    public synchronized void SwapBuffers(){
        Queue<Texture> auxQueue = consumerQueue;
        consumerQueue = producerQueue;
        producerQueue = auxQueue;

        swappingFlag = true;
    }

}
