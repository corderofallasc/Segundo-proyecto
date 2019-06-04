/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import domain.Circle;
import domain.Oval;
import domain.Rectangle;
import domain.Square;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import threads.RunThreads;
import threads.SquareThreadData;
import utility.Variables;

/**
 *
 * @author Caro
 */
public class PlayWindow extends JFrame {

    /**
     * Creates new form PlayWindow
     */
    
    
  
    private int speed;
    private int quantity;
    private Rectangle myRectangle;
    private Oval myOval;
    public static Square mysquare;
    private Circle myCircle;
    private boolean startSimulation;
    private RunThreads listThread;
    BufferedImage bufferImage1,bufferImage2,bufferImage3,bufferImage4,bufferImage5,bufferImage6;
    private int flag;
    
    
    public PlayWindow() {
        try {
            initComponents();
            this.setTitle("Speedway");
            ((JPanel)getContentPane()).setOpaque(false);
            ImageIcon uno = new ImageIcon(this.getClass().getResource("/assets/pista5.jpg"));
            JLabel fondo = new JLabel();
            fondo.setIcon(uno);
            getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
            fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());
           
            
            //this.speed=comboSpeed.getSelectedItem();
            this.quantity=1;
            
            this.myCircle= new Circle("circle", 270, 0, 20);
            this.myRectangle=new Rectangle("Rectangle1", 270, 0, 22, 18);
            this.myOval=new Oval("oval", 270, 0, 20, 18);
            this.mysquare=new Square("square", 270, 448, 18);
            this.startSimulation=false;
            
            
            bufferImage1 = ImageIO.read(getClass().getResourceAsStream("/assets/carro1.png"));
            bufferImage2 = ImageIO.read(getClass().getResourceAsStream("/assets/carro2.png"));
            bufferImage3 = ImageIO.read(getClass().getResourceAsStream("/assets/carro3.png"));
            bufferImage4 = ImageIO.read(getClass().getResourceAsStream("/assets/carro4.png"));
            bufferImage5 = ImageIO.read(getClass().getResourceAsStream("/assets/carro5.png"));
            bufferImage6 = ImageIO.read(getClass().getResourceAsStream("/assets/barrier.png"));
            
            
            flag=0;
            jbCreate.setEnabled(false);
            jlBarrier.setEnabled(false);
            rB1.setEnabled(false);
            rB2.setEnabled(false);
            rB3.setEnabled(false);
            rB4.setEnabled(false);
            rB5.setEnabled(false);
            jlSpeed.setEnabled(false);
            jtValue.setEnabled(false);
            jbRevert.setEnabled(false);
            jbInterrupt.setEnabled(false);
            jbSimulation.setEnabled(true);
            comboSpeed.setEnabled(false);
            jcheckImage.setEnabled(false);
            
        } catch (IOException ex) {
            Logger.getLogger(PlayWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//constructor
    
   
    
      @Override
    public void paint(Graphics g){
        super.paint(g);
        int amountX=270;
        int amountY=448;
        
//        if (startSimulation) {
            if (startSimulation) {
              g.fillOval(myCircle.getxAxis(), myCircle.getyAxis(), myCircle.getSize(), myCircle.getSize());
                        this.listThread=new RunThreads(myCircle,speed);
                        listThread.start();
                        startSimulation=false;
          }
              //iterate over all squares
            for (int i = 0; i < quantity; i++) {
                switch(speed){
                    case 250 :
                        g.setColor (Color.blue);
//                        mysquare.setyAxis(amountY);
//                        mysquare.setxAxis(amountX);
                        if(jcheckImage.isSelected())
                            g.drawImage(bufferImage1,mysquare.getxAxis(), mysquare.getyAxis(),null);
                        else
                            
                        //g.drawString(mySquare.getIdentification(),mySquare.getxAxis(),mySquare.getyAxis()+amount-5);
                        g.fillRect(mysquare.getxAxis(), mysquare.getyAxis(), mysquare.getSize(),mysquare.getSize());                     
                        this.listThread=new RunThreads(mysquare,speed);
                        SquareThreadData s=new SquareThreadData(mysquare, speed);
                        s.start();
                        break;
                    case 450:
                        g.setColor (Color.cyan);
                        myRectangle.setyAxis(amountY);
//                        myRectangle.setxAxis(amountX);
                        if(jcheckImage.isSelected())
                            g.drawImage(bufferImage1,myRectangle.getxAxis(), myRectangle.getyAxis(),null);
                        else
                        //g.drawString(mySquare.getIdentification(),mySquare.getxAxis(),mySquare.getyAxis()+amount-5);
                        g.fillRect(myRectangle.getxAxis(), myRectangle.getyAxis(), myRectangle.getWidth(), myRectangle.getHeight());
                        this.listThread=new RunThreads(myRectangle,speed);
                        listThread.start();
                        break;
                    case 600:
                        g.setColor (Color.black);
                        myCircle.setyAxis(amountY);
                        myCircle.setxAxis(amountX);
                        if(jcheckImage.isSelected())
                            g.drawImage(bufferImage1,myCircle.getxAxis(), myCircle.getyAxis(),null);
                        else
                        //g.drawString(mySquare.getIdentification(),mySquare.getxAxis(),mySquare.getyAxis()+amount-5);
                        g.fillOval(myCircle.getxAxis(), myCircle.getyAxis(), myCircle.getSize(), myCircle.getSize());
                        this.listThread=new RunThreads(myCircle,speed);
                        listThread.start();
                        break;
                    case 800:
                        g.setColor (Color.gray);
                        myOval.setyAxis(amountY);
                        myOval.setxAxis(amountX);
                        if(jcheckImage.isSelected())
                            g.drawImage(bufferImage1,myOval.getxAxis(), myOval.getyAxis(),null);
                        else
                        //g.drawString(mySquare.getIdentification(),mySquare.getxAxis(),mySquare.getyAxis()+amount-5);
                        g.fillOval(myOval.getxAxis(), myOval.getyAxis(), myOval.getSizeX(), myOval.getSizeY());
                        this.listThread=new RunThreads(myOval,speed);
                        listThread.start();
                        break;
                }
                if (amountX<=170) {
                    amountX=270;
                } else {
                    amountX-=20;
                }
                
                if (amountY>=568) {
                    amountY=448;
                } else {
                    amountY+=23;
                }
            } //end for
//          }//if starSimulation
        
        if(rB1.isSelected()){
            g.drawImage(bufferImage6,410,118,null);
            SquareThreadData.barrier=true;
        }if(rB2.isSelected()){
            g.drawImage(bufferImage6,410,96,null);
            
        }if(rB3.isSelected()){
            g.drawImage(bufferImage6,410,74,null);
        }if(rB4.isSelected()){
            g.drawImage(bufferImage6,410,52,null);
        }if(rB5.isSelected()){
            g.drawImage(bufferImage6,410,30,null);
            
        }
    }//paint
    
    
    public void paintAgain(){
        repaint();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        jbCreate = new javax.swing.JButton();
        jtValue = new javax.swing.JTextField();
        jlSpeed = new javax.swing.JLabel();
        comboSpeed = new javax.swing.JComboBox<>();
        jbInterrupt = new javax.swing.JButton();
        jbSimulation = new javax.swing.JButton();
        jbRevert = new javax.swing.JButton();
        jcheckImage = new javax.swing.JCheckBox();
        rB1 = new javax.swing.JRadioButton();
        rB2 = new javax.swing.JRadioButton();
        rB3 = new javax.swing.JRadioButton();
        rB4 = new javax.swing.JRadioButton();
        rB5 = new javax.swing.JRadioButton();
        jlBarrier = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/create.png"))); // NOI18N
        jbCreate.setBorder(null);
        jbCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCreateActionPerformed(evt);
            }
        });

