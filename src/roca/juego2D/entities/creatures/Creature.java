/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roca.juego2D.entities.creatures;

import roca.juego2D.Game;
import roca.juego2D.entities.Entity;

/**
 *
 * @author JuanManuel
 */
public abstract class Creature extends Entity {
    
    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 4.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 32;
    public static final int DEFAULT_CREATURE_HEIGHT = 32;
    
    protected int health;
    protected float speed;
    protected float xMove,yMove;
    
    public Creature(Game game,float x, float y, int width, int height) {
        super(game,x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0 ;
        yMove = 0 ;    
    }
    
    public void move(){
        x += xMove;
        y += yMove;
    }
    
    
    // GETTERS AND SETTERS
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
    
}
