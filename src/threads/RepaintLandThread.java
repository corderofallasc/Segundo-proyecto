/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threads;

import java.util.logging.Level;
import java.util.logging.Logger;
import visual.LandFrame;
import visual.PlayWindow;

public class RepaintLandThread extends Thread{
    
    //variables
    private PlayWindow playWindow;
    private int paintTime;
    
    public RepaintLandThread(PlayWindow playWindow, int paintTime){
        this.playWindow = playWindow;
        this.paintTime = paintTime;
    }
    
    @Override
    public void run(){
        while(true){
            
            try {
                //sleep until next repaint
                this.sleep(paintTime);
                playWindow.paintAgain();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(RepaintLandThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }//end while
    }//end run
}
