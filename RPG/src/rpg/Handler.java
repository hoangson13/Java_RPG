//List of all the object
package rpg;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
    LinkedList<Object> object = new LinkedList<>();
    
    public void tick(){
        for (int i = 0 ;i < object.size(); i++){ ////Update all the obj
            Object temp = object.get(i);
            temp.tick();
        }
    }
    
    public void render(Graphics g){
        for (int i = 0 ;i < object.size(); i++){ ///Render all the obj
            Object temp = object.get(i);
            temp.render(g);
        }        
    }
    
    public void addObject(Object object){
        this.object.add(object);
    }
    
    public void removeObject(Object object){
        this.object.remove(object);
    }
}
