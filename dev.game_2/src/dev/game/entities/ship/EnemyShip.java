package dev.game.entities.ship;

import dev.game.Handler;
import dev.game.entities.Entity;
import dev.game.entities.EntityManager;
import dev.game.entities.ID;
import dev.game.entities.combattroop.BattleField;
import dev.game.entities.combattroop.EnemyTroop;
import dev.game.entities.combattroop.PlayerTroop;
import dev.game.gfx.Animation;
import dev.game.gfx.Asset;
import java.awt.Graphics;

public class EnemyShip extends Ship {

    private int[][] MonIndex;
    private int MonNumber;
    private Animation ship;

    public EnemyShip(int[][] MonIndex, int MonNumber, EntityManager entitymanager, Handler handler, float x, float y, ID id) {
        super(entitymanager, handler, x, y, Ship.DEFAULT_CREATURE_WIDTH, Ship.DEFAULT_CREATURE_HEIGHT, id);
        this.MonIndex = MonIndex;
        this.MonNumber = MonNumber;

        this.x = MonIndex[MonNumber][0];
        this.y = MonIndex[MonNumber][1];
        ship = new Animation(500, Asset.enemyship);
    }

    @Override
    public void tick() {
        ship.tick();
        Entity e = checkEntityCollisions(0f, 0f);
        if (e != null && e.getID() == ID.WorldEntity) {
            active = false;
            entitymanager.addEntity(new EnemyTroop(MonIndex, MonNumber, entitymanager, handler, 300, 0, ID.Enemy));
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ship.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    @Override
    public void die() {
    }
}
