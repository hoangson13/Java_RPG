////abstrac type of all obj///

package game1;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Object {
    protected float x,y;
    protected ID id;
    protected float velX,velY;
    
    public Object(float x,float y, ID id){
        this.x=x;
        this.y=y;
        this.id=id;
    }    
    public abstract void tick(); //method làm sau mỗi tick của game loop
    public abstract void render(Graphics g); //tạo hiển thị
    public abstract Rectangle getBounds(); //xác định khung của obj để xác định va chạm
    
    public void setX(float x){
        this.x=x;
    }
    public void setY(float y){
        this.y=y;
    }
    public void setvelX(float x){
        this.velX=x;
    }
    public void setvelY(float y){
        this.velY=y;
    }
    public void setID(ID id){
        this.id=id;
    }

    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public float getvelX(){
        return velX;
    }
    public float getvelY(){
        return velY;
    }
    public ID getID(){
        return id;
    }
}