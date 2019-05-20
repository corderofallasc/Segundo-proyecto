/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hernandezcorderosegundop;

import data.XMLSquare;
import domain.Square;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jdom.JDOMException;
import threads.ArrayListThreads;
import threads.RepaintLandThread;
import utility.Variables;
import visual.LandFrame;

public class HernandezCorderoSegundoP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            ArrayList<Square> squareList=new ArrayList<>();
            XMLSquare dataSquare=new XMLSquare(Variables.PATH);
            squareList=dataSquare.getAllSquares();
            
            Square square1 = new Square("Square1",0,415,50);
            Square square2 = new Square("Square2", 0, 315,50);
            Square square3 = new Square("Square3", 0, 380, 50);
            
            dataSquare.insertSquare(square1);
            dataSquare.insertSquare(square2);
            dataSquare.insertSquare(square3);
            
            LandFrame myLand = new LandFrame(squareList);
            myLand.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            RepaintLandThread repaintThread = new RepaintLandThread(myLand, 200);
            repaintThread.start();
            
            ArrayListThreads listThread=new ArrayListThreads(squareList);
            listThread.start();
        } catch (IOException ex) {
            Logger.getLogger(HernandezCorderoSegundoP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JDOMException ex) {
            Logger.getLogger(HernandezCorderoSegundoP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
