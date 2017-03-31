
package dev.game.entities.statics;

import dev.game.Handler;
import dev.game.gfx.Asset;
import dev.game.tiles.Tile;
import java.awt.Graphics;


public class Tree extends StaticEntity {

    public Tree(Handler handler, float x, float y) {
	super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
        bounds.x = 0;
        bounds.y = 40;
        bounds.height=40;
        bounds.width=40;                
    }

    @Override
    public void tick() {
		
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Asset.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    @Override
    public void die() {
    }
}
