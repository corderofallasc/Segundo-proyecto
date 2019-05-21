/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threads;

import domain.Rectangle;
import domain.ovalRectangle;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import utility.Variables;

public class ovalRectangleThreadData extends Thread{
    
    //variables
    private ovalRectangle myRectangle;
    private int delayTime;

    public ovalRectangleThreadData(ovalRectangle myRectangle, int delayTime) {
        super(myRectangle.identification);
        this.myRectangle = myRectangle;
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
                int newX=myRectangle.getxAxis();
                if (newX>=(Variables.WIDTH-myRectangle.getWidth())) {
                    flag=false;
                }else{
                    newX+=5;
                }
                myRectangle.setxAxis(newX);
                myRectangle.setyAxis(myRectangle.getyAxis());          
            } catch (InterruptedException ex) {
                Logger.getLogger(ovalRectangleThreadData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//end run

    
}
