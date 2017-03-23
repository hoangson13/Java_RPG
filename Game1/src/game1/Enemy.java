
package game1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends Object{

    public Enemy(int x, int y, ID id) {
        super(x, y, id);
        velY=5;
        velX=5;
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;
        if(y<=0 || y >= Game.HEIGHT - 25) velY *=-1;
        if(x<=0 || x >= Game.WIDTH - 25) velX *=-1;        
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 10, 10);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,10,10);
    }
    
}