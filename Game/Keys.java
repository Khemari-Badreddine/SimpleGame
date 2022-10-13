package Game;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;



public class Keys implements KeyListener{


    public boolean up,down,left,right,up2,down2,left2,right2,none=false;
      String lkp;

    @Override
    public void keyTyped(KeyEvent e) {
      //  System.out.println(e.getKeyChar());
      
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyChar())
        {
           case 'd': 
           right=true;
           //left = up = down = false;
           break;
           case 'z': 
           up=true;
           //left = right = down = false;
           break;
           case 's': 
           down=true;
           //left = up = right = false;
           break;
           case 'q':
            left=true;
          // right = up = down = false;
           break;
        }

        switch (e.getKeyCode())
        {
           case 39 :
            right2=true;
            left2 = up2 = down2 = false;
           break;
           case 38 :
            up2=true;
            left2 = right2 = down2 = false;
           break;
           case 40 :
            down2=true;
            left2 = up2 = right2 = false;
           break;
           case 37 :
            left2=true;
            right2 = up2 = down2 = false;
           break;
           case 8 : 
           none = true;
           break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch (e.getKeyChar())
        {
           case 'd': right=false;
           break;
           case 'z': up=false;
           break;
           case 's': down=false;
           break;
           case 'q': left=false;
           break;
        }

        switch (e.getKeyCode())
        {
           case 39 : right2=false;
           break;
           case 38 : up2=false;
           break;
           case 40 : down2=false;
           break;
           case 37 : left2=false;
           break;
           case 8 : none = false;
           break;
        }
    }
    
}
