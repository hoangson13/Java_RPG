package dev.game.entities.combat;

import dev.game.Handler;
import dev.game.entities.Entity;
import dev.game.entities.EntityManager;
import dev.game.entities.ID;
import dev.game.gfx.Asset;
import java.awt.Graphics;

public class CombatEnemy extends CombatEntity {

    private final float inital;
    private int count = 0;
    private CombatPlayer player;
    private int[][] MonIndex;
    private int MonNumber;

    public CombatEnemy(int[][] MonIndex, int MonNumber, CombatPlayer player, EntityManager entitymanager, Handler handler, float x, float y, ID id) {
        super(entitymanager, handler, x, y, id);
        this.MonIndex = MonIndex;
        this.MonNumber = MonNumber;
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
        if (MonIndex[MonNumber][2] == 1) {
            g.drawImage(Asset.enemy1, (int) (x), (int) (y), width, height, null);
        } else if (MonIndex[MonNumber][2] == 2) {
            g.drawImage(Asset.enemy2, (int) (x), (int) (y), width, height, null);
        }
    }

    @Override
    public void die() {
    }

}
