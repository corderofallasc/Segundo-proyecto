/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visual;

import domain.Circle;
import domain.Rectangle;
import domain.Square;
import domain.ovalRectangle;
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
//    public ArrayList<Square> mySquares;
    private int speed;
    private int quantity;
    private Object myObject;
    private Object dataObject;
    //constructor
    public LandFrame(Object object, int quantity, int speed) {
        super("Shape");
        this.speed=speed;
        this.quantity=quantity;
        this.dataObject=object;
        this.setSize(Variables.WIDTH, Variables.HEIGHT);
        this.setVisible(true);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        int amount=0;
        
        //iterate over all squares
        for (int i = 0; i < quantity; i++) {
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
            switch(speed){
                case 250:
                    Square mySquare=(Square)this.dataObject;
                    g.drawString(mySquare.getIdentification(),mySquare.getxAxis(),mySquare.getyAxis()+amount-5);
                    g.fillRect(mySquare.getxAxis(), mySquare.getyAxis()+amount, mySquare.getSize(), mySquare.getSize());
                    break;
                case 450:
                    ovalRectangle myOvaRectangle=(ovalRectangle)this.dataObject;
                    g.drawString(myOvaRectangle.getIdentification(),myOvaRectangle.getxAxis(),myOvaRectangle.getyAxis()-5);
                    g.fillRoundRect(myOvaRectangle.getxAxis(), myOvaRectangle.getyAxis(),myOvaRectangle.getWidth(), myOvaRectangle.getHeight(),myOvaRectangle.getArcWidth(), myOvaRectangle.getArcHeight());
                    break;
                case 600:
                    Circle myCircle=(Circle)this.dataObject;
                    g.drawString(myCircle.getIdentification(),myCircle.getxAxis(),myCircle.getyAxis()-5);
                    g.fillOval(myCircle.getxAxis(), myCircle.getyAxis(), myCircle.getSize(), myCircle.getSize());
                    break;
                case 800:
                    Rectangle myRectangle=(Rectangle)this.dataObject;
                    g.drawString(myRectangle.getIdentification(),myRectangle.getxAxis(),myRectangle.getyAxis()-5);
                    g.fillRect(myRectangle.getxAxis(), myRectangle.getyAxis(), myRectangle.getWidth(), myRectangle.getHeight());
                    break;
            }
            amount+=50;
        } //end for
    }

    public void paintAgain(){
        repaint();
    }

}
