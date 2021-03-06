///Main code///
package game1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 3468184583742328389L;

	public static int WIDTH = 640, HEIGHT = WIDTH/12*9;
	private Thread thread;
        private boolean running = false;
        
        private Random r;
        
        private final Handler handler;
        private HUD hud;
                
	public Game(){
                handler = new Handler();
                hud = new HUD();
                
                this.addKeyListener(new KeyInput(handler));//Nhap thong tin tu ban phim
                new Window(WIDTH,HEIGHT,"RPG",this);
                handler.addObject(new Player(WIDTH/2,HEIGHT/2,ID.Player)); ///Create new object///
                
                r = new Random();
                for ( int i =0; i<=5;i++) handler.addObject(new Enemy(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.Enemy));
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
        }catch(Exception e){
            e.printStackTrace();
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
            
            handler.render(g);
            hud.render(g);
            
            g.dispose();
            bs.show();
        }    
        
        public static int clamp(int min, int max, int var) { //Gioi han khung hinh
            if ( var <= min ) return var = min;
            else if ( var >= max) return var = max;
            else return var;
        }
	
	public static void main(String[] args) {
            Game game = new Game();
	}
}