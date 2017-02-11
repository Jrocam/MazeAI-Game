/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roca.juego2D.entities.creatures;

import java.awt.Graphics;
import roca.juego2D.Game;
import roca.juego2D.gfx.Assets;
import roca.juego2D.states.GameState;

/**
 *
 * @author JuanManuel
 */
public class Player extends Creature {

    private int DEFAULT_COLLISION_DISTANCE = 1;
    private int DEFAULT_COLLISION_HITBOX = 6;
    public int points;
    
    public Player(Game game,float x, float y) {
        super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
        
        
    }

    @Override
    public void tick() {
       getInput();
       move();
       game.getGameCamera().centerOnEntity(this);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void getInput(){
        xMove = 0;
        yMove = 0;
        
        
        
        if(game.getKeyManager().up)
            
            if(!GameState.getWorld().getTile( (int)(x)/32, (int)(y - DEFAULT_COLLISION_DISTANCE)/32).isSolid() && !GameState.getWorld().getTile( (int)((x) + DEFAULT_CREATURE_WIDTH-1)/32, (int)((y) - DEFAULT_COLLISION_DISTANCE)/32).isSolid())
                yMove = -speed;
            
        if(game.getKeyManager().down)
            
            if(!GameState.getWorld().getTile( (int)(x)/32, (int)(y + DEFAULT_CREATURE_HEIGHT-1 + DEFAULT_COLLISION_DISTANCE)/32).isSolid() && !GameState.getWorld().getTile( (int)((x) + DEFAULT_CREATURE_WIDTH-1)/32, (int)((y) + DEFAULT_CREATURE_HEIGHT-1 + DEFAULT_COLLISION_DISTANCE)/32).isSolid())
                yMove = speed;
            
        if(game.getKeyManager().left)
            
            if(!GameState.getWorld().getTile( (int)((x)-DEFAULT_COLLISION_DISTANCE)/32, (int)(y)/32).isSolid() && !GameState.getWorld().getTile( (int)((x) - DEFAULT_COLLISION_DISTANCE)/32, (int)((y) + DEFAULT_CREATURE_HEIGHT-1)/32).isSolid() )
                xMove = -speed;
            
        if(game.getKeyManager().right)
            
            if(!GameState.getWorld().getTile( (int)((x) + DEFAULT_CREATURE_WIDTH-1 + DEFAULT_COLLISION_DISTANCE)/32, (int)(y)/32).isSolid() && !GameState.getWorld().getTile( (int)((x) + DEFAULT_CREATURE_WIDTH-1 + DEFAULT_COLLISION_DISTANCE )/32, (int)((y) + DEFAULT_CREATURE_HEIGHT-1)/32).isSolid() )
                xMove = speed;
            
    }
    
    public int getPosX(){
        return (int) this.x;
    }
    public int getPosY(){
        return (int) this.y;
    }
    
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int)(x - game.getGameCamera().getxOffset()), (int)(y - game.getGameCamera().getyOffset()), width, height, null);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
