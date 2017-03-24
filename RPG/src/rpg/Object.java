////abstrac type of all obj///

package rpg;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Object {
    protected int x,y;
    protected ID id;
    protected int velX,velY;
    
    public Object(int x,int y, ID id){
        this.x=x;
        this.y=y;
        this.id=id;
    }    
    public abstract void tick(); //method làm sau mỗi tick của game loop
    public abstract void render(Graphics g); //tạo hiển thị
    public abstract Rectangle getBounds(); //xác định khung của obj để xác định va chạm
    
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public void setvelX(int x){
        this.velX=x;
    }
    public void setvelY(int y){
        this.velY=y;
    }
    public void setID(ID id){
        this.id=id;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getvelX(){
        return velX;
    }
    public int getvelY(){
        return velY;
    }
    public ID getID(){
        return id;
    }
}