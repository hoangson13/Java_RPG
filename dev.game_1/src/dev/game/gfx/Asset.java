
package dev.game.gfx;

import java.awt.image.BufferedImage;

public class Asset {
    public static BufferedImage dirt,water,grass,rock,tree,enemy;
    public static BufferedImage[] player;
    public static BufferedImage[] playbutton;    
    private static final int width = 200, height = 200;    
    public static void intit(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/texture/sheet.png"));
        
	player = new BufferedImage[2];
        player[0]=sheet.crop(width * 4, 0, width, height);
        player[1]=sheet.crop(width * 5, 0, width, height);

	playbutton = new BufferedImage[2];
        playbutton[0]=sheet.crop(width , height, width * 2, height);
        playbutton[1]=sheet.crop(width * 3, height, width * 2, height);
        
        dirt = sheet.crop(0, 0, width, height);
	water = sheet.crop(width, 0, width, height);
	grass = sheet.crop(width * 2, 0, width, height);
	rock = sheet.crop(width * 3, 0, width, height);
        tree = sheet.crop(0, height, width, height);
        enemy = sheet.crop(0, height, width, height);
    }
}
