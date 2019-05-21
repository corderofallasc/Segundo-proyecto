/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

public class ovalRectangle {
    public String identification;
    private int xAxis;
    private int yAxis;
    private int width;
    private int height;
    private int arcWidth;
    private int arcHeight;
//    private int speed;

    public ovalRectangle(String identification, int x, int y, int width, int height, int arcWidth,int arcHeight) {
        this.identification = identification;
        this.xAxis= x;
        this.yAxis= y;
        this.width = width;
        this.height = height;
        this.arcWidth=arcWidth;
        this.arcHeight=arcHeight;
//        this.speed=speed;
    }

    public ovalRectangle() {
    }
    

    /**
     * @return the pointPosition
     */
//    public Point getPointPosition() {
//        return pointPosition;
//    }
//
//    /**
//     * @param pointPosition the pointPosition to set
//     */
//    public void setPointPosition(Point pointPosition) {
//        this.pointPosition = pointPosition;
//    }

    

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
    
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArcWidth() {
        return arcWidth;
    }

    public void setArcWidth(int arcWidth) {
        this.arcWidth = arcWidth;
    }

    public int getArcHeight() {
        return arcHeight;
    }

    public void setArcHeight(int arcHeight) {
        this.arcHeight = arcHeight;
    }
    
    
//    public int getSpeed() {
//        return speed;
//    }
//
//    public void setSpeed(int speed) {
//        this.speed = speed;
//    }
    
    
  public String toString(){
      String exit="Identification: "+this.identification+
              "\n XAxis: "+this.xAxis+"\n yAxis: "+this.yAxis;
      return exit;
  }   
}
