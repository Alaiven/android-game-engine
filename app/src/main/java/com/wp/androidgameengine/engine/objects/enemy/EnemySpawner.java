package com.wp.androidgameengine.engine.objects.enemy;

import com.wp.androidgameengine.engine.objects.GameObject;
import com.wp.androidgameengine.engine.objects.Vec2;
import com.wp.androidgameengine.engine.objects.device.DeviceInfo;
import com.wp.androidgameengine.engine.threads.ThreadCommunicator;
import com.wp.androidgameengine.engine.watchdog.collections.GuardedLinkedList;

import java.util.Queue;
import java.util.Random;

public class EnemySpawner extends GameObject {

    {
        randomGenerator = new Random();
        enemyQueue = new GuardedLinkedList<>();
    }

    private final Queue<Enemy> enemyQueue;
    private final Random randomGenerator;
    private final DeviceInfo deviceInfo;
    private final Vec2 position;
    private final Enemy[] enemies;
    private final int maxEnemiesOnScreen;
    private final int minTimeGap;
    private int currentDuration;

    public EnemySpawner(DeviceInfo di, Vec2 position, Enemy[] enemies, int maxEnemiesOnScreen, int minTimeGap) {
        super();

        deviceInfo = di;
        this.position = position;
        this.enemies = enemies;
        this.maxEnemiesOnScreen = maxEnemiesOnScreen;
        this.minTimeGap = minTimeGap;

        this.currentDuration = minTimeGap;
    }

    Enemy firstEnemy;
    Enemy nextEnemy;

    private void spawnEnemy(float timeDelta, ThreadCommunicator tc) {
        currentDuration -= timeDelta;

        if(!enemyQueue.isEmpty()){
            firstEnemy = enemyQueue.peek();

            if(isOffScreen(firstEnemy)){
                removeItem(enemyQueue.poll());
            }
        }

        if(currentDuration <= 0 && enemyQueue.size() < maxEnemiesOnScreen){
            nextEnemy = getNextEnemy().clone(position);

            if(nextEnemy.getSpawnProbability() > randomGenerator.nextFloat()) {
                enemyQueue.offer(nextEnemy);
                addItem(nextEnemy);
            }

            currentDuration = minTimeGap;
        }
    }

    private float acc;
    private float random;

    //TODO PRZEROBIC NA O(1)
    private Enemy getNextEnemy(){

        Enemy resultEnemy = null;

        acc = 0f;

        random = randomGenerator.nextFloat();

        for (Enemy en: enemies) {
            acc += en.getOrderProbability();
            if(acc >= random){
                resultEnemy = en;
                break;
            }
        }

        return resultEnemy;
    }

    private Vec2 isOffPosition;

    private boolean isOffScreen(Enemy e){
        isOffPosition = e.getPosition();

        return  isOffPosition.getY() > deviceInfo.getHeight() ||
                isOffPosition.getY() + e.getDimensions().getY() < 0 || isOffPosition.getX() + e.getDimensions().getX() < 0;
    }

    @Override
    protected void onUpdate(long timeDelta, ThreadCommunicator tc) {
        spawnEnemy(timeDelta, tc);
    }

}
