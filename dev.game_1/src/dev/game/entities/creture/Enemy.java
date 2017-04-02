
package dev.game.entities.creture;

import dev.game.Handler;
import dev.game.entities.EntityManager;
import dev.game.gfx.Asset;
import java.awt.Graphics;

public class Enemy extends Creature{
    private Player player;    
    private float velX=2,velY=2;
    public Enemy(Player player,EntityManager entitymanager, Handler handler, float x, float y, int width, int height) {
        super(entitymanager, handler, x, y, width, height);
        this.player=player;
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;
        float diffX = x - player.getX() -10;
        float diffY = y - player.getY() -10;
        float distance = (float) Math.sqrt((x - player.getX())*(x - player.getX()) + (y - player.getY())*(y - player.getY()));
        velX = (float) ((-1.0/distance)*diffX);
        velY = (float) ((-1.0/distance)*diffY);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Asset.enemy, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    @Override
    public void die() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
