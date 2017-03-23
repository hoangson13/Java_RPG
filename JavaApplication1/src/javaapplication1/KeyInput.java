//Su dung ban phim
package javaapplication1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

    private Handler handler;
    
    public KeyInput(Handler handler){
        this.handler=handler;
    }
    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        for(int i = 0 ; i <= handler.object.size() ; i++){
            Object temp = handler.object.get(i);
            if (temp.getID()==ID.Player){
                //event for player
 /*//Slow
                if ( key == KeyEvent.VK_UP) temp.setY(temp.getY()-2);
                if ( key == KeyEvent.VK_DOWN) temp.setY(temp.getY()+2);
                if ( key == KeyEvent.VK_RIGHT) temp.setX(temp.getX()+2);
                if ( key == KeyEvent.VK_LEFT) temp.setX(temp.getX()-2);
*/                
                if ( key == KeyEvent.VK_UP) temp.setvelY(-5);
                if ( key == KeyEvent.VK_DOWN) temp.setvelY(5);
                if ( key == KeyEvent.VK_RIGHT) temp.setvelX(5);
                if ( key == KeyEvent.VK_LEFT) temp.setvelX(-5);
            }
        }
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0 ; i <= handler.object.size() ; i++){
            Object temp = handler.object.get(i);
            if (temp.getID()==ID.Player){
                //event for player
                if ( key == KeyEvent.VK_UP) temp.setvelY(0);
                if ( key == KeyEvent.VK_DOWN) temp.setvelY(0);
                if ( key == KeyEvent.VK_RIGHT) temp.setvelX(0);
                if ( key == KeyEvent.VK_LEFT) temp.setvelX(0);
            }
        }
    }    
}
