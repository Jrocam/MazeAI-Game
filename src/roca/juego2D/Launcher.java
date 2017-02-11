/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roca.juego2D;

import roca.juego2D.display.Display;

/**
 *
 * @author JuanManuel
 */
public class Launcher {
    
    public static void main(String[] arg){
        Game game = new Game("ANOTHER SIMPLE GAME",800,600);
        game.start();
    }
}
