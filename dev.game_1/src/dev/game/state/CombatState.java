
package dev.game.state;

import dev.game.Handler;
import dev.game.entities.EntityManager;
import dev.game.entities.combatentity.CombatEnemy;
import dev.game.entities.combatentity.CombatPlayer;
import java.awt.Color;
import java.awt.Graphics;

public class CombatState extends State{
    private EntityManager entitymanager;
    public CombatState(Handler handler,EntityManager entitymanager) {
        super(handler);
        this.entitymanager=entitymanager;
        entitymanager.addEntity(new CombatEnemy(entitymanager,handler,310,100,40,40));        
        entitymanager.addEntity(new CombatPlayer(entitymanager,handler,310,400,40,40));
    }

    @Override
    public void tick() {
        entitymanager.tick();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, handler.getHeight(), handler.getHeight());
        entitymanager.render(g);
    }    
}
