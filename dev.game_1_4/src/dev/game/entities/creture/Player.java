package dev.game.entities.creture;

import dev.game.Handler;
import dev.game.entities.EntityManager;
import dev.game.entities.ID;
import dev.game.gfx.Animation;
import dev.game.gfx.Asset;
import java.awt.Graphics;

public class Player extends Creature {

    Animation aniplayer;
    EntityManager entitymanager;

    public Player(EntityManager entitymanager, Handler handler, float x, float y,ID id) {
        super(entitymanager, handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT,id);
        this.entitymanager = entitymanager;
        //x,y là độ lệch từ góc trái nhất vào để tạo bound chỉ trọn trong nv chứ k ra ngoài
        bounds.x = 5;
        bounds.y = 10;
        bounds.height = 25;
        bounds.width = 35;

        aniplayer = new Animation(500, Asset.player);
    }

    @Override
    public void tick() {
        aniplayer.tick();
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;
        if (handler.getKeyManager().up) {
            yMove = -speed;
        }
        if (handler.getKeyManager().down) {
            yMove = speed;
        }
        if (handler.getKeyManager().left) {
            xMove = -speed;
        }
        if (handler.getKeyManager().right) {
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(aniplayer.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    @Override
    public void die() {
    }
}
