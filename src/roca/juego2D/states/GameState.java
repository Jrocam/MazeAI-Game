/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roca.juego2D.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import roca.juego2D.Game;
import roca.juego2D.entities.creatures.Enemy;
import roca.juego2D.entities.creatures.Player;
import roca.juego2D.tiles.Tile;
import static roca.juego2D.tiles.Tile.tiles;
import roca.juego2D.worlds.World;

/**
 *
 * @author JuanManuel
 */
public class GameState extends State {
    
    private Player player;
    private static World world;
    public Enemy e1,e2,e3,e4;
    public static boolean Dead = false;
    public static boolean Win = false;
    public int points;
    Font font = new Font("SansSerif", Font.PLAIN, 18);
    
    public GameState(Game game){
        super(game);
        player = new Player(game,100,100);
        world = new World(game,"rec/worlds/world1.txt");
        e1 = new Enemy(game,32,32);
        e2 = new Enemy(game,32*27,32*17);
        e3 = new Enemy(game,32*25,32);
        e4 = new Enemy(game,32,32*17);
        
    }
    
    
    @Override
    public void tick() {
        
        world.tick();
        
        if(Dead == true)
            restart();
        if(Win == true)
            restart();
        
        
        
        player.tick();
        e1.tick();
        e2.tick();
        e3.tick();
        e4.tick();
        
        //CHECK SI ESTA MUERTO
        
        if(getBoundsP().intersects(getBoundsE1()))
            Dead = true;
            //restart();
        if(getBoundsP().intersects(getBoundsE2()))
            Dead = true;
            //restart();
        if(getBoundsP().intersects(getBoundsE3()))
            Dead = true;
            //restart();
        if(getBoundsP().intersects(getBoundsE4()))
            Dead = true;
            //restart();
        
        //CHECK SI ESTA COGIENDO MONEDAS
        points(player,player.getPosX()/32,player.getPosY()/32,world.tiles);
        
        
        if(player.points == 11)
            Win=true;
            //restart();
            
        
        
        
        //game.getGameCamera().move(1,1);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Rectangle getBoundsP() {
        return new Rectangle(player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight());
    }
    public Rectangle getBoundsE1(){
        return new Rectangle(e1.getPosX(), e1.getPosY(), e1.getWidth(), e1.getHeight());
    }
    public Rectangle getBoundsE2(){
        return new Rectangle(e2.getPosX(), e2.getPosY(), e2.getWidth(), e2.getHeight());
    }
    public Rectangle getBoundsE3(){
        return new Rectangle(e3.getPosX(), e3.getPosY(), e3.getWidth(), e3.getHeight());
    }
    public Rectangle getBoundsE4(){
        return new Rectangle(e4.getPosX(), e4.getPosY(), e4.getWidth(), e4.getHeight());
    }
    
    public void restart(){
        System.out.println("YourScoreWas:"+player.points);
        player.points=0;
        Dead = false;
        Win = false;
        player = new Player(game,100,100);
        world = new World(game,"rec/worlds/world1.txt");
        e1 = new Enemy(game,32,32);
        e2 = new Enemy(game,32*27,32*17);
        e3 = new Enemy(game,32*25,32);
        e4 = new Enemy(game,32,32*17);
    }
    
    
    @Override
    public void render(Graphics g) {
        if(State.getState() == this)
            world.render(g);
            player.render(g);
            e1.render(g);
            e2.render(g);
            e3.render(g);
            e4.render(g);


            String Str = Integer.toString(player.points*100);
            g.setColor(Color.BLUE);
            g.setFont(font);
            g.drawString("POINTS = ",650, 25);
            g.setFont(font);
            g.drawString(Str,737,25);
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static World getWorld(){
        return world;
    }

    private void points(Player player,int X,int Y,int[][] tile) {
        if(world.getTile(X, Y)==Tile.boxTile){
            tile[X][Y]=0;
            player.points=player.points+1;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
