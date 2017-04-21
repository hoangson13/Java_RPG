package dev.game.entities.statics;

import dev.game.Handler;
import dev.game.entities.Entity;
import dev.game.entities.EntityManager;
import dev.game.entities.ID;
import dev.game.entities.combat.CombatEnemy;
import dev.game.entities.combat.CombatMenu;
import dev.game.entities.combat.CombatPlayer;
import dev.game.gfx.Animation;
import dev.game.gfx.Asset;
import dev.game.tiles.Tile;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MonsterSpawner extends StaticEntity {

    private EntityManager entitymanager;
    private int[][] MonIndex;
    private int MonNumber;
    private Animation temp;

    public MonsterSpawner(int[][] MonIndex, int MonNumber, EntityManager entitymanager, Handler handler, float x, float y, ID id) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT, id);
        this.MonIndex = MonIndex;
        this.MonNumber = MonNumber;
        this.entitymanager = entitymanager;
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
        Entity e = checkEntityCollisions(0f, 0f);
        temp.tick();
        if (e != null && e.getID() == ID.WorldEntity) {
            active = false;
            CombatPlayer combatPlayer = new CombatPlayer(MonIndex[MonNumber][4], entitymanager, handler, 300, 500, ID.Player);
            CombatEnemy combatEnemy = new CombatEnemy(MonIndex, MonNumber, combatPlayer, entitymanager, handler, 300, 0, ID.Enemy);
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
