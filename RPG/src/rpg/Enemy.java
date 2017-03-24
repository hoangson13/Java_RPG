
package rpg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends Object{
    
    private int inital;
    private int count =0;
    private static int health = 50;
    Handler handler;
    
    public Enemy(int x, int y, ID id,Handler handler) {
        super(x, y, id);
        this.handler=handler;//muốn sử dụng handler tức là khi tạo obj thì fai khai báo
        inital = x; //Lưu vị trí ban đầu đển giới hạn di chuyển của enemy
        velX=4;
    }
    
    public static int getHP(){
        return health;
    } 
    
    private void collision(){       
        for(int i = 0 ; i < handler.object.size() ; i++){
            Object temp = handler.object.get(i);
            if (temp.getID()==ID.PlayerBullet){
                if (getBounds().intersects(temp.getBounds())){ //Chạm vào đạn
                    health -=2;
                    handler.removeObject(temp);
                }
            }
        }        
    }    

    @Override
    public void tick() {
        x+=velX;
        
        if(x <= inital-50 || x >= inital+50 ) velX *=-1; //lock vị trí cách 80px

        count++;//Đến tick đc 100 tick bắn lần
        
        if(count%20 == 0) handler.addObject(new EnemyBullet(x,y,ID.EnemyBullet,handler));  
        
        collision();
        
        if(health==0) handler.removeObject(this);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 20, 20);
        g.setColor(Color.WHITE);
        g.drawRect(x, y, 20, 20);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,20,20); //khung của enemy
    }
    
}
