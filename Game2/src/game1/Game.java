package game1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 3468184583742328389L;

	public static int WIDTH = 900, HEIGHT = 640;
	private Thread thread;
        private boolean running = false;
        
        private final Random r;
        
        private final Handler handler;
        private final HUD hud;
                
	public Game(){
                handler = new Handler();
                hud = new HUD();
                
                this.addKeyListener(new KeyInput(handler));//Nhap thong tin tu ban phim
                Window window = new Window(WIDTH,HEIGHT,"RPG",this);                
                r = new Random();
                handler.addObject(new Enemy(HEIGHT/2, HEIGHT/4, ID.Enemy,handler));
                handler.addObject(new Player(HEIGHT/2,HEIGHT/2,ID.Player, handler)); ///Create new object///                
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
        
        private void tick(){
            handler.tick();
            hud.tick();
        }
        
        private void render(){
            BufferStrategy bs= this.getBufferStrategy();
            if(bs==null){
                this.createBufferStrategy(3);
                return;
            }
            Graphics g = bs.getDrawGraphics();            
            g.setColor(Color.BLACK);
            g.fillRect(0,0, WIDTH, HEIGHT);
            g.setColor(Color.WHITE);
            g.fillRect(0,0, HEIGHT, HEIGHT);            
            
            handler.render(g);
            hud.render(g);
            
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
            Game game = new Game();
	}
}