package Game;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;


public class Frame extends JFrame{

    Panel panel;

    Frame()
    {

        panel = new Panel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Pedro's Game");
        this.setLocationRelativeTo(null);
        this.add(panel);
        this.pack();


        this.setVisible(true);
    }


    
}
