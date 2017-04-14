package dev.game.entities.combat;

import dev.game.Handler;
import dev.game.entities.Entity;
import dev.game.entities.EntityManager;
import dev.game.entities.ID;
import java.awt.Color;
import java.awt.Graphics;

public class CombatEnemy extends CombatEntity {

    private final float inital;
    private int count = 0;
    private CombatPlayer player;

    public CombatEnemy(CombatPlayer player, EntityManager entitymanager, Handler handler, float x, float y, ID id) {
        super(entitymanager, handler, x, y, id);
        this.player = player;
        inital = x;
        setHealth(50);
    }

    @Override
    public void tick() {
        x += speed;
        if (x <= inital - 150 || x >= inital + 150) {
            speed *= -1; //lock vị trí cách 80px   
        }
        count++;
        if (count % 50 == 0) {
            entitymanager.addEntity(new EnemyBullet(entitymanager, handler, x + width / 2, y + height, ID.EnemyBullet));
        }
        if (count % 100 == 0) {
            entitymanager.addEntity(new SmartBullet(player, entitymanager, handler, x + width / 2, y + height, ID.EnemyBullet));
        }
        Entity e = checkEntityCollisions(0f, 0f);
        if (e != null && e.getID() == ID.PlayerBullet) {
            hurt(player.getAtk());
            e.setActive(false);
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect((int) x, (int) y, width, height);
        g.setColor(Color.WHITE);
        g.drawRect((int) x, (int) y, width, height);
    }

    @Override
    public void die() {
    }

}
