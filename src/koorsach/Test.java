package koorsach;

import koorsach.XMLtest.FReadException;

public class Test extends AbstractDyhotomy {
    FunctionF testF;
    FunctionG testG;
    DyhotomyRoots d;

    Test(FunctionF testF, FunctionG testG){
        this.testF = testF;
        this.testG = testG;
    }
    @Override
    double f(double x) {
        return testF.f(x) - testG.f(x);
    }

    public static void main(String[] args) throws FReadException{
        FunctionF f = new FunctionF(1, 0, 0, 0);
        FunctionG g = new FunctionG(new double[] {3, 0, 1}, new double[] {2, 0.5, 4});
        Test t = new Test(f, g);
        t.d = new DyhotomyRoots();
        try {
			t.d.roots(-10, 10, 0.001, f, g);
			for (int i=0;i<t.d.getSize();i++)
			{
				System.out.println(t.d.getRoots(i));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
