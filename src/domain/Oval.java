/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

public class Oval {
    public String identification;
    private int xAxis;
    private int yAxis;
    private int sizeX;
    private int sizeY;

    public Oval(String identification, int x, int y, int sizeX, int sizeY) {
        this.identification = identification;
        this.xAxis= x;
        this.yAxis= y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
//        this.speed=speed;
    }

    public Oval() {
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
    
    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }
    
    
    
  public String toString(){
      String exit="Identification: "+this.identification+
              "\n XAxis: "+this.xAxis+"\n yAxis: "+this.yAxis;
      return exit;
  }   
}
