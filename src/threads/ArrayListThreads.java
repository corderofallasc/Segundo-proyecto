/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import domain.Square;
import java.util.ArrayList;
import java.util.Collections;
import utility.Variables;

public class ArrayListThreads extends Thread{
    private ArrayList<Square> myList;
    private Square mySquare;
    private SquareThreadData squareThread;
    
    public ArrayListThreads(ArrayList<Square> List) {
        this.myList=new ArrayList<>();
        this.myList=List;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < myList.size(); i++) {
            int randomSpeed=(int)(Math.random()*3)+1;
            int speed=0;
            switch(randomSpeed){
                case 1:
                    speed=Variables.HIGH_SPEED;
                    break;
                case 2:
                    speed=Variables.MIDDLE_SPEED;
                    break;
                case 3:
                    speed=Variables.LOW_SPEED;
                    break;
            }
            this.mySquare=myList.get(i);
            this.squareThread=new SquareThreadData(mySquare, speed);
            this.squareThread.start();
        }
    }
}
