package view;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage spriteSheet;

    public SpriteSheet(BufferedImage ss){
        this.spriteSheet = ss;
    }

    public BufferedImage grabSprite (int col, int row, int width, int height) {
        
        BufferedImage sprite = spriteSheet.getSubimage(col, row, width, height);
        return sprite;
    }


}
