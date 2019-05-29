/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import domain.Circle;
import domain.Oval;
import domain.Rectangle;
import domain.Square;
import java.util.ArrayList;
import java.util.Collections;
import utility.Variables;

public class RunThreads extends Thread{
    private RectangleThreadData rectangleThread;
    private SquareThreadData squareThreadData;
    private CircleThreadData circleThreadData;
    private OvalThreadData ovalThreadData;
    
    private Object myObject;
    private Rectangle myRectangle;
    private Oval myOval;
    private Square mysquare;
    private Circle myCircle;
    private int speed;
    public boolean pausar;
   
    
    public RunThreads(Object myObject,int speed) {
        this.speed=speed;
        this.myObject=myObject;
       pausar=false;
    }
    
    public void pause(){
        pausar=true;
    }
    
    @Override
    public void run() {
            switch(speed){
            case 250:
                this.mysquare=(Square)this.myObject;
                this.squareThreadData=new SquareThreadData(mysquare, speed);
                this.squareThreadData.start();
                if(pausar) break;    
                break;
            case 450:
                this.myRectangle=(Rectangle)this.myObject;
                this.rectangleThread=new RectangleThreadData(myRectangle, speed);
                this.rectangleThread.start();
                break;
            case 600:
                this.myCircle=(Circle)this.myObject;
                this.circleThreadData=new CircleThreadData(myCircle, speed);
                this.circleThreadData.start();
                break;
            case 800:
                this.myOval=(Oval)this.myObject;
                this.ovalThreadData=new OvalThreadData(myOval, speed);
                this.ovalThreadData.start();
                break;
        }
    }
}
