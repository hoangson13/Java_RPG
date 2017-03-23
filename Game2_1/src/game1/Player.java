package game1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends Object{
    
    private static int health = 100;
    private Random r;
    private final Handler handler;
    
    public Player(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
}
    
    private void collision(){       
        for(int i = 0 ; i < handler.object.size() ; i++){
            Object temp = handler.object.get(i);
            if (temp.getID()==ID.EnemyBullet || temp.getID()==ID.SmartEnemyBullet){
                if (getBounds().intersects(temp.getBounds())){ //Chạm vào đạn
                    health -=2;
                    handler.removeObject(temp);
                }
            }else if (temp.getID()==ID.Enemy){
                    if (getBounds().intersects(temp.getBounds())){ //Chạm vào quái
                    health -=4;
                }
            }
        }        
    }

    public static int getHP(){
        return health;
    }
    
    @Override
    public void tick() { //Thay doi vi tri
        x+=velX;
        y+=velY;
        x = Game.clamp(0, Game.WIDTH - 24, x);
        y = Game.clamp(0, Game.HEIGHT - 48, y);
        collision();
    }
    
    @Override
    public void render(Graphics g) { //Render hinh
        g.setColor(Color.GREEN);
        g.fillRect((int)x, (int)y, 20, 20);
        g.setColor(Color.WHITE);
        g.drawRect((int)x, (int)y, 20, 20);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,20,20);
    }
    
}
