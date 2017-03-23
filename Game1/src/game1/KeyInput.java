//Su dung ban phim
package game1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

    private final Handler handler;
    
    public KeyInput(Handler handler){
        this.handler=handler;
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        for(int i = 0 ; i <= handler.object.size() ; i++){
            Object temp = handler.object.get(i);
            if (temp.getID()==ID.Player){
                //event for player
                if ( key == KeyEvent.VK_UP) temp.setvelY(-5);
                if ( key == KeyEvent.VK_DOWN) temp.setvelY(5);
                if ( key == KeyEvent.VK_RIGHT) temp.setvelX(5);
                if ( key == KeyEvent.VK_LEFT) temp.setvelX(-5);
            }
        }        
    }
    @Override
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
