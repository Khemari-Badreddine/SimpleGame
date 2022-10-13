package Game;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;

import Entity.Player;
import Entity.Playertwo;
import Tiles.TileManager;

import java.math.*;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class Panel extends JPanel implements ActionListener{
    
    Timer timer;
    int FPS=0;
    long current,start=System.currentTimeMillis(),time;
    Keys key = new Keys();
    
    public final int maxScreenCol = 16,tilesize = 48,maxScreenRow = 12;

    TileManager tile = new TileManager(this);
    Player player = new Player(this, key);
    Playertwo player2 = new Playertwo(this, key);

    Panel()
    {
        this.setPreferredSize(new Dimension(768,576));
        this.addKeyListener(key);
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        timer = new Timer(15,this);
        timer.start();
        this.setFocusable(true);

    }


    public void actionPerformed(ActionEvent e) {
        FPS++;
        

        if(player.x>768-player.right.getWidth(null))
        {
          key.right=false;
        }
        else if(player.x<0){
          key.left=false;
           }
        else if(player.y<0){
            key.up=false;
          }
          else if(player.y>576-player.down.getHeight(null)){
            key.down=false;
          }     

        if(player.y<0 && (player.x < 48 || player.x > 720-player.right.getWidth(null)) )
           {
             player.y=576-player.up.getWidth(null);
           }
        else if(player.y>576-player.down.getHeight(null) && player.x>720-player.down.getWidth(null)){
            player.y=0;
             }   
        else if(player.y>576-player.down.getHeight(null) && tile.map01==true && player.x < 48){
             player.y=0;
             tile.map02=true;
             tile.map01=false;
             tile.loadmap02();
              }
        else if(player.y>576-player.down.getHeight(null) && tile.map02==true && (player.x < 48)){
             player.y=0;
             tile.map01=true;
             tile.map02=false;
             tile.loadmap01();
              }              

        update();
        repaint();

        current=System.currentTimeMillis();
        time=current-start;
        if(time>=1000)
        {
           // System.out.println("The FPS: "+FPS);
            FPS=0;
            time=0;
            start=System.currentTimeMillis();

        }
        
    }
  
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        tile.paint(g2D);
        player.paint(g2D);
        player2.paint(g2D);

    }

    public void update()
    {
        player.update();
        player2.update();
 
    }

    

}
