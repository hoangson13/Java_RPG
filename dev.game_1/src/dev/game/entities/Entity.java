//Các vật thể 
package dev.game.entities;

import dev.game.Handler;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {

    protected float x, y;
    protected int width, height;
    protected int health=1;
    protected int atk=1;
    protected boolean active=true;
    protected Handler handler;
    protected Rectangle bounds;
	
    public Entity(Handler handler, float x, float y, int width, int height){
        this.handler = handler;
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
        bounds = new Rectangle(0,0,width,height);
    }
	
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void die();
    
    public Entity checkEntityCollisions(float xOffset, float yOffset){
	for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this)) continue;
            if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) return e;
            }
	return null;
    }
	
    public Rectangle getCollisionBounds(float xOffset, float yOffset){
	return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
    }
    
    public void hurt (int dam){
        health-=dam;
        if(health<=0) {active=false;die();}
    }
    
    public boolean isActive(){
        return active;
    }
        
    public float getX() {
	return x;
    }

    public void setX(float x) {
	this.x = x;
    }
    
    public int gethealth() {
	return health;
    }

    public void sethealth(int health) {
	this.health = health;
    }

    public int getatk() {
	return atk;
    }

    public void setatk(int atk) {
	this.atk = atk;
    }   
    
    public float getY() {
	return y;
    }

    public void setY(float y) {
	this.y = y;
    }

    public int getWidth() {
	return width;
    }

    public void setWidth(int width) {
	this.width = width;
    }

    public int getHeight() {
	return height;
    }

    public void setHeight(int height) {
	this.height = height;
    }	
}