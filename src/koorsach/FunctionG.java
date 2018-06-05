package koorsach;

public class FunctionG extends AbstractG {
    double[] pX;
    double[] pY;

    public FunctionG() {}
    
    public FunctionG(double[] pX, double[] pY){

        if(pX.length != pY.length){
            throw new IllegalArgumentException("Wrong data");
        }
        this.pX = pX;
        this.pY = pY;
    }


    @Override
    public double getX(int i) {
        return pX[i];
    }

    @Override
    public double getY(int i) {
        return pY[i];
    }

    @Override
    public void setY(int i, double y) {
        this.pY[i] = y;
    }
    
    public void setY(double[] pY) {
    	this.pY = pY;
    }

    @Override
    public void setX(int i, double x) {
        this.pX[i] = x;
    }
    
    public void setX(double[] pX) {
    	this.pX = pX;
    }
    
    public double[] getX() {
    	return pX;
    }
    
    public double[] getY() {
    	return pY;
    }

    @Override
    public int count() {
        return pX.length;
    }


    @Override
	public
    double f(double x) {
        double P = 0;
        for (int i = 0; i < count(); i++)
        {
            double li = 1;
            for (int j = 0; j < count(); j++) {
                if (i != j)
                    li *= (x - getX(j)) / (getX(i) - getX(j));
            }
            P += getY(i) * li;
        }
        return P;
    }

    public void sortXY() {
        double temp;
        for (int i = 0; i < count() - 1; i++)
            for (int j = i; j < count(); j++) {
                if (pX[j] < pX[i]) {
                    temp = pX[i];
                    pX[i] = pX[j];
                    pX[j] = temp;
                    temp = pY[i];
                    pY[i] = pY[j];
                    pY[j] = temp;
                }
            }
    }

    public static void main(String[] args){
        FunctionG test = new FunctionG(new double[] {-3, 4, -3, 2.2}, new double[] {6, 1, 1, 1.5});
        test.sortXY();
 //       System.out.println(test.dich(0.001, -10, 10));
    }
}
