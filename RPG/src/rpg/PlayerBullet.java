
package rpg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import static rpg.RPG.HEIGHT;

public class PlayerBullet extends Object{
    private Handler handler;
    public PlayerBullet(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        velY=-5;
    }

    @Override
    public void tick() {
        y+=velY;
        if(y >= HEIGHT - 25) handler.removeObject(this);       
        handler.addObject(new Trail(x,y,ID.Trail,Color.blue,handler,0.1f));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(x, y, 10, 10);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,10,10);
    }
}