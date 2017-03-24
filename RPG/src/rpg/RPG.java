
package rpg;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class RPG extends Canvas implements Runnable {
    
	private static final long serialVersionUID = 3468184583742328389L;

	public static int WIDTH = 900, HEIGHT = 640;
	private Thread thread;
        private boolean running = false;
         private final Menu menu;
        private final Combat combat;
        private final Map map;
        private final Handler handler;
        
        public enum STATE{
            Menu,
            Combat,
            Map;
        }
        
        public static STATE rpgSTATE = STATE.Menu;  
        
        public RPG (){            
            handler = new Handler();            
            menu = new Menu(this,handler);
            combat = new Combat();
            map = new Map();
            
            this.addMouseListener(menu);
            this.addKeyListener(new KeyInput(handler));//Nhap thong tin tu ban phim 
            
            Window window = new Window(WIDTH,HEIGHT,"RPG",this);  
           
        }
        
	public synchronized void start(){
            thread = new Thread(this);
            thread.start();  
            running= true;
	}
        
	public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(InterruptedException e){
            }
        }  
//////////////////GAME LOOP//////////////        
        @Override
	public void run(){
            this.requestFocus();
            long lastTime = System.nanoTime();
            double amountOfTicks = 60.0;
            double ns = 1000000000 / amountOfTicks;
            double delta = 0;
            long timer = System.currentTimeMillis();
            int frames = 0;
            while(running){
                long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;
                while (delta>= 1){
                tick();
                delta--;
                }
                if (running) render();
                frames ++;
                if(System.currentTimeMillis()-timer >1000){
                    timer += 1000;
                    System.out.println("FPS : "+frames);
                    frames=0;
                }
            }
            stop();
	}
        
    public void tick (){
        
        handler.tick();
        
        if (rpgSTATE == STATE.Combat){
            combat.tick();
        }else if ( rpgSTATE == STATE.Menu){
            menu.tick();
        }else if ( rpgSTATE == STATE.Map){
            map.tick();
        }        
    }
        
    public void render(){
        BufferStrategy bs= this.getBufferStrategy();
        if(bs==null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();        
                
        if (rpgSTATE == STATE.Combat){
            combat.render(g);
        }else if ( rpgSTATE == STATE.Menu){
            menu.render(g);
        }else if ( rpgSTATE == STATE.Map){
            map.render(g);
        }
        
        handler.render(g);
        
        g.dispose();
        bs.show();
    }
//Gioi han khung hinh        
        public static int clamp(int min, int max, int var) { 
            if ( var <= min ) return var = min;
            else if ( var >= max) return var = max;
            else return var;
        }    
        
    public static void main(String[] args) {
            RPG rpg = new RPG();        
    }    
}