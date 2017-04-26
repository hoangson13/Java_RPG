package dev.game.entities.combattroop;

import dev.game.Handler;
import dev.game.entities.Entity;
import dev.game.entities.EntityManager;
import dev.game.entities.ID;
import dev.game.gfx.Animation;
import dev.game.gfx.Asset;
import java.awt.Graphics;

public class EnemyTroop extends CombatTroop {

    private final float inital;
    private int count = 0;
    private PlayerTroop player;
    private int[][] MonIndex;
    private int MonNumber;
    private Animation Anitemp;

    public EnemyTroop(int[][] MonIndex, int MonNumber, PlayerTroop player, EntityManager entitymanager, Handler handler, float x, float y, ID id) {
        super(entitymanager, handler, x, y, id);
        this.MonIndex = MonIndex;
        this.MonNumber = MonNumber;
        this.player = player;
        inital = x;
        setHealth(MonIndex[MonNumber][3]);
        setAtk(MonIndex[MonNumber][4]);
        setDef((float) MonIndex[MonNumber][5] / 100);
        setSpeed(MonIndex[MonNumber][6]);

        if (MonIndex[MonNumber][2] == 1) {
            Anitemp = new Animation(500, Asset.enemy1);
        } else if (MonIndex[MonNumber][2] == 2) {
            Anitemp = new Animation(500, Asset.enemy2);
        } else if (MonIndex[MonNumber][2] == 3) {
            Anitemp = new Animation(500, Asset.enemy3);
        } else {
            Anitemp = new Animation(500, Asset.enemy4);
        }
    }

    @Override
    public void tick() {
        Anitemp.tick();
        x += speed;
        if (x <= inital - 150 || x >= inital + 150) {
            speed *= -1; //lock vị trí cách 80px   
        }

        count++;
        if (count % MonIndex[MonNumber][7] == 0) {
            entitymanager.addEntity(new EnemyBullet(entitymanager, handler, x + width / 2, y + height, ID.EnemyBullet, atk));
        }
        if (count % MonIndex[MonNumber][8] == 0) {
            entitymanager.addEntity(new SmartBullet(entitymanager, handler, x + width / 2, y + height, ID.SmartEnemyBullet, atk));
        }

        Entity e = checkEntityCollisions(0f, 0f);
        if (e != null && e.getID() == ID.PlayerBullet) {
            PlayerBullet bullet = (PlayerBullet) e;
            hurt((int) (bullet.getAtk() * def));
            bullet.setActive(false);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Anitemp.getCurrentFrame(), (int) (x), (int) (y), width, height, null);
    }

    @Override
    public void die() {
    }

}
