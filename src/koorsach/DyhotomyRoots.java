package koorsach;

import java.util.ArrayList;
import java.util.List;

public class DyhotomyRoots extends AbstractDyhotomy{
	
	 private List<Double> roots = new ArrayList<>();
	   
	    public void addRoot(double root){
	        roots.add(root);
	    }
	    public  double getRoots(int index){
	        return roots.get(index);
	    }
	    public int getSize(){
	        return roots.size();
	    }
	    public void clear(){
	        roots.clear();
	    }
	    public void roots(double a, double b, double exp,FunctionF f,FunctionG g) throws  IntervalException{
	        if (a>b || exp<=0 || Math.abs(a - b) == 0)
	        {
	            throw new IntervalException("Error! left border less than right or step less than 0 . Check the data");
	        }
	        double h=(b-a)/1000;
	        for (double i =a; i <= b; i+=h)
	        {
	        	if ((f.f(i)-g.f(i))*(f.f(i+h)-g.f(i+h)) <= 0) {
	        		try {
						addRoot(solveDich(i,i+h,exp,f,g));
					} catch (Exception e) {
						e.printStackTrace();
					}
	        	}
	            
	        }
	    }

	@Override
	double f(double x) {
		
		return 0.0;
	}

}
