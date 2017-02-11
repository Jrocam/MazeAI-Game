/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roca.juego2D.entities.creatures;

import java.awt.Graphics;
import java.util.Random;
import roca.juego2D.Game;
import static roca.juego2D.entities.creatures.Creature.DEFAULT_CREATURE_HEIGHT;
import static roca.juego2D.entities.creatures.Creature.DEFAULT_CREATURE_WIDTH;
import roca.juego2D.gfx.Assets;
import roca.juego2D.states.GameState;

/**
 *
 * @author JuanManuel
 */
public class Enemy extends Creature {

    private int DEFAULT_COLLISION_DISTANCE = 1;
    private int random;
    public Enemy(Game game, float x, float y) {
        super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.x = x;
        this.y = y;
        this.game = game;
        random = getRandomInt(0,4);
    }

    @Override
    public void tick() {
        
        xMove = 0;
        yMove = 0;
        
        if(random == 0) 
            if(!GameState.getWorld().getTile( (int)(x)/32, (int)(y - DEFAULT_COLLISION_DISTANCE)/32).isSolid() && !GameState.getWorld().getTile( (int)((x) + DEFAULT_CREATURE_WIDTH-1)/32, (int)((y) - DEFAULT_COLLISION_DISTANCE)/32).isSolid())
                //y -= 1;
                yMove = -2.0f;
            else
                random = getRandomInt(0,4);
            
        if(random == 1)
            if(!GameState.getWorld().getTile( (int)(x)/32, (int)(y + DEFAULT_CREATURE_HEIGHT-1 + DEFAULT_COLLISION_DISTANCE)/32).isSolid() && !GameState.getWorld().getTile( (int)((x) + DEFAULT_CREATURE_WIDTH-1)/32, (int)((y) + DEFAULT_CREATURE_HEIGHT-1 + DEFAULT_COLLISION_DISTANCE)/32).isSolid())
                //y += 1;
                yMove = 2.0f;
            else
                random = getRandomInt(0,4);
            
        if(random == 2)
            if (!GameState.getWorld().getTile( (int)((x)-DEFAULT_COLLISION_DISTANCE)/32, (int)(y)/32).isSolid() && !GameState.getWorld().getTile( (int)((x) - DEFAULT_COLLISION_DISTANCE)/32, (int)((y) + DEFAULT_CREATURE_HEIGHT-1)/32).isSolid() )
                //x -= 1;
                xMove = -2.0f;
            else
                random = getRandomInt(0,4);
            
        if(random == 3)
            if(!GameState.getWorld().getTile( (int)((x) + DEFAULT_CREATURE_WIDTH-1 + DEFAULT_COLLISION_DISTANCE)/32, (int)(y)/32).isSolid() && !GameState.getWorld().getTile( (int)((x) + DEFAULT_CREATURE_WIDTH-1 + DEFAULT_COLLISION_DISTANCE )/32, (int)((y) + DEFAULT_CREATURE_HEIGHT-1)/32).isSolid() )
                //x += 1;
                xMove = 2.0f;
            else
                random = getRandomInt(0,4);
        
        move();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getPosX(){
        return (int) this.x;
    }
    public int getPosY(){
        return (int) this.y;
    }
    public int getRandomInt(int min,int max){
        Random random = new Random();
        int randomNumber = random.nextInt(max - min) + min;
        return randomNumber;
    }
    
    @Override
    public void render(Graphics g) {
        
        g.drawImage(Assets.dirt,(int)(x - game.getGameCamera().getxOffset()),(int)(y - game.getGameCamera().getyOffset()),DEFAULT_CREATURE_WIDTH,DEFAULT_CREATURE_HEIGHT, null);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
