package dev.game.entities.battleentity;

import dev.game.Handler;
import dev.game.entities.Entity;
import dev.game.entities.ID;
import java.awt.Color;
import java.awt.Graphics;

public class Posion extends Entity {

    private int count = 0;
    public static final int DEFAULT_POSION_WIDTH = 20, DEFAULT_POSION_HEIGHT = 20;

    public Posion(Handler handler, float x, float y, ID id) {
        super(handler, x, y, DEFAULT_POSION_WIDTH, DEFAULT_POSION_HEIGHT, id);
    }

    @Override
    public void tick() {
        count++;
        if (count == 150) {
            active = false; //Đạn biến mất sau 1 time    
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.decode("#FA7E0A"));
        g.fillOval((int) x, (int) y, width, height);
    }

    @Override
    public void die() {
    }
}
