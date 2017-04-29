package dev.game.entities.battleentity;

import dev.game.Handler;
import dev.game.entities.Entity;
import dev.game.entities.ID;
import java.awt.Color;
import java.awt.Graphics;

public class BattleField extends Entity {

    public BattleField(Handler handler, float x, float y, int width, int height, ID id) {
        super(handler, x, y, width, height, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.decode("#41245C"));
        g.fillRect(0, 0, 900, 640);
        g.setColor(Color.decode("#FFE180"));
        g.fillRect(640, 0, 260, 640);
    }

    @Override
    public void die() {
    }
}
