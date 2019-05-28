/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threads;

import domain.Rectangle;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import utility.Variables;

public class RectangleThreadData extends Thread{
    
    //variables
    private Rectangle myRectabgle;
    private int delayTime;

    public RectangleThreadData(Rectangle myRectangle, int delayTime) {
        super(myRectangle.identification);
        this.myRectabgle = myRectangle;
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
                int newX=myRectabgle.getxAxis();
                if (newX>=(Variables.WIDTH-myRectabgle.getWidth())) {
                    flag=false;
                }else{
                    newX+=5;
                }
                myRectabgle.setxAxis(newX);
//                myRectabgle.setyAxis(myRectabgle.getyAxis()); 
                
            } catch (InterruptedException ex) {
                Logger.getLogger(RectangleThreadData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//end run

    
}
