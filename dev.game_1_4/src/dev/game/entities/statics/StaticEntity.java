package dev.game.entities.statics;

import dev.game.Handler;
import dev.game.entities.Entity;
import dev.game.entities.ID;

public abstract class StaticEntity extends Entity {

    public StaticEntity(Handler handler, float x, float y, int width, int height, ID id) {
        super(handler, x, y, width, height, id);
    }

}
