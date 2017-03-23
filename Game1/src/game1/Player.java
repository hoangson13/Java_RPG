
package game1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends Object{
    private Random r;
    
    public Player(int x, int y, ID id) {
        super(x, y, id);
}

    @Override
    public void tick() { //Thay doi vi tri
        x+=velX;
        y+=velY;
        x = Game.clamp(0, Game.WIDTH - 24, x);
        y = Game.clamp(0, Game.HEIGHT - 48, y);
    }    

    @Override
    public void render(Graphics g) { //Render hinh
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 20, 20);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,20,20);
    }
    
}
