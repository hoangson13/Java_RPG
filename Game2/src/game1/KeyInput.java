//Su dung ban phim
package game1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

    private final Handler handler;
    long start = System.currentTimeMillis();//Đếm khi khởi tạo ct
    private boolean[] keyDown = new boolean[4]; 
    
    public KeyInput(Handler handler){
        this.handler=handler;
        //fix sticky key
        keyDown[0]=false;
        keyDown[1]=false;
        keyDown[2]=false;
        keyDown[3]=false;
    }
        
    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        long stop = System.currentTimeMillis(); //Dừng đếm giờ khi gõ phím 
        
        for(int i = 0 ; i < handler.object.size() ; i++){
            Object temp = handler.object.get(i);
            if (temp.getID()==ID.Player){
                //event for player
                if ( key == KeyEvent.VK_UP) {temp.setvelY(-5);keyDown[0]=true;}
                if ( key == KeyEvent.VK_DOWN) {temp.setvelY(5);keyDown[1]=true;}
                if ( key == KeyEvent.VK_RIGHT) {temp.setvelX(5);keyDown[2]=true;}
                if ( key == KeyEvent.VK_LEFT) {temp.setvelX(-5);keyDown[3]=true;}
                if ( key == KeyEvent.VK_SPACE && (stop-start)>200){      //Ngăn bắn liên tiếp tăng time để tăng độ chậm             
                    handler.addObject(new PlayerBullet(temp.getX(),temp.getY(),ID.PlayerBullet,handler));
                    start=System.currentTimeMillis();
                }
            }
        }
        if ( key == KeyEvent.VK_ESCAPE) System.exit(1);
    }
    @Override
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0 ; i < handler.object.size() ; i++){
            Object temp = handler.object.get(i);
            if (temp.getID()==ID.Player){
                //event for player
                if ( key == KeyEvent.VK_UP) keyDown[0]=false;
                if ( key == KeyEvent.VK_DOWN) keyDown[1]=false;
                if ( key == KeyEvent.VK_RIGHT) keyDown[2]=false;
                if ( key == KeyEvent.VK_LEFT) keyDown[3]=false;
                
                if (!keyDown[0] && !keyDown[1]) temp.setvelY(0);
                if (!keyDown[2] && !keyDown[3]) temp.setvelX(0);
            }
        }
    }    
}
