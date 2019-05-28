/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hernandezcorderosegundop;

import data.XMLRectangle;
import domain.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jdom.JDOMException;
import threads.RunThreads;
import threads.RepaintLandThread;
import utility.Variables;
import visual.LandFrame;
import visual.PlayWindow;

public class HernandezCorderoSegundoP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            ArrayList<Rectangle> squareList=new ArrayList<>();
            XMLRectangle dataSquare=new XMLRectangle(Variables.PATH);
            squareList=dataSquare.getAllRectangles();
            
            Rectangle square1 = new Rectangle("Rectangle1", 0, 0, 80, 30);
//            Square square2 = new Square("Square2", 0, 115,50, 30);
//            Square square3 = new Square("Square3", 0, 180, 50, 30);
            
            dataSquare.insertRectangles(square1);
//            dataSquare.insertSquare(square2);
//            dataSquare.insertSquare(square3);
            
            PlayWindow pw= new PlayWindow();
            pw.setVisible(true);

//            LandFrame myLand = new LandFrame(square1,6,450);
//            myLand.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            RepaintLandThread repaintThread = new RepaintLandThread(pw, 200);
            repaintThread.start();
            
//            ArrayListThreads listThread=new ArrayListThreads(squareList);
//            listThread.start();
//            RunThreads listThread=new RunThreads(square1,250);
//            listThread.start();
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(HernandezCorderoSegundoP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JDOMException ex) {
            Logger.getLogger(HernandezCorderoSegundoP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
