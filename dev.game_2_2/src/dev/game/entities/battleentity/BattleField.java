package dev.game.entities.battleentity;

import dev.game.Handler;
import dev.game.entities.Entity;
import dev.game.entities.EntityManager;
import dev.game.entities.ID;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class BattleField extends Entity {

    private int count = 0;
    private Random r;
    EntityManager entitymanager;

    public BattleField(EntityManager entitymanager, Handler handler, float x, float y, int width, int height, ID id) {
        super(handler, x, y, width, height, id);
        this.entitymanager = entitymanager;
        r = new Random();
    }

    @Override
    public void tick() {
        count++;
        if (count % 150 == 0) {
            entitymanager.addEntity(new Coin(handler, r.nextFloat() * handler.getHeight(), r.nextFloat() * handler.getHeight(), ID.Coin));
        }
        if (count % 350 == 0) {
            entitymanager.addEntity(new Posion(handler, r.nextFloat() * (handler.getHeight() - 20), r.nextFloat() * (handler.getHeight() - 20), ID.Coin));
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.decode("#41245C"));
        g.fillRect(0, 0, 900, 640);
        g.setColor(Color.decode("#FFE180"));
        g.fillRect(640, 0, 260, 640);
    }

    @Override
    public void die() {
    }
}
