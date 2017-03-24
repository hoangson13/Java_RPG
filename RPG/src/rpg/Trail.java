//Tạo trail cho đạn
package rpg;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends Object {
    
    private float alpha=1;
    private Handler handler;
    private Color color;
    private float life;

    public Trail(int x, int y, ID id, Color color, Handler handler, float life) {
        super(x, y, id);
        this.handler= handler;
        this.color=color;
        this.life=life;
    }

    @Override
    public void tick() {
        if(alpha>life)
            alpha-=life-0.01f;
        else handler.removeObject(this);
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setComposite(makeTransparent(alpha));
        
        g.setColor(color);
        g.fillOval(x, y, 10, 10);
        
        g2d.setComposite(makeTransparent(1));
    }
    
    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(type,alpha));
    }
    
    @Override
    public Rectangle getBounds() {
        return null;
    }
    
}
