package dev.game.entities.battleentity;

import dev.game.Handler;
import dev.game.entities.Entity;
import dev.game.entities.EntityManager;
import dev.game.entities.ID;
import dev.game.entities.combattroop.EnemyTroop;
import dev.game.entities.combattroop.PlayerTroop;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class BattleField extends Entity {

    public static final int DEFAULT_WIDTH = 900, DEFAULT_HEIGHT = 640;
    public static final int DEFAULT_X = 0, DEFAULT_Y = 0;
    private int count = 0;
    private Random r;
    EntityManager entitymanager;

    public BattleField(EntityManager entitymanager, Handler handler, ID id, PlayerTroop troop, EnemyTroop etroop) {
        super(handler, DEFAULT_X, DEFAULT_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, id);
        this.entitymanager = entitymanager;
        entitymanager.addEntity(troop);
        entitymanager.addEntity(etroop);
        r = new Random();
    }

    @Override
    public void tick() {
        count++;
        if (count % 150 == 0) {
            entitymanager.addEntity(new Coin(handler, r.nextFloat() * handler.getHeight(), r.nextFloat() * handler.getHeight(), ID.Coin));
        }
        if (count % 350 == 0) {
            entitymanager.addEntity(new Potion(handler, r.nextFloat() * (handler.getHeight() - 20), r.nextFloat() * (handler.getHeight() - 20), ID.Potion));
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.decode("#41245C"));
        g.fillRect(DEFAULT_X, DEFAULT_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        g.setColor(Color.decode("#FFE180"));
        g.fillRect(640, 0, DEFAULT_WIDTH - DEFAULT_HEIGHT, DEFAULT_HEIGHT);
    }

    @Override
    public void die() {
    }
}
