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

public class Playertwo extends Entity {
    
    Panel p;
    Keys key;
    

    public Playertwo(Panel p,Keys key){
        this.p=p;
        this.key=key;
        setDefaultValues();
        load();
    }


    public void setDefaultValues(){
        x=y=200;
        //speed=10;
        dir = "";
    }


    public void load()
    {
            none = new ImageIcon("").getImage();
            left= new ImageIcon("gamee/left2.png").getImage();
            right= new ImageIcon("gamee/right2.png").getImage();
            up= new ImageIcon("gamee/right2.png").getImage();
            down= new ImageIcon("gamee/right2.png").getImage();


    }

    public void update(){

        if(key.right2==true)
        {
            dir = "right";
            x=x+speed;
        }
        else if(key.left2==true)
        {
            dir = "left";
            x=x-speed;
        }
       else if(key.up2==true)
        {
            dir = "up";
            y=y-speed;
        }
        else if(key.down2==true)
        {
            dir = "down";
            y=y+speed;
        }
        else if(key.none==true)
        {
            dir = "none";

        }

    }



    public void paint(Graphics2D g) {

     // g.fillRect(x,y, 100, 100);

     Image img=null;

        switch (dir){

        case "right" : img = right;
        break;
        case "left" : img = left;
        break;
        case "down" : img = down;
        break;
        case "up" : img = up;
        break;
        case "none" : img = none;
        break;
        }
       //System.out.println(dir);

       g.drawImage(img,x,y,48,48,null);

       
    }




}
