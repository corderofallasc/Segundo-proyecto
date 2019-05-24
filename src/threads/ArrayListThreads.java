/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import domain.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import utility.Variables;

public class ArrayListThreads extends Thread{
    private ArrayList<Rectangle> myList;
    private SquareThreadData squareThread;
    private Rectangle mySquare;
    private int speed;
    
//    public ArrayListThreads(ArrayList<Square> List) {
//        this.myList=new ArrayList<>();
//        this.myList=List;
//    }
    public ArrayListThreads(Rectangle mySquare,int speed) {
        this.speed=speed;
        this.mySquare=mySquare;
    }
    
    @Override
    public void run() {
            switch(speed){
            case 250:
                this.mySquare=(Rectangle)this.mySquare;
                this.squareThread=new SquareThreadData(mySquare, speed);
                this.squareThread.start();
                break;
            case 450:
                this.mySquare=(Rectangle)this.mySquare;
                this.squareThread=new SquareThreadData(mySquare, speed);
                this.squareThread.start();
                break;
            case 600:
                this.mySquare=(Rectangle)this.mySquare;
                this.squareThread=new SquareThreadData(mySquare, speed);
                this.squareThread.start();
                break;
            case 800:
                this.mySquare=(Rectangle)this.mySquare;
                this.squareThread=new SquareThreadData(mySquare, speed);
                this.squareThread.start();
                break;
        }
    }
}
