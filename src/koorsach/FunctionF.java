package koorsach;

import static java.lang.Math.pow;

public class FunctionF extends AbstractF {
    private double koef[];

    @Override
	public
	double f(double x) {
        double sum=0;
        for (int i = count() - 1, k = 0; i >= 0; i--, k++)
        {
            sum+= koef[k] * pow(x,i);
        }
        return sum;
    }

    public FunctionF(double... koef){
        this.koef = koef;
    }

    public void setKoef(double... koef){
        this.koef = koef;
    }
    @Override
    public void setA(int i, double a) {
        koef[i] = a;
    }

    @Override
    public double getA(int i) {
        return koef[i];
    }
    
    public double[] getKoef() {
    	return koef;
    }

    @Override
    public int count() {
        return koef.length;
    }

   /* public static void main(String[] args){
        FunctionF test = new FunctionF(3, -2, 1, -4);
        System.out.println(test.dich(0.0001, -10, 10));
    }*/
}
