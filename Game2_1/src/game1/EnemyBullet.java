
package game1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBullet extends Object{
    
    private final Random r;
    private Handler handler;
    private int count;
    
    public EnemyBullet(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        r = new Random();
        velY=r.nextInt(5)+3;
        velX=r.nextInt(5)-5;
    }

    @Override
    public void tick() {
        count++;
        x+=velX;
        y+=velY;
        
        //Chặn viền đạn k chạy ra ngoài
        if(y<=0 || y >= Game.HEIGHT - 25) velY *=-1; 
        if(x<=0 || x >= Game.HEIGHT - 25) velX *=-1;   
        
        handler.addObject(new Trail(x,y,ID.Trail,Color.red,handler,0.1f)); //Thêm viền trail cho đẹp       
        if(count==100) handler.removeObject(this); //Đạn biến mất sau 1 time
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillOval((int)x, (int)y, 10, 10);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,10,10);
    }
}