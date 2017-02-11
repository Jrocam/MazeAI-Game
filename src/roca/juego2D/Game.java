/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roca.juego2D;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import roca.juego2D.display.Display;
import roca.juego2D.gfx.Assets;
import static roca.juego2D.gfx.Assets.player;
import roca.juego2D.gfx.GameCamera;
import roca.juego2D.input.KeyManager;
import roca.juego2D.states.GameState;
import roca.juego2D.states.LoseState;
import roca.juego2D.states.MenuState;
import roca.juego2D.states.State;
import roca.juego2D.states.WinState;

/**
 *
 * @author JuanManuel
 */
public class Game implements Runnable {
    
    private Display display;
    private int width, height;
    public String title;
    
    private boolean running = false;
    private Thread thread;
    
    private BufferStrategy bs;
    private Graphics g;
    
    //States
    public State gameState;
    public State menuState;
    public State loseState;
    public State winState;
    
    //Input
    private KeyManager keyManager;
    
    //Camera
    private GameCamera gameCamera;
    
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
    }
    
    private void init(){
        display = new Display(title,width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();
        
        gameCamera = new GameCamera(this,0,0);
        
        gameState = new GameState(this);
        menuState = new MenuState(this);
        loseState = new LoseState(this);
        winState = new WinState(this);
        State.setState(menuState);
    }
    
    
    private void tick(){
        keyManager.tick();
        
        if(State.getState() != null)
            State.getState().tick();
        if (GameState.Dead)
            State.setState(loseState);
        if(GameState.Win)
            State.setState(winState);

            
        
    }
    
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);
        //Draw Here!
        
        if(State.getState() != null)
            State.getState().render(g);
   
        //End Drawing!
        bs.show();
        g.dispose();
    }
    
    @Override
    public void run(){
        
        init();
        
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        
        while(running){
            
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            
            if(delta >= 1){
                tick();
                render();
                ticks++;
                delta--;
            }
            
            if(timer >= 1000000000){
                System.out.println("Ticks and Frames:" + ticks);
                ticks = 0;
                timer = 0;
            }
            
        }
        
        stop();
    }
    
    public KeyManager getKeyManager(){
        return keyManager;
    }
    public GameCamera getGameCamera(){
        return gameCamera;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    
    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);}
    }
}
