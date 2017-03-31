
package dev.game.entities.combatentity;

import dev.game.Handler;
import dev.game.entities.Entity;
import dev.game.entities.EntityManager;
import java.awt.Color;
import java.awt.Graphics;

public class CombatPlayer extends Entity{
    private int xMove,yMove,speed=3;
    private EntityManager entitymanager;
    private int count=0;
    public CombatPlayer(EntityManager entitymanager,Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        this.entitymanager=entitymanager;
        sethealth(100);
        setatk(1);
    }
    
    private void getInput(){
	xMove = 0;
	yMove = 0;
	if(handler.getKeyManager().up) yMove = -speed;
        if(handler.getKeyManager().down) yMove = speed;
	if(handler.getKeyManager().left) xMove = -speed;
	if(handler.getKeyManager().right) xMove = speed;
        if(handler.getKeyManager().space && count%20==0) entitymanager.addEntity(new PlayerBullet(entitymanager, handler, x+15, y-10, 10, 10));
    }
    
    @Override
    public void tick() {
        getInput();
        count++;
        x+=xMove;
        y+=yMove;
        Entity e = checkEntityCollisions(0f, 0f);
        if(e!=null) hurt(e.getatk());
    }
                
    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((int)x, (int)y,width,height);
        g.setColor(Color.WHITE);
        g.drawRect((int)x, (int)y,width,height);
 //Player health bar        
        g.setColor(Color.decode("#FF304F"));
        g.fillRect(650, 30, 200, 20);
        g.setColor(Color.white);
        g.drawRect(650, 30, 200, 20);
        g.setColor(Color.decode("#28C7FA"));
        g.fillRect(650, 30, gethealth()*2, 20);
        g.setColor(Color.white);
        g.drawString("Player's HP :" + gethealth(), 650, 20);        
    }   

    @Override
    public void die() {

    }
}