        jtValue.setBackground(new java.awt.Color(0, 204, 0));
        jtValue.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jtValue.setForeground(new java.awt.Color(255, 255, 255));
        jtValue.setText("Value");
        jtValue.setBorder(null);

        jlSpeed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/speed.jpg"))); // NOI18N

        comboSpeed.setBackground(new java.awt.Color(0, 204, 51));
        comboSpeed.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        comboSpeed.setForeground(new java.awt.Color(255, 255, 255));
        comboSpeed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "High Speed", "Middle Speed", "Middle Low Speed", "Low Speed" }));
        comboSpeed.setBorder(null);

        jbInterrupt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/interrupt1.jpg"))); // NOI18N
        jbInterrupt.setBorder(null);
        jbInterrupt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInterruptActionPerformed(evt);
            }
        });

        jbSimulation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/simulation1.jpg"))); // NOI18N
        jbSimulation.setBorder(null);
        jbSimulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSimulationActionPerformed(evt);
            }
        });

        jbRevert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/revert1.jpg"))); // NOI18N
        jbRevert.setBorder(null);

        jcheckImage.setBackground(new java.awt.Color(0, 204, 0));
        jcheckImage.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jcheckImage.setForeground(new java.awt.Color(255, 255, 255));
        jcheckImage.setText("Image");
        jcheckImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcheckImageActionPerformed(evt);
            }
        });

        rB1.setBackground(new java.awt.Color(0, 204, 0));
        rB1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rB1.setForeground(new java.awt.Color(255, 255, 255));
        rB1.setText("Rail 1");

        rB2.setBackground(new java.awt.Color(0, 204, 0));
        rB2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rB2.setForeground(new java.awt.Color(255, 255, 255));
        rB2.setText("Rail 2");

        rB3.setBackground(new java.awt.Color(0, 204, 0));
        rB3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rB3.setForeground(new java.awt.Color(255, 255, 255));
        rB3.setText("Rail 3");

        rB4.setBackground(new java.awt.Color(0, 204, 0));
        rB4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rB4.setForeground(new java.awt.Color(255, 255, 255));
        rB4.setText("Rail 4");

        rB5.setBackground(new java.awt.Color(0, 204, 0));
        rB5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rB5.setForeground(new java.awt.Color(255, 255, 255));
        rB5.setText("Rail 5");

        jlBarrier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/barrier1.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcheckImage, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jbCreate)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jlSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(comboSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(jlBarrier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rB1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rB5)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(rB3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rB4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rB2)))
                        .addGap(31, 31, 31)
                        .addComponent(jbRevert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbInterrupt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbSimulation)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(551, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jcheckImage)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(rB1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rB2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rB3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rB4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rB5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbInterrupt)
                            .addComponent(jbRevert)
                            .addComponent(jbSimulation))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlBarrier, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jbCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void validarBoton(Graphics g){
        if(rB1.isSelected())
            g.drawLine(250,250,300,300);
        
    }
    
    
    private void jcheckImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcheckImageActionPerformed
          
