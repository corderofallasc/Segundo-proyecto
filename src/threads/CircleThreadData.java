/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threads;

import domain.Circle;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import utility.Variables;

public class CircleThreadData extends Thread{
    
    //variables
    private Circle myCircle;
    private int delayTime;

    public CircleThreadData(Circle myCircle, int delayTime) {
        super(myCircle.identification);
        this.myCircle = myCircle;
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
                int newX=myCircle.getxAxis();
                if (newX>=(Variables.WIDTH-myCircle.getSize())) {
                    flag=false;
                }else{
                    newX+=5;
                }
                myCircle.setxAxis(newX);
                myCircle.setyAxis(myCircle.getyAxis());          
            } catch (InterruptedException ex) {
                Logger.getLogger(CircleThreadData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//end run

    
}
