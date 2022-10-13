package Tiles;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;


import javax.swing.*;

import Game.Panel;

public class TileManager extends Tiles {
    
Panel p;
public boolean map01=true,map02=false;
Tiles[] tile;
int matrix[][];

    public TileManager(Panel p)
    {
        this.p=p;
        tile = new Tiles[20];
        matrix = new int[p.maxScreenCol][p.maxScreenRow];
        loadmap01();
        load();

    }


    public void loadmap01()
    {
        int i=0,j=0;
        System.out.println("here");
        map01=true;
        map02=false;
        try{

            //InputStream is = getClass().getResourceAsStream("E:\\MyGame\\Tiles\\map01.txt");
            BufferedReader br = new BufferedReader(new FileReader("Tiles/map01.txt"));
            int col=0,row=0;
            

           while(col<p.maxScreenCol && row<p.maxScreenRow){

            String line = br.readLine();

                while(col<p.maxScreenCol){

                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    matrix[col][row] = num;
                    col++;
                }
                    
                if(col == p.maxScreenCol){
                    col=0;
                    row ++;
                }
                }
                br.close();
            }
            catch(Exception e){

            }

            while(j <p.maxScreenRow){

            System.out.print(matrix[i][j]+" ");
            i++;
            if(i==p.maxScreenCol)
            {   

               System.out.println();
                i=0;
                j++;
            }
            }
    
    }


    public void loadmap02()
    {
        int i=0,j=0;
        map02=true;
        map01=false;
        try{

            
            BufferedReader br = new BufferedReader(new FileReader("Tiles/map02.txt"));
            int col=0,row=0;
            

           while(col<p.maxScreenCol && row<p.maxScreenRow){

            String line = br.readLine();

                while(col<p.maxScreenCol){

                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    matrix[col][row] = num;
                    col++;
                }
                    
                if(col == p.maxScreenCol){
                    col=0;
                    row ++;
                }
                }
                br.close();
            }
            catch(Exception e){

            }

            // while(j <p.maxScreenRow){

            // System.out.print(matrix[i][j]+" ");
            // i++;
            // if(i==p.maxScreenCol)
            // {   

            //    System.out.println();
            //     i=0;
            //     j++;
            // }
            // }
    
    }

    public void load()
    {

            tile[0]= new Tiles();
            tile[0].image= new ImageIcon("").getImage();

            tile[1]= new Tiles();
            tile[1].image= new ImageIcon("tiless/up.png").getImage();

            tile[2]= new Tiles();
            tile[2].image= new ImageIcon("tiless/left.png").getImage();

            tile[3]= new Tiles();
            tile[3].image= new ImageIcon("tiless/gold.png").getImage();

            tile[4]= new Tiles();
            tile[4].image= new ImageIcon("tiless/grass.png").getImage();
            
            tile[5]= new Tiles();
            tile[5].image= new ImageIcon("tiless/sand.jpg").getImage();
                        
            tile[6]= new Tiles();
            tile[6].image= new ImageIcon("tiless/sky.png").getImage();
                                                       
            tile[7]= new Tiles();
            tile[7].image= new ImageIcon("tiless/sky3.png").getImage();
 
    }

    public void paint(Graphics2D g) {
    
            int col=0,row=0,x=0,y=0;

            while(col<p.maxScreenCol && row<p.maxScreenRow){
                int tileNum = matrix[col][row];
                g.drawImage(tile[tileNum].image,x,y,48,48,null);
                col++;
                x+=p.tilesize;
                if(col == p.maxScreenCol){
                    col=0;
                    x=0;
                    row++;
                    y+=p.tilesize;
                }
        }
    }

}
