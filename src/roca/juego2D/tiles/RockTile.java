/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roca.juego2D.tiles;

import java.awt.image.BufferedImage;
import roca.juego2D.gfx.Assets;

/**
 *
 * @author JuanManuel
 */
public class RockTile extends Tile {

    public RockTile(int id) {
        super(Assets.stone, id);
    }
    
    
    @Override
    public boolean isSolid(){
        return true;
    }
    
}
