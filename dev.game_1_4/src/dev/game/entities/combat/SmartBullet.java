package dev.game.entities.combat;

import dev.game.Handler;
import dev.game.entities.Entity;
import dev.game.entities.EntityManager;
import dev.game.entities.ID;
import java.awt.Color;
import java.awt.Graphics;

public class SmartBullet extends CombatEntity {

    private float Xmove = 5, Ymove = 5;
    private int count = 0;
    private CombatPlayer player;

    public SmartBullet(CombatPlayer player, EntityManager entitymanager, Handler handler, float x, float y, ID id) {
        super(entitymanager, handler, x, y, id);
        this.player = player;
        height = 10;
        width = 10;
    }

    @Override
    public void tick() {
        count++;

        x += Xmove;
        y += Ymove;
        float diffX = x - player.getX() - 10;
        float diffY = y - player.getY() - 10;
        float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));
        Xmove = ((float) ((-1.0 / distance) * diffX)) * 2;
        Ymove = ((float) ((-1.0 / distance) * diffY)) * 2;

        if (y <= 0 || y >= handler.getHeight() - 50) {
            Ymove *= -1;
        }
        if (x <= 0 || x >= handler.getHeight() - 10) {
            Xmove *= -1;
        }
//Đạn biến mất sau 1 time
        if (count == 500) {
            active = false;
        }

        entitymanager.addEntity(new Trail(entitymanager, handler, x, y, ID.Trail, Color.ORANGE, 0.1f));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillOval((int) x, (int) y, width, height);
    }

    @Override
    public void die() {
    }

}