//        jbCreate.setEnabled(true);
//        jlBarrier.setEnabled(true);
//        rB1.setEnabled(true);
//        rB2.setEnabled(true);
//        rB3.setEnabled(true);
//        rB4.setEnabled(true);
//        rB5.setEnabled(true);
//        jlSpeed.setEnabled(true);
//        jtValue.setEnabled(true);
//        jbRevert.setEnabled(true);
//        jbInterrupt.setEnabled(true);
//        jbSimulation.setEnabled(true);
//        comboSpeed.setEnabled(true);
    }//GEN-LAST:event_jcheckImageActionPerformed

    private void jbCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCreateActionPerformed
        quantity=Integer.parseInt(jtValue.getText());
        String selectedItem = (String)comboSpeed.getSelectedItem();
        if ("High Speed".equals(selectedItem)) {
            this.speed=Variables.HIGH_SPEED;
        }else if("Middle Speed".equals(selectedItem)){
            this.speed=Variables.MIDDLE_SPEED;
        }else if("Middle Low Speed".equals(selectedItem)){
            this.speed=Variables.MIDDLE_LOW_SPEED;
        }else if("Low Speed".equals(selectedItem)){
            this.speed=Variables.LOW_SPEED;
        }
        this.startSimulation=true;
        jtValue.setText("");
    }//GEN-LAST:event_jbCreateActionPerformed

    private void jbInterruptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInterruptActionPerformed
       
       SquareThreadData s= new SquareThreadData(mysquare, quantity);
       s.end=true;
       if(flag!=0)
           s.run();
       else{
       s.pause();
       s.end=false;
       flag=1;
       }
      
        
    }//GEN-LAST:event_jbInterruptActionPerformed

    private void jbSimulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSimulationActionPerformed
        jbCreate.setEnabled(true);
        jlBarrier.setEnabled(true);
        rB1.setEnabled(true);
        rB2.setEnabled(true);
        rB3.setEnabled(true);
        rB4.setEnabled(true);
        rB5.setEnabled(true);
        jlSpeed.setEnabled(true);
        jtValue.setEnabled(true);
        jbRevert.setEnabled(true);
        jbInterrupt.setEnabled(true);
        comboSpeed.setEnabled(true);
        jcheckImage.setEnabled(true);
        listThread=new RunThreads(myOval, 800);
        startSimulation=true;
    }//GEN-LAST:event_jbSimulationActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PlayWindow().setVisible(true);
//            }
//        });
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PlayWindow().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.JComboBox<String> comboSpeed;
    private javax.swing.JButton jbCreate;
    private javax.swing.JButton jbInterrupt;
    private javax.swing.JButton jbRevert;
    private javax.swing.JButton jbSimulation;
    private javax.swing.JCheckBox jcheckImage;
    private javax.swing.JLabel jlBarrier;
    private javax.swing.JLabel jlSpeed;
    private javax.swing.JTextField jtValue;
    private javax.swing.JRadioButton rB1;
    private javax.swing.JRadioButton rB2;
    private javax.swing.JRadioButton rB3;
    private javax.swing.JRadioButton rB4;
    private javax.swing.JRadioButton rB5;
    // End of variables declaration//GEN-END:variables
}
