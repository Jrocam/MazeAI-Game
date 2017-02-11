/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roca.juego2D.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author JuanManuel
 */
public class Assets {
    
    //ejemplo:
    
    private static final int width = 32, height = 32;
    
    public static BufferedImage menuImage,winImage,loseImage,player, dirt, grass, stone, tree; 
    
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"));
        menuImage = ImageLoader.loadImage("/textures/MenuBasico.png");
        winImage = ImageLoader.loadImage("/textures/WinBasico.png");
        loseImage = ImageLoader.loadImage("/textures/LoseBasico.png");
        player = sheet.crop(0,0,width, height);
        stone = sheet.crop(width,0,width,height);
        grass = sheet.crop(width* 2, 0, width, height);
        dirt = sheet.crop(width* 3, 0, width, height);
        tree = sheet.crop(0, height, width, height);
    }
    
}
