
package dev.game.entities.statics;

import dev.game.Handler;
import dev.game.entities.EntityManager;
import dev.game.gfx.Asset;
import dev.game.tiles.Tile;
import java.awt.Graphics;


public class Tree extends StaticEntity {
    private EntityManager entitymanager;
    public Tree(EntityManager entitymanager, Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
        this.entitymanager=entitymanager;
    }

    @Override
    public void tick() {
	if(checkEntityCollisions(0f, 0f)!=null){      
            active=false;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Asset.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    @Override
    public void die() {
    }
}
