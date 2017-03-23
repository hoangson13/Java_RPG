package game1;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
    
    public static int health = 100;
    
    public void tick(){
        Game.clamp(0, 100, health);
    }
    
    public void render(Graphics g){
        g.setColor(Color.decode("#FF304F"));
        g.fillRect(20, 20, 200, 20);
        g.setColor(Color.white);
        g.drawRect(20, 20, 200, 20);
        g.setColor(Color.decode("#28C7FA"));
        g.fillRect(20, 20, health*2, 20);
    }
}
