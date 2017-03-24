
package rpg;

import java.awt.Color;
import java.awt.Graphics;
import static rpg.RPG.HEIGHT;

public class Combat {
    
    private int hP;
    private int eP;
    
    public void tick(){
        hP=Player.getHP();
        eP=Enemy.getHP();
    }
    
    public void render(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, HEIGHT, HEIGHT);
 //Player health bar        
        g.setColor(Color.decode("#FF304F"));
        g.fillRect(650, 30, 200, 20);
        g.setColor(Color.white);
        g.drawRect(650, 30, 200, 20);
        g.setColor(Color.decode("#28C7FA"));
        g.fillRect(650, 30, (int)(eP*2), 20);
        g.setColor(Color.white);
        g.drawString("Enemy's HP " + eP, 650, 20);
//Enemy health bar
        g.setColor(Color.decode("#FF304F"));
        g.fillRect(650, 320, 200, 20);        
        g.setColor(Color.white);
        g.drawRect(650, 320, 200, 20);       
        g.setColor(Color.decode("#28C7FA"));
        g.fillRect(650, 320, hP*2, 20);           
        g.setColor(Color.white);
        g.drawString("Player's HP " + hP, 650, 310);
    }      
}
