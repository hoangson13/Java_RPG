package dev.game.entities.combat;

import dev.game.Handler;
import dev.game.entities.Entity;
import dev.game.entities.EntityManager;
import dev.game.entities.ID;
import java.awt.Color;
import java.awt.Graphics;

public class CombatPlayer extends CombatEntity {

    private int count = 0;
    private int[][] MonIndex;
    private int MonNumber;

    public CombatPlayer(int[][] MonIndex, int MonNumber, EntityManager entitymanager, Handler handler, float x, float y, ID id) {
        super(entitymanager, handler, x, y, id);
        this.MonIndex = MonIndex;
        this.MonNumber = MonNumber;
        setHealth(100);
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
        if (e != null && e.getID() == ID.EnemyBullet) {
            hurt(MonIndex[MonNumber][2]);
            e.setActive(false);
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
