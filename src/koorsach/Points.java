package koorsach;

public class Points {
    private double x;
    private  double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Points (double x, double y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof  Points)) return false;
        Points point = (Points) obj;
        if (Double.compare(point.x, x) != 0) return false;
        if (Double.compare(point.y, y) != 0) return false;

        return true;
    }

    @Override
    public String toString(){
        return "Point{" + "x=" + getX() + " y= " + getY() +"}";
    }
}

