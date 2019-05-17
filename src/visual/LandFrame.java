/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visual;

import domain.Square;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import utility.Variables;

public class LandFrame extends JFrame{
    
    //variables
    public ArrayList<Square> mySquares;
    //constructor
    public LandFrame(ArrayList<Square> mySquares) {
        super("Shape");
        this.mySquares = mySquares;
        this.setSize(Variables.WIDTH, Variables.HEIGHT);
        this.setVisible(true);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        //iterate over all squares
        for (Square mySquare : mySquares) {
            int randomColor=(int)(Math.random()*4)+1;
            switch(randomColor){
                case 1:
                    g.setColor (Color.blue);
                    break;
                case 2:
                    g.setColor (Color.black);
                    break;
                case 3:
                    g.setColor (Color.cyan);
                    break;
                case 4:
                    g.setColor (Color.darkGray);
                    break;
            }
            g.drawString(mySquare.getIdentification(),mySquare.getxAxis(),mySquare.getyAxis()-5);
            g.fillRect(mySquare.getxAxis(), mySquare.getyAxis(), mySquare.getSide(), mySquare.getSide());
        } //end for
    }

    public void paintAgain(){
        repaint();
    }

}
