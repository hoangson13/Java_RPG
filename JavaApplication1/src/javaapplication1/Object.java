////abstrac type of all obj///

package javaapplication1;

import java.awt.Graphics;

public abstract class Object {
    protected int x,y;
    protected ID id;
    protected int velX,velY;
    
    public Object(int x,int y, ID id){
        this.x=x;
        this.y=y;
        this.id=id;
    }    
    public abstract void tick();
    public abstract void render(Graphics g);
    
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