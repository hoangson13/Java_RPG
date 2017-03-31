
package dev.game.entities.combatentity;

import dev.game.Handler;
import dev.game.entities.Entity;
import dev.game.entities.EntityManager;
import java.awt.Color;
import java.awt.Graphics;

public class CombatEnemy extends Entity{
    private float inital;
    private int speed=3;
    private int count=0;
    private EntityManager entitymanager;

    public CombatEnemy(EntityManager entitymanager,Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        this.entitymanager=entitymanager;
        inital = x;
        sethealth(100);
        setatk(2);
    }

    @Override
    public void tick() {
        x+=speed;        
        if(x <= inital-50 || x >= inital+50 ) speed *=-1; //lock vị trí cách 80px   
        count++;
        if(count%10==0) entitymanager.addEntity(new EnemyBullet(entitymanager, handler, x+width/2, y+height, 10, 10));
        Entity e = checkEntityCollisions(0f, 0f);
        if(e!=null) hurt(e.getatk());
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y,width,height);
        g.setColor(Color.WHITE);
        g.drawRect((int)x, (int)y,width,height);
//Enemy health bar
        g.setColor(Color.decode("#FF304F"));
        g.fillRect(650, 320, 200, 20);        
        g.setColor(Color.white);
        g.drawRect(650, 320, 200, 20);       
        g.setColor(Color.decode("#28C7FA"));
        g.fillRect(650, 320, gethealth()*2, 20);           
        g.setColor(Color.white);
        g.drawString("Enemy's HP :" + gethealth(), 650, 310);        
    }

    @Override
    public void die() {
        entitymanager.removeEntity(this);
    }
}
