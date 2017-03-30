
package dev.game.state;

import dev.game.Handler;
import dev.game.entities.creture.Player;
import dev.game.worlds.World;
import java.awt.Graphics;


public class GameState extends State {
        private World world;
    
	public GameState(Handler handler){
            super(handler);
            world = new World(handler, "res/worlds/world1.txt");
            handler.setWorld(world);
        }
	
	@Override
	public void tick() {
            world.tick();
	}

        @Override
	public void render(Graphics g) {
            world.render(g);
        }
}
