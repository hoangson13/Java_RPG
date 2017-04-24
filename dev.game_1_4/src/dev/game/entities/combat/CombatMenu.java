package dev.game.entities.combat;

import dev.game.Handler;
import dev.game.entities.Entity;
import dev.game.entities.ID;
import java.awt.Color;
import java.awt.Graphics;

public class CombatMenu extends Entity {

    CombatPlayer player;
    CombatEnemy enemy;
    private float se;
    private float pe;

    public CombatMenu(CombatPlayer player, CombatEnemy enemy, Handler handler, float x, float y, int width, int height, ID id) {
        super(handler, x, y, width, height, id);
        this.player = player;
        this.enemy = enemy;
        se = 200.0f / enemy.getHealth();
        pe = 200.0f / player.getHealth();
        System.out.println(se + " " + pe);
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
        //Enemy health bar
        g.setColor(Color.decode("#FF304F"));
        g.fillRect(650, 30, 200, 20);
        g.setColor(Color.black);
        g.drawRect(650, 30, 200, 20);
        g.setColor(Color.decode("#28C7FA"));
        g.fillRect(650, 30, (int) (enemy.getHealth() * se), 20);
        if (enemy.getHealth() <= 0) {
            g.drawString("Enemy's HP :" + 0, 650, 20);
        } else {
            g.drawString("Enemy's HP :" + enemy.getHealth(), 650, 20);
        }
        //Player health bar        
        g.setColor(Color.decode("#FF304F"));
        g.fillRect(650, 320, 200, 20);
        g.setColor(Color.black);
        g.drawRect(650, 320, 200, 20);
        g.setColor(Color.decode("#28C7FA"));
        g.fillRect(650, 320, (int) (player.getHealth() * pe), 20);
        if (player.getHealth() <= 0) {
            g.drawString("Player's HP :" + 0, 650, 310);
        } else {
            g.drawString("Player's HP :" + player.getHealth(), 650, 310);
        }
    }

    @Override
    public void die() {
    }
}
