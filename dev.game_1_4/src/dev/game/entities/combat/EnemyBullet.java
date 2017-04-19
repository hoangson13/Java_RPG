package dev.game.entities.combat;

import dev.game.Handler;
import dev.game.entities.EntityManager;
import dev.game.entities.ID;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class EnemyBullet extends CombatEntity {

    private int count = 0;
    private int Xmove, Ymove;
    private Random r;

    public EnemyBullet(EntityManager entitymanager, Handler handler, float x, float y, ID id) {
        super(entitymanager, handler, x, y, id);
        r = new Random();
        height = 10;
        width = 10;
        Ymove = r.nextInt(5) + 3;
        Xmove = (r.nextInt(10) - 5);
    }

    @Override
    public void tick() {
        count++;
        x += Xmove;
        y += Ymove;
        if (y <= 0 || y >= handler.getHeight() - 5) {
            Ymove *= -1;
        }
        if (x <= 0 || x >= handler.getHeight() - 5) {
            Xmove *= -1;
        }

        if (count == 150) {
            active = false; //Đạn biến mất sau 1 time    
        }
        entitymanager.addEntity(new Trail(entitymanager, handler, x, y, ID.Trail, Color.red, 0.1f));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillOval((int) x, (int) y, width, height);
    }

    @Override
    public void die() {

    }

}
