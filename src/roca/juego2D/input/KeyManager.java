/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roca.juego2D.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author JuanManuel
 */
public class KeyManager implements KeyListener {
    
    private boolean[] keys;
    public boolean up,down,left,right,intro,space,back;
    
    public KeyManager(){
        keys = new boolean[256];
    }
    public void tick(){
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        intro = keys[KeyEvent.VK_ENTER];
        space = keys[KeyEvent.VK_SPACE];
        back = keys[KeyEvent.VK_BACK_SPACE];
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        keys[ke.getKeyCode()] = true;
        System.out.println("pressed!");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        keys[ke.getKeyCode()] = false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
