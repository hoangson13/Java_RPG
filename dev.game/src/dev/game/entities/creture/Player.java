
package dev.game.entities.creture;

import dev.game.Handler;
import dev.game.gfx.Animation;
import dev.game.gfx.Asset;
import java.awt.Graphics;

public class Player extends Creature {
    
    Animation aniplayer;

    public Player(Handler handler, float x, float y) {
	super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
            //x,y là độ lệch từ góc trái nhất vào để tạo bound chỉ trọn trong nv chứ k ra ngoài
        bounds.x = 5;
        bounds.y = 10;
        bounds.height=25;
        bounds.width=35;
        
        aniplayer = new Animation(500, Asset.player);
    }

	@Override
    public void tick() {
        aniplayer.tick();
        
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }
	
    private void getInput(){
	xMove = 0;
	yMove = 0;		
	if(handler.getKeyManager().up) yMove = -speed;
        if(handler.getKeyManager().down) yMove = speed;
	if(handler.getKeyManager().left) xMove = -speed;
	if(handler.getKeyManager().right) xMove = speed;
    }

	@Override
    public void render(Graphics g) {
        g.drawImage(aniplayer.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
//            //vẽ khung của bound
//            g.setColor(Color.red);
//            g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()),bounds.width, bounds.height);
    }
}