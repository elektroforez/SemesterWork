package koorsach;

public abstract class AbstractDyhotomy {
    abstract double f(double x);

    public double  solveDich(double a, double b,double eps, FunctionF f,FunctionG g) throws IntervalException{
        //double c;
        double x=(a+b)/2;
        if (a>b || eps<=0)
        {
            throw new IntervalException("Error! left border less than right or step less than 0 . Check the data");
        }
        while(Math.abs(b-a)>eps){

            if((f.f(a)-g.f(a))*(f.f(x)-g.f(x))>0){
                a=x;
            }
            else {
                b=x;
            }
            x=(a+b)/2;

        	}
        return x;
    }
    
}
