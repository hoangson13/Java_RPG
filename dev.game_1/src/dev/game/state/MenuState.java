
package dev.game.state;

import dev.game.Handler;
import dev.game.UI.ClickListener;
import dev.game.UI.UIImageButton;
import dev.game.UI.UIManager;
import dev.game.gfx.Asset;
import java.awt.Graphics;

public class MenuState extends State{
    
    private UIManager uimanager; 
    
    public MenuState(Handler handler) {
        super(handler);
        uimanager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uimanager);
                
        uimanager.addObject(new UIImageButton(360,200,200,100,Asset.playbutton, new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));
    }

    @Override
    public void tick() {
        uimanager.tick();
    }

    @Override
    public void render(Graphics g) {
        uimanager.render(g);
    }
}