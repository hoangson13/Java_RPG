
package rpg;

import rpg.RPG.STATE;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static rpg.RPG.HEIGHT;
import static rpg.RPG.WIDTH;

public class Menu extends MouseAdapter{
    private RPG rpg;
    private Handler handler;

    Menu(RPG rpg,Handler handler) {
        this.rpg=rpg;
        this.handler=handler;
    }
    
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        
        if(mouseOver(mx, my, 300, 150, 300, 64)){           
            rpg.rpgSTATE = STATE.Combat;
            handler.addObject(new Player(HEIGHT/2,HEIGHT/2,ID.Player, handler));         
            handler.addObject(new Enemy(HEIGHT/2,HEIGHT/2-200,ID.Enemy, handler));
        } else if (mouseOver(mx, my, 300, 250, 300, 64)){
            rpg.rpgSTATE = STATE.Map;                    
            handler.addObject(new Player(HEIGHT/2,HEIGHT/2,ID.Player, handler));
        }
    }
    
    public void mouseReleased(MouseEvent e){
        
    }
    
    private boolean mouseOver(int mx, int my, int x, int y, int w , int h){
        if(mx>x && mx<x+w){
            if(my>y && my<y+h){
                return true;
            }else return false;
        }else return false;
    }
    
    public void tick(){
        
    }
    
    public void render ( Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0, WIDTH, HEIGHT);        
        Font font = new Font("arial",1,50);
        g.setFont(font);
        g.setColor(Color.WHITE);        
        g.drawString("MENU", 370, 100);
        g.drawString("Combat", 370, 200);
        g.drawString("Map", 370, 300);
        g.drawRect(300, 150, 300, 64);
        g.drawRect(300, 250, 300, 64);
        g.drawRect(300, 350, 300, 64);        
    }        
}
