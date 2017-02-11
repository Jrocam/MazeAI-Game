/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roca.juego2D.states;

import java.awt.Graphics;
import roca.juego2D.Game;

/**
 *
 * @author JuanManuel
 */
public abstract class State {
    
    //GameStateManager
    private static State currentState = null;
    
    public static void setState(State state){
        currentState = state;
    }
    
    public static State getState(){
        return currentState;
    }
    
    //CLASS
    
    protected Game game;
    
    public State(Game game){
        this.game = game;
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
    
    
}
