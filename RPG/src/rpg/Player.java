package rpg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends Object{
    
    private static int health = 100;
    private final Handler handler;
    
    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
}
  
    private void collision(){       
        for(int i = 0 ; i < handler.object.size() ; i++){
            Object temp = handler.object.get(i);
            if (temp.getID()==ID.EnemyBullet){
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
        x = RPG.clamp(0, RPG.HEIGHT - 22, x);
        y = RPG.clamp(0, RPG.HEIGHT - 48, y);
        collision();
    }
    
    @Override
    public void render(Graphics g) { //Render hinh
        g.setColor(Color.decode("#3EC1D3"));
        g.fillRect(x, y, 20, 20);
        g.setColor(Color.WHITE);
        g.drawRect(x, y, 20, 20);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,20,20);
    }
}
