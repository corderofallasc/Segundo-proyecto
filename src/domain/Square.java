/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

public class Square {
    public String identification;
    private int xAxis;
    private int yAxis;
    private int size;
//    private int speed;

    public Square(String identification, int x, int y, int size) {
        this.identification = identification;
        this.xAxis= x;
        this.yAxis= y;
        this.size = size;
//        this.speed=speed;
    }

    public Square() {
    }
    

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public int getxAxis() {
        return xAxis;
    }

    public void setxAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }

    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
  public String toString(){
      String exit="Identification: "+this.identification+
              "\n XAxis: "+this.xAxis+"\n yAxis: "+this.yAxis;
      return exit;
  }   
}
