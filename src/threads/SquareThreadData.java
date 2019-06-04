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
import visual.PlayWindow;

public class SquareThreadData extends Thread{
    
    //variables
    public static Square mySquare;
    private int delayTime;
    public boolean end;
    public static boolean barrier;
    private int move;
    private int newX;
    private int newY;
    private boolean rigth;
    private boolean left;
    private boolean up;
    private boolean down;
    
    public SquareThreadData(Square mySquare, int delayTime) {
        super(mySquare.identification);
        this.mySquare =new Square("square", 270, 448, 18);
        this.delayTime = 15;
        this.end= false;
        this.move=1;
        this.newX=PlayWindow.mysquare.getxAxis();
        this.newY=mySquare.getyAxis();
        this.rigth=true;
        this.left=false;
        this.up=false;
        this.down=false;
        this.barrier=false;
    }
    
    
    public void pause(){
       //pause=true;
       while (end == true) {
         try {
            Thread.sleep(01);
            } catch (InterruptedException ex) {
                end=false;
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
                if (newX>=(Variables.WIDTH-mySquare.getSize())) {
                    flag=false;
                }else{
//                    System.out.println(move);
//                    if (move%2==0) {
//                        moveY();
//                    } else {
//                        moveX();
//                    }
                    
                    if (rigth) {
                        if(newX>=270 && newX<690){
                            newX+=1;
                            PlayWindow.mysquare.setxAxis(newX);
                        }else{
//                            down=true;
                            up=true;
                            rigth=false;
                            
                        }
                    }
                    if (up) {
                        if(newY<=448 && newY>122){
                            newY-=1;
                            PlayWindow.mysquare.setyAxis(newY);
                        }else{
//                            rigth=true;
                            up=false;
                            left=true;
                            
                        }
                    }
                    if (left) {
                        boolean finish=true;
                        while (finish) { 
                            if (newX>=270) {
                                if (newX==410 &&barrier==true) {
                                    finish=false;
                                }else{
                                    newX-=1;
                                    PlayWindow.mysquare.setxAxis(newX);
                                }
                                
                            }else{
                                finish=false;
                                left=false;
                                down=true;
                            }
//                            Thread.sleep(100);
                        }
                    }
                    if (down) {
                        if (newY<=448)  {
                            down=false;
                        }
                        else {
                            newY+=1;
                            PlayWindow.mysquare.setyAxis(newY);
//                            System.out.println(newX+"down"+newY);
                        }
                    }
                    
//                    if (newX<=690 && newX>=270) {
//                        newX-=1;
//                        PlayWindow.mysquare.setxAxis(newX);
//                    }
                            
                }
//                switch(move){
//                    case 1:
//                        if (newX<=608) {
////                            newY-=5;
////                            mySquare.setyAxis(newY);
//                        } else {
////                            newX+=5;
////                            mySquare.setxAxis(newX);
//                            newY-=5;
//                            mySquare.setyAxis(newY);
//                        }
//                            
//                            
////                        for (int i = 185; i < 448; i++) {
////                            newY-=5;
////                            mySquare.setyAxis(i);
////                        }
////                        move=2;
//                        break;
//                    case 2:
//                        for (int i = 185; i < 448; i++) {
//                            newY-=5;
//                            mySquare.setyAxis(i);
//                        }
//                        for (int j = 608; j < 700; j++) {
//                            newX+=5;
//                            mySquare.setxAxis(newX);
//                        }
//                        break;
//                }
//                if (newX>=170 && newX<=608) {
//                    for (int j = 270; j < 608; j++) {
//                        newX+=5;
//                        mySquare.setxAxis(newX);
//                    }
//                    for (int i = 185; i < 448; i++) {
//                        newY-=5;
//                        mySquare.setyAxis(newY);
//                    }
            } catch (InterruptedException ex) {
                Logger.getLogger(SquareThreadData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//end run

    public void moveY(){
        if (move==2) {
            if (newY==122) {
                move=3;
            } else {
                newY-=1;
                PlayWindow.mysquare.setyAxis(newY);
            }
            
            
        }else if(move==4){
            if (newY>=448) {
                move=1;
                end=true;
            }else{
                newY+=1;
                PlayWindow.mysquare.setyAxis(newY);
            }
        }
    }
    public void moveX(){
        if (move==1) {
            if (!end) {
                if (newX==690) {
                    move=2;
                }else{
                    newX+=1;
                    PlayWindow.mysquare.setxAxis(newX);
                }
            } else {
                if (newX<=Variables.WIDTH-mySquare.getSize()) {
                    newX+=1;
                    PlayWindow.mysquare.setxAxis(newX);
                }
                end=false;
            }
//            newX+=1;
//            mySquare.setxAxis(newX);
//            move=2;
        }else if(move==3){
            if (newX==270) {
                move=4;
            } else {
                newX-=1;
                PlayWindow.mysquare.setxAxis(newX);
            }
        }
    }
    
}//class
