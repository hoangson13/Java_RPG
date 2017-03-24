
package rpg;

import java.awt.Color;
import java.awt.Graphics;
import static rpg.RPG.HEIGHT;
import static rpg.RPG.WIDTH;
import rpg.RPG.STATE;
import static rpg.RPG.rpgSTATE;

public class Map {
        
    public Map (){
        
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(0,0, WIDTH, HEIGHT);
    }
}
