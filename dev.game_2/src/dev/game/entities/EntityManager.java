package dev.game.entities;

import dev.game.Handler;
import java.awt.Graphics;
import java.util.ArrayList;

public class EntityManager {

    private Handler handler;
    private ArrayList<Entity> entities;

    public EntityManager(Handler handler) {
        this.handler = handler;
        entities = new ArrayList<Entity>();
    }

    public EntityManager() {
    }

    public void tick() {
        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);
            e.tick();
            if (e.getActive() == false) {
                entities.remove(e);
            }
        }
    }

    public void render(Graphics g) {
        entities.forEach((Entity e) -> {
            e.render(g);
        });
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public void removeEntity(Entity e) {
        entities.remove(e);
    }
    //GETTERS SETTERS

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
