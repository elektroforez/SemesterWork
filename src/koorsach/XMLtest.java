package koorsach;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.xml.bind.*;
import XMLgener.EquationData;

public class XMLtest {
	private EquationData data;
	double [] array ;
	double [] arr1;
	double [] arr2;
	public FunctionF f = new FunctionF();
	public FunctionG g = new FunctionG();
	
	public XMLtest(FunctionF f, FunctionG g) {
		this.f = f;
		this.g = g;
	}
	
	public XMLtest() {}
	
	public double[] getArray() { return array;}
	public double[] getArr1() { return arr1;}
	public double[] getArr2() { return arr2;}
	
	public void setArray(double[] array) {this.array = array;}
	public void setArr1(double[] arr1) {this.arr1 = arr1;}
	public void setArr2(double[] arr2) {this.arr2 = arr2;}
	
	@SuppressWarnings("serial")

    public static class FileException extends Exception{
        private String fileName;
        public FileException(String fileName){
            this.fileName=fileName;
        }
        public String getFileName(){
            return fileName;
        }
    }
    @SuppressWarnings("serial")
    public static  class FReadException extends FileException{
        public FReadException(String fileName) {
            super(fileName);
        }
    }
    @SuppressWarnings("serial")
    public static class FWriteException extends FileException{
        public FWriteException(String fileName){
            super(fileName);
        }
    }
    public XMLtest readFromXML(String fileName)throws FReadException{
        try{
            JAXBContext jaxbContext=JAXBContext.newInstance("XMLgener");
            Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
             data=(EquationData)unmarshaller.unmarshal(new FileInputStream(fileName));
             array=new double [data.getACoefs().getACoef().size()];
             for (int i=0;i<array.length;i++)
             {
            	 array[i]=data.getACoefs().getACoef().get(i).getX();
             }
            arr1 = new double [data.getXYCoefs().getXYCoef().size()];
            arr2 = new double [data.getXYCoefs().getXYCoef().size()];
            for (int i =0; i < arr1.length; i++) {
                arr1[i] = data.getXYCoefs().getXYCoef().get(i).getX();
                arr2[i] = data.getXYCoefs().getXYCoef().get(i).getY();
            }
            if (arr1.length==1) {
            	throw new IllegalArgumentException("Only one Point is given. It's very very bad=(");
            }
           f = new FunctionF(array);
           g = new FunctionG(arr1, arr2);
        }
        catch(FileNotFoundException | JAXBException e){
            throw new FReadException(fileName);
        }
		return  new XMLtest(f, g);
     }

    public void writeXML(String filename, XMLtest x){
		Points[] c = new Points[x.getArr1().length];
		double[] a = x.getArray();
		for(int i = 0; i < arr1.length; i++) {
			c[i] = new Points(arr1[i], arr2[i]);
		}
		try{
			File file = new File (filename);
			try (PrintWriter out = new PrintWriter(file.getAbsoluteFile())) {
				out.println("<?xml version= \"1.0\" encoding=\"UTF-8\"?>");
				out.println("<EquationData Left=\"0.0\" Right=\"0.0\" Step=\"0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"data.xsd\">");
				
				out.println("<ACoefs>");
				for(int i = 0; i < a.length; i++)		{
					out.println("<ACoef X=" + "\"" + a[i] + "\"" + "/>");
				}
				out.println("</ACoefs>");	
				out.println("<XYCoefs>");
				for (int i = 0; i < c.length; i++){
					
				if (c[i]!=null){		        
					out.println("<XYCoef X="+"\"" +c[i].getX()+ "\"" + " Y=" + "\"" + c[i].getY() + "\"" + "/>");
				}
				
			}	
				out.println("</XYCoefs>");
				out.println("</EquationData>");
			}
			
		}
		catch (Exception e) {
			 e.printStackTrace();
		}
	}

    
  public static void main(String[] args) throws FReadException {
    	XMLtest t = new XMLtest();
    	t.readFromXML("data.xml");
    	t.writeXML("test.xml", t);
    //	System.out.println(XMLtest.f.dich(0.001, -10, 10));
    }
}
    
