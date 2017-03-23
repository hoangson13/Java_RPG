
package game1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class SmartEnemyBullet extends Object{
    private Handler handler;
    private int count;
    private Object player;
    
    public SmartEnemyBullet(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        
        for ( int i = 0 ; i < handler.object.size() ; i++){
            if( handler.object.get(i).getID() == ID.Player ) player = handler.object.get(i); //Cập nhập vị trí player
        }
 
    }

    @Override
    public void tick() {
        count++;
        x+=velX;
        y+=velY;
        
        float diffX = x - player.getX() -10;
        float diffY = y - player.getY() -10;
        float distance = (float) Math.sqrt((x - player.getX())*(x - player.getX()) + (y - player.getY())*(y - player.getY()));
        velX = (int)((-1.0/distance)*diffX);
        velY = (int)((-1.0/distance)*diffY);
        
        if(y<=0 || y >= Game.HEIGHT - 25) velY *=-1;
        if(x<=0 || x >= Game.HEIGHT - 25) velX *=-1;
        
        handler.addObject(new Trail(x,y,ID.Trail,Color.red,handler,0.1f)); //Thêm viền trail cho đẹp       
        if(count==1000) handler.removeObject(this); //Đạn biến mất sau 1 time
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval((int)x, (int)y, 10, 10);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,10,10);
    }
}