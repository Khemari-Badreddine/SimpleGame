package Entity;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.*;
import java.io.IOException;

import Game.Keys;
import Game.Panel;



public class Player extends Entity{
    
    Panel p;
    Keys key;
    
    

    public Player(Panel p,Keys key){
        this.p=p;
        this.key=key;
        setDefaultValues();
        load();
    }


    public void setDefaultValues(){
        x=y=400;
        dir = "right";
    }


    public void load()
    {
        
        
            left= new ImageIcon("gamee/left.png").getImage();
            right= new ImageIcon("gamee/right.png").getImage();
            up= new ImageIcon("gamee/up.png").getImage();
            down= new ImageIcon("gamee/down.png").getImage();

            left2= new ImageIcon("gamee/left2nd.png").getImage();
            right2= new ImageIcon("gamee/right2nd.png").getImage();
            up2= new ImageIcon("gamee/up2nd.png").getImage();
            down2= new ImageIcon("gamee/down2nd.png").getImage();

            left3= new ImageIcon("gamee/left3rd.png").getImage();
            right3= new ImageIcon("gamee/right3rd.png").getImage();
            up3= new ImageIcon("gamee/up3rd.png").getImage();
            down3= new ImageIcon("gamee/down3rd.png").getImage();


    }


    public void update(){

        if(key.right==true)
        {
            dir = "right";
            x=x+speed;
        }
        else if(key.left==true)
        {
            dir = "left";
            x=x-speed;
        }
       else if(key.up==true)
        {
            dir = "up";
            y=y-speed;
        }
        else if(key.down==true)
        {
            dir = "down";
            y=y+speed;
        }

        counter++;
        if(counter >15)
        {
            if(num == 1)
            {
                num = 2;
            }
            else if(num == 2 ){

                num = 3;
            }
            else if(num == 3 ){

                num = 1;
            }
            counter = 0;
        }


    }



    public void paint(Graphics2D g) {

    //    g.fillRect(x,y, 100, 100);

      Image img=null;

        switch (dir){

        case "right" :
            if(num==1){
                img = right;
                
            }
            else if(num==2)
            {
                img = right2;
                
            }
            else if(num==3)
            {
                img = right3;
                
            }

        break;
        case "left" : 
        if(num==1){
            img = left;
            
        }
        else if(num==2)
        {
            img = left2;
            
        }
        else if(num==3)
        {
            img = left3;
            
        }

        break;
        case "down" : 
        if(num==1){
            img = down;
            
        }
        else if(num==2)
        {
            img = down2;
            
        }
        else if(num==3)
        {
            img = down3;
            
        }

        break;
        case "up" : 
        if(num==1){
            img = up;
            
        }
        else if(num==2)
        {
            img = up2;
            
        }
        else if(num==3)
        {
            img = up3;
            
        }
        
        break;
        }
      //  System.out.println(dir);

        g.drawImage(img,x,y,48,48,null);

        

       
    }



}
