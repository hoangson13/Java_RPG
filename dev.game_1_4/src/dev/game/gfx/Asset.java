package dev.game.gfx;

import java.awt.image.BufferedImage;

public class Asset {

    public static BufferedImage dirt, water, grass, rock, fire, ice;
    public static BufferedImage[] player, enemy1, enemy2;
    public static BufferedImage[] playbutton, helpbutton, exitbutton;
    private static final int width = 200, height = 200;

    public static void intit() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/texture/sheet.png"));

        dirt = sheet.crop(0, 0, width, height);
        water = sheet.crop(width, 0, width, height);
        grass = sheet.crop(width * 2, 0, width, height);
        rock = sheet.crop(width * 3, 0, width, height);
        fire = sheet.crop(width * 4, 0, width, height);
        ice = sheet.crop(width * 5, 0, width, height);

        playbutton = new BufferedImage[2];
        playbutton[0] = sheet.crop(0, height, width * 2, height);
        playbutton[1] = sheet.crop(0, height * 2, width * 2, height);

        helpbutton = new BufferedImage[2];
        helpbutton[0] = sheet.crop(width * 2, height, width * 2, height);
        helpbutton[1] = sheet.crop(width * 2, height * 2, width * 2, height);

        exitbutton = new BufferedImage[2];
        exitbutton[0] = sheet.crop(width * 4, height, width * 2, height);
        exitbutton[1] = sheet.crop(width * 4, height * 2, width * 2, height);

        player = new BufferedImage[2];
        player[0] = sheet.crop(0, height * 3, width, height);
        player[1] = sheet.crop(width, height * 3, width, height);

        enemy1 = new BufferedImage[2];
        enemy1[0] = sheet.crop(width * 2, height * 3, width, height);
        enemy1[1] = sheet.crop(width * 3, height * 3, width, height);

        enemy2 = new BufferedImage[2];
        enemy2[0] = sheet.crop(width * 4, height * 3, width, height);
        enemy2[1] = sheet.crop(width * 5, height * 3, width, height);
    }
}
