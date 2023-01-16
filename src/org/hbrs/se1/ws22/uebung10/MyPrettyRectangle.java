package org.hbrs.se1.ws22.uebung10;

public class MyPrettyRectangle {
    // x1,y1: Punkt links unten
    // x2,y2: Punkt rechts oben


    private MyPoint leftBottom;
    private MyPoint rightTop;

    public MyPrettyRectangle(double x1, double y1, double x2, double y2) {
        this.leftBottom = new MyPoint(x1, y1);
        this.rightTop = new MyPoint(x2, y2);
    }

    public boolean contains(MyPrettyRectangle other) {
        return this.leftBottom.getX() <= other.leftBottom.getX() &&
                this.leftBottom.getY() <= other.leftBottom.getY() &&
                this.rightTop.getX() >= other.rightTop.getX() &&
                this.rightTop.getY() >= other.rightTop.getY();
    }
    public MyPoint getLeftBottom() {
        return leftBottom;
    }

    public MyPoint getRightTop() {
        return rightTop;
    }
    public MyPoint getCenter(){
        return new MyPoint((this.leftBottom.getX() + this.rightTop.getX()) / 2, (this.leftBottom.getY() + this.rightTop.getY()) / 2);
    }

    public double getArea(){
        return (this.rightTop.getX() - this.leftBottom.getX()) * (this.rightTop.getY() - this.leftBottom.getY());
    }

    public double getPerimeter(){
        return 2 * (this.rightTop.getX() - this.leftBottom.getX()) + 2 * (this.rightTop.getY() - this.leftBottom.getY());
    }

    public String toString(){
        return "MyPrettyRectangle: " + this.leftBottom + " - " + this.rightTop;
    }

}
