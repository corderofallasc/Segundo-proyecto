/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threads;

import domain.Square;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import utility.Variables;

/**
 *
 * @author Fabian
 */
public class SquareThread extends Thread{
    
    //variables
    private Square mySquare;
    private int delayTime;

    public SquareThread(Square mySquare, int delayTime) {
        super(mySquare.identification);
        this.mySquare = mySquare;
        this.delayTime = delayTime;
    }
    
    
    @Override
    public void run() {
        boolean flag=true;
        while (flag) {            
            try {
                //sleep for the animation
                sleep(delayTime);

                //move the object
                int newX=mySquare.getxAxis();
                if (newX>=(Variables.WIDTH-mySquare.getSide())) {
                    flag=false;
                }else{
                    newX+=5;
                }
                mySquare.setxAxis(newX);
                mySquare.setyAxis(mySquare.getyAxis());          
            } catch (InterruptedException ex) {
                Logger.getLogger(SquareThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//end run

    
}
