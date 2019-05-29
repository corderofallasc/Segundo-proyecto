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

public class SquareThreadData extends Thread{
    
    //variables
    private Square mySquare;
    private int delayTime;
    public boolean pause;
    
    public SquareThreadData(Square mySquare, int delayTime) {
        super(mySquare.identification);
        this.mySquare = mySquare;
        this.delayTime = delayTime;
        this.pause= false;
        
    }
    
    
    public void pause(){
       //pause=true;
       while (pause == true) {
         try {
            Thread.sleep(01);
            } catch (InterruptedException ex) {
                pause=false;
            } 
       }
    }//pause()
    
    
    
    @Override
    public void run() {
        boolean flag=true;  
        while (flag) { 
            try {
                //sleep for the animation
                
                sleep(delayTime);

                //move the object
                int newX=mySquare.getxAxis();
                if (newX>=(Variables.WIDTH-mySquare.getSize())) {
                    flag=false;
                }else{
                    newX+=5;
                }
                mySquare.setxAxis(newX);
                mySquare.setyAxis(mySquare.getyAxis());
               
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(SquareThreadData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//end run
    
    

    
}//class
