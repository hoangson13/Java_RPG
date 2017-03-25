
package rpg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import static rpg.RPG.HEIGHT;

public class EnemyBullet extends Object{
    
    private final Random r;
    private Handler handler;
    private int count;
    public EnemyBullet(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        r = new Random();
        velY=r.nextInt(5)+3;
        velX=(r.nextInt(10)-5);
    }

    @Override
    public void tick() {
        count++;
        x+=velX;
        y+=velY;
        if(y<=0 || y >= HEIGHT - 25) velY *=-1;
        if(x<=0 || x >= HEIGHT - 25) velX *=-1;        
        handler.addObject(new Trail(x,y,ID.Trail,Color.decode("#FF9898"),handler,0.1f)); //Thêm viền trail cho đẹp       
        if(count==100) handler.removeObject(this); //Đạn biến mất sau 1 time
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.decode("#470031"));
        g.fillOval(x, y, 10, 10);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,10,10);
    }
}