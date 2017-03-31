
package dev.game.entities.combatentity;

import dev.game.Handler;
import dev.game.entities.Entity;
import dev.game.entities.EntityManager;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class EnemyBullet extends Entity{
    private EntityManager entitymanager;
    private int count=0;
    private int Xmove,Ymove;
    private Random r;
    public EnemyBullet(EntityManager entitymanager,Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        r=new Random();
        this.entitymanager=entitymanager;
        sethealth(2);
        setatk(2);
        Ymove=r.nextInt(5)+3;
        Xmove=(r.nextInt(10)-5);     
    }

    @Override
    public void tick() {
        count++;
        x+=Xmove;
        y+=Ymove;
        if(y<=0 || y >= handler.getHeight()-5) Ymove *=-1;
        if(x<=0 || x >= handler.getHeight()-5) Xmove *=-1;             
        if(count==100) entitymanager.removeEntity(this); //Đạn biến mất sau 1 time
        Entity e = checkEntityCollisions(0f, 0f);
        if(e!=null) hurt(e.getatk());
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillOval((int)x, (int)y, width, height);        
    }  

    @Override
    public void die() {
    }
}

