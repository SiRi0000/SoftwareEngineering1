package org.hbrs.se1.ws22.uebung10;

public class BoundingBoxFactory {
    public static MyPrettyRectangle createBoundingBox(MyPrettyRectangle[] rectangles) {
        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;

        // Find the minimum and maximum x and y values
        if(rectangles == null)  {
            return null;
        } else if (rectangles.length == 0) {
            return new MyPrettyRectangle(0, 0, 0, 0);
        }
        for (MyPrettyRectangle rectangle : rectangles) {
            if (rectangle.getLeftBottom().getX() < minX) {
                minX = rectangle.getLeftBottom().getX();
            }
            if (rectangle.getLeftBottom().getY() < minY) {
                minY = rectangle.getLeftBottom().getY();
            }
            if (rectangle.getRightTop().getX() > maxX) {
                maxX = rectangle.getRightTop().getX();
            }
            if (rectangle.getRightTop().getY() > maxY) {
                maxY = rectangle.getRightTop().getY();
            }
        }

        return new MyPrettyRectangle(minX, minY, maxX, maxY);
    }
}
