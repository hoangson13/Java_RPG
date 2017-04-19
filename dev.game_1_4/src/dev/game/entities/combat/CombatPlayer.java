package dev.game.entities.combat;

import dev.game.Handler;
import dev.game.entities.Entity;
import dev.game.entities.EntityManager;
import dev.game.entities.ID;
import java.awt.Color;
import java.awt.Graphics;

public class CombatPlayer extends CombatEntity {

    private int count = 0;
    private int EnemyATK;

    public CombatPlayer(int EnemyATK, EntityManager entitymanager, Handler handler, float x, float y, ID id) {
        super(entitymanager, handler, x, y, id);
        this.EnemyATK=EnemyATK;
        setHealth(1000);
        setAtk(50);
        setDef(0.8f);
    }

    @Override
    public void tick() {
        count++;
        x = clamp(0, 600, handler.getMouseManager().getMouseX() - 20);
        y = clamp(0, 600, handler.getMouseManager().getMouseY());
        if (handler.getMouseManager().isLeftPressed() == true && count % 10 == 0) {
            entitymanager.addEntity(new PlayerBullet(entitymanager, handler, x + width / 2, y - 10, ID.PlayerBullet));
        }
        Entity e = checkEntityCollisions(0f, 0f);
        if (e != null && (e.getID() == ID.EnemyBullet || e.getID() == ID.Enemy)) {
            hurt((int) (EnemyATK*def));
            if (e.getID() == ID.EnemyBullet) {
                e.setActive(false);
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((int) x, (int) y, width, height);
        g.setColor(Color.WHITE);
        g.drawRect((int) x, (int) y, width, height);
    }

    @Override
    public void die() {
    }

}
