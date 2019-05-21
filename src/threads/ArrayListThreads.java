/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import domain.Circle;
import domain.Rectangle;
import domain.Square;
import domain.ovalRectangle;
import java.util.ArrayList;
import java.util.Collections;
import utility.Variables;

public class ArrayListThreads extends Thread{
    private ArrayList<Square> myList;
//    private Square mySquare;
    private SquareThreadData squareThread;
    private ovalRectangleThreadData triangleThread;
    private CircleThreadData circleThread;
    private RectangleThreadData rectangleThread;
    private Square mySquare;
    private ovalRectangle myOvalRectangle;
    private Rectangle myRectangle;
    private Circle myCircle;
    private Object myObject;
    private int speed;
    
//    public ArrayListThreads(ArrayList<Square> List) {
//        this.myList=new ArrayList<>();
//        this.myList=List;
//    }
    public ArrayListThreads(Object myObject,int speed) {
        this.speed=speed;
        this.myObject=myObject;
    }
    
    public void cast(Object object){
        switch(speed){
            case 250:
                this.mySquare=(Square)object;
                break;
            case 450:
                this.myObject=(ovalRectangle)object;
                break;
            case 600:
                this.myObject=(Circle)object;
                break;
            case 800:
                this.myObject=(Rectangle)object;
                break;
        }
    }
    
    @Override
    public void run() {
//        for (int i = 0; i < myList.size(); i++) {
//            int randomSpeed=(int)(Math.random()*3)+1;
//            int speed=0;
//            switch(randomSpeed){
//                case 1:
//                    speed=Variables.HIGH_SPEED;
//                    break;
//                case 2:
//                    speed=Variables.MIDDLE_SPEED;
//                    break;
//                case 3:
//                    speed=Variables.LOW_SPEED;
//                    break;
//            }
//            this.myObject=myList.get(i);
//            this.squareThread=new SquareThreadData(myObject, speed);
//            this.squareThread.start();
            switch(speed){
            case 250:
                this.mySquare=(Square)this.myObject;
                this.squareThread=new SquareThreadData(mySquare, speed);
                this.squareThread.start();
                break;
            case 450:
                this.myOvalRectangle=(ovalRectangle)this.myObject;
                this.triangleThread=new ovalRectangleThreadData(myOvalRectangle, speed);
                this.triangleThread.start();
                break;
            case 600:
                this.myCircle=(Circle)myObject;
                this.circleThread=new CircleThreadData(myCircle, speed);
                this.circleThread.start();
                break;
            case 800:
                this.myRectangle=(Rectangle)this.myRectangle;
                this.rectangleThread=new RectangleThreadData(myRectangle, speed);
                this.rectangleThread.start();
                break;
        }
//        }
    }
}
