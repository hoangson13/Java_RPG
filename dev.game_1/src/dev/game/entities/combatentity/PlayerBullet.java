
package dev.game.entities.combatentity;

import dev.game.Handler;
import dev.game.entities.Entity;
import dev.game.entities.EntityManager;
import java.awt.Color;
import java.awt.Graphics;

public class PlayerBullet extends Entity{
    private EntityManager entitymanager;
    public PlayerBullet(EntityManager entitymanager,Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        this.entitymanager=entitymanager;
        sethealth(2);
        setatk(2);
    }

    @Override
    public void tick() {
        y-=5;
        if ( y <=0 ) entitymanager.removeEntity(this);
        Entity e = checkEntityCollisions(0f, 0f);
        if(e!=null) hurt(e.getatk());
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval((int)x, (int)y, width, height);        
    }  

    @Override
    public void die() {

    }
}