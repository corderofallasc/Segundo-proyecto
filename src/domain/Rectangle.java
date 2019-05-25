/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

public class Rectangle {
    public String identification;
    private int xAxis;
    private int yAxis;
    private int width;
    private int height;

    public Rectangle(String identification, int x, int y, int width,int height) {
        this.identification = identification;
        this.xAxis= x;
        this.yAxis= y;
        this.width = width;
        this.height=height;
    }

    public Rectangle() {
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
    
    public String toString(){
        String exit="Identification: "+this.identification+
                "\n XAxis: "+this.xAxis+"\n yAxis: "+this.yAxis;
        return exit;
    }   
}
