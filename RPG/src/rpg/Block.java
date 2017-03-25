
package rpg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends Object{
    private Handler handler;
    public Block(int x, int y, ID id,Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        /*
        for(int i = 0 ; i < handler.object.size() ; i++){
            Object temp = handler.object.get(i);
            if (temp.getID()==ID.Player){                
                if (getBounds().intersects(temp.getBounds())){ //Chặn dưới
                    if(temp.getX()<=x+20) temp.setX(x);
                    if(temp.getX()+20>=x) temp.setX(x+20);
                    if(temp.getY()<=y+20) temp.setY(y);                    
                    if(temp.getY()+20<=y) temp.setY(y+20);
                }                
            }
        }       
        */
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.PINK);
        g.fillRect(x, y, 20, 20);
        g.setColor(Color.WHITE);
        g.drawRect(x, y, 20, 20);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,20,20);
    }
}
