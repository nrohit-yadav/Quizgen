import java.util.ArrayList;

public class Fraction {
	
	// numerator and denominator
	public Integer[] numerdenom = new Integer[2];
	
	public Fraction() {
		// TODO Auto-generated method stub
		numerdenom[0]=1;
		numerdenom[1]=1;

	}
	
	public Fraction(int num, int demom) {
		numerdenom[0]=num;
		numerdenom[1]=demom;
	}
	
	public void set(int num, int demom) {
		numerdenom[0]=num;
		numerdenom[1]=demom;
	}
	
	public void printFraction() {
		System.out.println(numerdenom[0]+"/"+numerdenom[1]);
	}

	public void printFractionHTML() {
		System.out.println("<sup>"+numerdenom[0]+"</sup>&frasl;<sub>"+numerdenom[1]+"</sub>");
	}
	
	public String getFractionHTMLString() {
		return "<sup>"+numerdenom[0]+"</sup>&frasl;<sub>"+numerdenom[1]+"</sub>";
	}

	
	public static Fraction add(Fraction f1, Fraction f2) {
		
		Fraction fout = new Fraction();
		fout.numerdenom[0]=f1.numerdenom[0]*f2.numerdenom[1]+f2.numerdenom[0]*f1.numerdenom[1];
		fout.numerdenom[1]=f1.numerdenom[1]*f2.numerdenom[1];
		
		return fout;
		
	}
	
	public static Fraction subtract(Fraction f1, Fraction f2) {
		
		Fraction fout = new Fraction();
		fout.numerdenom[0]=f1.numerdenom[0]*f2.numerdenom[1]-f2.numerdenom[0]*f1.numerdenom[1];
		fout.numerdenom[1]=f1.numerdenom[1]*f2.numerdenom[1];
		
		return fout;
		
	}
	
	public static Fraction multiply(Fraction f1, Fraction f2) {
		
		Fraction fout = new Fraction();
		fout.numerdenom[0]=f1.numerdenom[0]*f2.numerdenom[0];
		fout.numerdenom[1]=f1.numerdenom[1]*f2.numerdenom[1];
		
		return fout;
		
	}
	
	public static Fraction divide(Fraction f1, Fraction f2) {
		
		Fraction fout = new Fraction();
		fout.numerdenom[0]=f1.numerdenom[0]*f2.numerdenom[1];
		fout.numerdenom[1]=f1.numerdenom[1]*f2.numerdenom[0];
		
		return fout;
		
	}
}
