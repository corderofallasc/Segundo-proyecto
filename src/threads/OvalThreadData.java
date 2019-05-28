/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threads;

import domain.Oval;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import utility.Variables;

public class OvalThreadData extends Thread{
    
    //variables
    private Oval myOval;
    private int delayTime;

    public OvalThreadData(Oval myOval, int delayTime) {
        super(myOval.identification);
        this.myOval = myOval;
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
                int newX=myOval.getxAxis();
                if (newX>=(Variables.WIDTH-myOval.getSizeX())) {
                    flag=false;
                }else{
                    newX+=5;
                }
                myOval.setxAxis(newX);
                myOval.setyAxis(myOval.getyAxis());          
            } catch (InterruptedException ex) {
                Logger.getLogger(OvalThreadData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//end run

    
}
