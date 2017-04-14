package dev.game.entities.combat;

import dev.game.Handler;
import dev.game.entities.Entity;
import dev.game.entities.EntityManager;
import dev.game.entities.ID;

public abstract class CombatEntity extends Entity {

    public static final int DEFAULT_HEALTH = 10;
    public static final int DEFAULT_ATTACK = 1;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 40, DEFAULT_CREATURE_HEIGHT = 40;

    protected float speed = DEFAULT_SPEED;
    protected int health = DEFAULT_HEALTH;
    protected int atk = DEFAULT_ATTACK;
    protected float xMove, yMove;
    EntityManager entitymanager;

    public CombatEntity(EntityManager entitymanager, Handler handler, float x, float y,ID id) {
        super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT,id);
        this.entitymanager = entitymanager;
    }

    public static int clamp(int min, int max, int var) {
        if (var <= min) {
            return var = min;
        } else if (var >= max) {
            return var = max;
        } else {
            return var;
        }
    }

    public void hurt(int dam) {
        health -= dam;
        if (health <= 0) {
            active = false;
            die();
        }
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
