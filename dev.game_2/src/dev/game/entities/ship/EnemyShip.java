package dev.game.entities.ship;

import dev.game.Handler;
import dev.game.entities.Entity;
import dev.game.entities.EntityManager;
import dev.game.entities.ID;
import dev.game.entities.combattroop.CombatMenu;
import dev.game.entities.combattroop.EnemyTroop;
import dev.game.entities.combattroop.PlayerTroop;
import dev.game.gfx.Animation;
import dev.game.gfx.Asset;
import java.awt.Graphics;

public class EnemyShip extends MotherShip {

    private int[][] MonIndex;
    private int MonNumber;
    private Animation temp;

    public EnemyShip(int[][] MonIndex, int MonNumber, EntityManager entitymanager, Handler handler, float x, float y, ID id) {
        super(entitymanager, handler, x, y, MotherShip.DEFAULT_CREATURE_WIDTH, MotherShip.DEFAULT_CREATURE_HEIGHT, id);
        this.MonIndex = MonIndex;
        this.MonNumber = MonNumber;

        this.x = MonIndex[MonNumber][0];
        this.y = MonIndex[MonNumber][1];

        if (MonIndex[MonNumber][2] == 1) {
            temp = new Animation(500, Asset.enemy1);
        } else if (MonIndex[MonNumber][2] == 2) {
            temp = new Animation(500, Asset.enemy2);
        }
    }

    @Override
    public void tick() {
        temp.tick();
        Entity e = checkEntityCollisions(0f, 0f);
        if (e != null && e.getID() == ID.WorldEntity) {
            active = false;
            PlayerTroop combatPlayer = new PlayerTroop(MonIndex[MonNumber][4], entitymanager, handler, 300, 500, ID.Player);
            EnemyTroop combatEnemy = new EnemyTroop(MonIndex, MonNumber, combatPlayer, entitymanager, handler, 300, 0, ID.Enemy);
            entitymanager.addEntity(new CombatMenu(combatPlayer, combatEnemy, handler, x, y, width, height, ID.Menu));
            entitymanager.addEntity(combatPlayer);
            entitymanager.addEntity(combatEnemy);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(temp.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    @Override
    public void die() {
    }
}
