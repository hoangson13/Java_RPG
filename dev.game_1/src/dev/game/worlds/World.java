
package dev.game.worlds;

import dev.game.Handler;
import dev.game.entities.EntityManager;
import dev.game.entities.creture.Player;
import dev.game.entities.statics.Tree;
import dev.game.tiles.Tile;
import dev.game.utils.Utils;
import java.awt.Graphics;

public class World {

    private Handler handler;    
    private int width, height;
    private int[][] tiles;
    private EntityManager entitymanager;
    public int spawnX;
    public int spawnY;
	
    public World(Handler handler, String path,EntityManager entitymanager){
        this.handler = handler;
        this.entitymanager=entitymanager;
        loadWorld(path);
        //entitymanager.addEntity(new Player(handler, spawnX , spawnY));
    }
	
    public void tick(){
	entitymanager.tick();
    }
	
    public void render(Graphics g){
	int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
	int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
	int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
	int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
	for(int y = yStart;y < yEnd;y++){
            for(int x = xStart;x < xEnd;x++){
		getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
		(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
            }
	}
        entitymanager.render(g);
    }
	
    public Tile getTile(int x, int y){
	Tile t = Tile.tiles[tiles[x][y]];
	if(t == null) return Tile.dirtTile;
	return t;
    }
	
    private void loadWorld(String path){
	String file = Utils.loadFileAsString(path); //Đọc file
	String[] tokens = file.split("\\s+"); //Tách số theo space
                
	width = Utils.parseInt(tokens[0]);//đọc số thứ 1
	height = Utils.parseInt(tokens[1]);//đọc số thứ 2
                //vị trí bắt đầu cho player
	spawnX = Utils.parseInt(tokens[2]);//đọc số thứ 3 
	spawnY = Utils.parseInt(tokens[3]);//đọc số thứ 4
		
                //Đọc map
	tiles = new int[width][height];
	for(int y = 0;y < height;y++){
            for(int x = 0;x < width;x++){
		tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]); //chuyển từ array 1 chiều thành 2 chiều
		}
            }            
	}
    
    public EntityManager getEntityManager() {
	return entitymanager;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

}
