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
import utility.Variables;

/**
 *
 * @author Caro
 */
public class PlayWindow extends JFrame {

    /**
     * Creates new form PlayWindow
     */
    
    
    private Font font, fontDos;
    private int speed;
    private int quantity;
    private Rectangle myRectangle;
    private Oval myOval;
    private Square mysquare;
    private Circle myCircle;
    private boolean startSimulation;
    private RunThreads listThread;
    BufferedImage bufferImage1,bufferImage2,bufferImage3,bufferImage4,bufferImage5;
    
    
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
            this.font = new Font("Century gothic", Font.BOLD, 14);
            this.fontDos = new Font("Century gothic", Font.BOLD, 15);
            
            this.speed=Variables.HIGH_SPEED;
            this.quantity=1;
            
            this.myCircle= new Circle("circle", 0, 0, 20);
            this.myRectangle=new Rectangle("Rectangle1", 0, 0, 80, 30);
            this.myOval=new Oval("oval", 0, 0, 20, 35);
            this.mysquare=new Square("square", 0, 0, 30);
            this.startSimulation=false;
            
            
            bufferImage1 = ImageIO.read(getClass().getResourceAsStream("/assets/carro1.png"));
            bufferImage2 = ImageIO.read(getClass().getResourceAsStream("/assets/carro2.png"));
            bufferImage3 = ImageIO.read(getClass().getResourceAsStream("/assets/carro3.png"));
            bufferImage4 = ImageIO.read(getClass().getResourceAsStream("/assets/carro4.png"));
            bufferImage5 = ImageIO.read(getClass().getResourceAsStream("/assets/carro5.png"));
        } catch (IOException ex) {
            Logger.getLogger(PlayWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
      @Override
    public void paint(Graphics g){
        super.paint(g);
        int amount=70;
        if (startSimulation) {
              //iterate over all squares
            for (int i = 0; i < quantity; i++) {
                switch(speed){
                    case 250:
                        g.setColor (Color.blue);
                        mysquare.setyAxis(amount);
                        if(jcheckImage.isSelected())
                            g.drawImage(bufferImage1,mysquare.getxAxis(), mysquare.getyAxis(),null);
                        else
                        //g.drawString(mySquare.getIdentification(),mySquare.getxAxis(),mySquare.getyAxis()+amount-5);
                        g.fillRect(mysquare.getxAxis(), mysquare.getyAxis(), mysquare.getSize(),mysquare.getSize());
                        this.listThread=new RunThreads(mysquare,speed);
                        listThread.start();
                        break;
                    case 450:
                        g.setColor (Color.cyan);
                        myRectangle.setyAxis(amount);
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
                        myCircle.setyAxis(amount);
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
                        myOval.setyAxis(amount);
                        if(jcheckImage.isSelected())
                            g.drawImage(bufferImage1,myOval.getxAxis(), myOval.getyAxis(),null);
                        else
                        //g.drawString(mySquare.getIdentification(),mySquare.getxAxis(),mySquare.getyAxis()+amount-5);
                        g.fillOval(myOval.getxAxis(), myOval.getyAxis(), myOval.getSizeX(), myOval.getSizeY());
                        break;
                }
                if (amount>=420) {
                    amount=0;
                } else {
                    amount+=70;
                }
            } //end for
          }
            
        }
    
    
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

        jbCreate = new javax.swing.JButton();
        jtValue = new javax.swing.JTextField();
        jlSpeed = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jbBarrier = new javax.swing.JButton();
        jbInterrupt = new javax.swing.JButton();
        jbSimulation = new javax.swing.JButton();
        jbRevert = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jcheckImage = new javax.swing.JCheckBox();

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

        jComboBox1.setBackground(new java.awt.Color(0, 204, 51));
        jComboBox1.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "High Speed", "Middle Speed", "Middle Low Speed", "Low Speed" }));
        jComboBox1.setBorder(null);

        jbBarrier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/barrier1.jpg"))); // NOI18N
        jbBarrier.setBorder(null);
        jbBarrier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBarrierActionPerformed(evt);
            }
        });

        jbInterrupt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/interrupt1.jpg"))); // NOI18N
        jbInterrupt.setBorder(null);

        jbSimulation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/simulation1.jpg"))); // NOI18N
        jbSimulation.setBorder(null);

        jbRevert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/revert1.jpg"))); // NOI18N
        jbRevert.setBorder(null);

        jTextField1.setBackground(new java.awt.Color(0, 204, 51));
        jTextField1.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(null);

        jcheckImage.setBackground(new java.awt.Color(0, 204, 0));
        jcheckImage.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jcheckImage.setForeground(new java.awt.Color(255, 255, 255));
        jcheckImage.setText("Image");
        jcheckImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcheckImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbCreate)
                    .addComponent(jtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, 0, 1, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbBarrier)
                        .addGap(28, 28, 28)
                        .addComponent(jbRevert)
                        .addGap(18, 18, 18)
                        .addComponent(jbInterrupt)
                        .addGap(18, 18, 18)
                        .addComponent(jbSimulation)
                        .addGap(18, 18, 18)
                        .addComponent(jcheckImage, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(535, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jTextField1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jbCreate)
                        .addComponent(jbSimulation))
                    .addComponent(jlSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBarrier)
                    .addComponent(jbRevert)
                    .addComponent(jbInterrupt)
                    .addComponent(jcheckImage))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBarrierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBarrierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbBarrierActionPerformed

    private void jcheckImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcheckImageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcheckImageActionPerformed

    private void jbCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCreateActionPerformed
        quantity=Integer.parseInt(jtValue.getText());
        String selectedItem = (String)jComboBox1.getSelectedItem();
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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbBarrier;
    private javax.swing.JButton jbCreate;
    private javax.swing.JButton jbInterrupt;
    private javax.swing.JButton jbRevert;
    private javax.swing.JButton jbSimulation;
    private javax.swing.JCheckBox jcheckImage;
    private javax.swing.JLabel jlSpeed;
    private javax.swing.JTextField jtValue;
    // End of variables declaration//GEN-END:variables
}
