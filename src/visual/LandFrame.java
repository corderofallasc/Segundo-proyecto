/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visual;

import domain.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;
import utility.Variables;

public class LandFrame extends JFrame{
    
    //variables
//    public ArrayList<Square> mySquares;
    private int speed;
    private int quantity;
    private Rectangle mySquare;
    //constructor
//    public LandFrame(Object object, int quantity, int speed) {
//        super("Shape");
//        this.speed=speed;
//        this.quantity=quantity;
//        this.dataObject=object;
//        this.setSize(Variables.WIDTH, Variables.HEIGHT);
//        this.setVisible(true);
//    }
    public LandFrame(Rectangle mySquare, int quantity, int speed) {
        super("Shape");
        this.speed=speed;
        this.quantity=quantity;
        this.mySquare=mySquare;
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
            int carril=50;
            switch(randomColor){
                case 1:
                    carril=50;
                    break;
                case 2:
                    carril=115;
                    break;
                case 3:
                    carril=180;
                    break;
                case 4:
                    carril=50;
                    break;
            }
            switch(speed){
                case 250:
                    g.setColor (Color.blue);
                    mySquare.setyAxis(amount);
                    g.drawString(mySquare.getIdentification(),mySquare.getxAxis(),mySquare.getyAxis()+amount-5);
                    g.fillRect(mySquare.getxAxis(), mySquare.getyAxis(), mySquare.getWidth(), mySquare.getHeight());
                    break;
                case 450:
                    g.setColor (Color.cyan);
                    mySquare.setyAxis(amount);
                    g.drawString(mySquare.getIdentification(),mySquare.getxAxis(),mySquare.getyAxis()+amount-5);
                    g.fillRect(mySquare.getxAxis(), mySquare.getyAxis(), mySquare.getWidth(), mySquare.getHeight());
                    break;
                case 600:
                    g.setColor (Color.black);
                    mySquare.setyAxis(amount);
                    g.drawString(mySquare.getIdentification(),mySquare.getxAxis(),mySquare.getyAxis()+amount-5);
                    g.fillRect(mySquare.getxAxis(), mySquare.getyAxis(), mySquare.getWidth(), mySquare.getHeight());
                    break;
                case 800:
                    g.setColor (Color.gray);
                    mySquare.setyAxis(amount);
                    g.drawString(mySquare.getIdentification(),mySquare.getxAxis(),mySquare.getyAxis()+amount-5);
                    g.fillRect(mySquare.getxAxis(), mySquare.getyAxis(), mySquare.getWidth(), mySquare.getHeight());
                    break;
            }
            if (amount>=420) {
                amount=0;
                
            } else {
                amount+=70;
            }
        } //end for
    }
    
    public void paintAgain(){
        repaint();
    }

}
