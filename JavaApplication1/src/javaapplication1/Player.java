
package javaapplication1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends Object{
    private Random r;
    public Player(int x, int y, ID id) {
        super(x, y, id);
/*        
        r = new Random();
        velX=r.nextInt(3)+1;
        velY=r.nextInt(3)+1;
*/
}


    public void tick() { //Thay doi vi tri
        x+=velX;
        y+=velY;
    }

    public void render(Graphics g) { //Render hinh
        if (id==ID.Player) g.setColor(Color.WHITE);
        else g.setColor(Color.RED);
        g.fillRect(x, y, 20, 20);
    }
    
}
