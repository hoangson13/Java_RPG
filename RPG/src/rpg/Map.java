
package rpg;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static rpg.RPG.HEIGHT;
import static rpg.RPG.WIDTH;

public class Map {
    private Handler handler;
    private RPG rpg;
    public Map (Handler handler, RPG rpg){
        this.handler=handler;
        this.rpg=rpg;
    }
        
    public void tick(){
        
    }
    
    public int[][] readFile () throws FileNotFoundException{
        int[][] map = new int[32][32];
        Scanner s = new Scanner(new File("C:\\Users\\Mosquito\\Documents\\NetBeansProjects\\RPG\\src\\rpg\\map.txt"));
        for(int a = 0; a < 32; a++) {
            for(int b = 0; b < 32; b++) {      
                map[b][a]=s.nextInt();
            }          
        }
        return map;
    }
    
    public void render(Graphics g) throws FileNotFoundException{
        int[][] map =new int[32][32];
        map = readFile();
        g.setColor(Color.decode("#FF9A00"));
        g.fillRect(0,0, WIDTH, HEIGHT);
        for(int a = 0; a < 32; a++) {
            for(int b = 0; b < 32; b++) {      
                if(map[a][b] == 0) g.setColor(Color.RED); g.fillRect(a*20,b*20, 20, 20);
                if(map[a][b] == 1) g.setColor(Color.BLUE); g.fillRect(a*20,b*20, 20, 20);
                if(map[a][b] == 2) g.setColor(Color.YELLOW); g.fillRect(a*20,b*20, 20, 20);
                if(map[a][b] == 2) g.setColor(Color.CYAN); g.fillRect(a*20,b*20, 20, 20);
                if(map[a][b] == 4) handler.addObject(new Block(a*20, b*20, ID.Block, handler));
            }
        }        
    }
}
