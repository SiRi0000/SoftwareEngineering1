package org.hbrs.se1.ws22.uebung10;

public class MyPoint {
        private double x;
        private double y;

        public MyPoint(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof MyPoint)) {
                return false;
            }
            MyPoint other = (MyPoint) o;
            return this.x == other.x && this.y == other.y;
        }

        public String toString(){
            return "(" + this.x + "," + this.y + ")";
        }
}
