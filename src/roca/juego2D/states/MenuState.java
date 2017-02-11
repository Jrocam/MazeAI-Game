/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roca.juego2D.states;

import java.awt.Graphics;
import roca.juego2D.Game;
import roca.juego2D.gfx.Assets;

/**
 *
 * @author JuanManuel
 */
public class MenuState extends State{
    
    public MenuState(Game game){
        super(game);
    }
    
    @Override
    public void tick() {
        if(game.getKeyManager().intro)
            State.setState(game.gameState);
            game.gameState.tick();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(Graphics g) {
        if(State.getState() == this)
            g.drawImage(Assets.menuImage,0,0,800,600, null);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
