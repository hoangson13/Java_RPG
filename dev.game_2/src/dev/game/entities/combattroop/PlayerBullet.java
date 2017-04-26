package dev.game.entities.combattroop;

import dev.game.Handler;
import dev.game.entities.EntityManager;
import dev.game.entities.ID;
import java.awt.Color;
import java.awt.Graphics;

public class PlayerBullet extends CombatTroop {

    private EntityManager entitymanager;

    public PlayerBullet(EntityManager entitymanager, Handler handler, float x, float y, ID id,int atk) {
        super(entitymanager, handler, x, y, id);
        this.entitymanager = entitymanager;
        height = 10;
        width = 10;
        this.atk=atk;
    }

    @Override
    public void tick() {
        y -= 5;
        if (y <= 0) {
            active = false;
        }
        
        entitymanager.addEntity(new Trail(entitymanager, handler, x, y, ID.Trail, Color.blue, 0.1f));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval((int) x, (int) y, width, height);
    }

    @Override
    public void die() {

    }

}
