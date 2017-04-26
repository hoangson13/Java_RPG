package dev.game.entities.combattroop;

import dev.game.Handler;
import dev.game.entities.Entity;
import dev.game.entities.EntityManager;
import dev.game.entities.ID;
import dev.game.gfx.Animation;
import dev.game.gfx.Asset;
import java.awt.Graphics;

public class PlayerTroop extends CombatTroop {

    private int count = 0;
    private Animation aniplayer;

    public PlayerTroop(EntityManager entitymanager, Handler handler, float x, float y, ID id) {
        super(entitymanager, handler, x, y, id);
        setHealth(1000);
        setAtk(50);
        setDef(0.8f);
        aniplayer = new Animation(500, Asset.player_up);
    }

    @Override
    public void tick() {
        aniplayer.tick();
        count++;
        x = clamp(0, 600, handler.getMouseManager().getMouseX() - 20);
        y = clamp(0, 600, handler.getMouseManager().getMouseY());

        if (handler.getMouseManager().isLeftPressed() == true && count % 10 == 0) {
            entitymanager.addEntity(new PlayerBullet(entitymanager, handler, x + width / 2, y - 10, ID.PlayerBullet, atk));
        }

        Entity e = checkEntityCollisions(0f, 0f);
        if (e != null && (e.getID() == ID.EnemyBullet || e.getID() == ID.Enemy || e.getID() == ID.SmartEnemyBullet)) {
            if (e.getID() == ID.EnemyBullet) {
                EnemyBullet bullet = (EnemyBullet) e;
                hurt((int) (bullet.getAtk() * def));
                bullet.setActive(false);
            }
            if (e.getID() == ID.SmartEnemyBullet) {
                SmartBullet bullet = (SmartBullet) e;
                hurt((int) (bullet.getAtk() * def));
                bullet.setActive(false);
            }
            if (e.getID() == ID.Enemy) {
                EnemyTroop troop = (EnemyTroop) e;
                hurt((int) (troop.getAtk() * def));
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(aniplayer.getCurrentFrame(), (int) x, (int) y, width, height, null);
    }

    @Override
    public void die() {
    }

}
