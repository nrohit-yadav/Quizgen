import java.util.ArrayList;

public class MixedFraction {
	
	// numerator and denominator
	public Integer mainTerm=1;
	public Fraction fractionTerm = new Fraction();
	
	public MixedFraction() {
		
	}
	
	public void set(int main, int num, int demom) {
		mainTerm=main;
		fractionTerm.set(num, demom);
	}
	
	public void printFraction() {
		System.out.print(mainTerm);
		fractionTerm.printFraction();
	}

	public void printFractionHTML() {
		System.out.print(mainTerm);
		fractionTerm.printFractionHTML();
	}
	
	public String getFractionHTMLString() {
		String out = mainTerm+fractionTerm.getFractionHTMLString();
		return out;
	}
	
	public Fraction getFraction() {
		Fraction f = new Fraction();
		f.numerdenom[0]=mainTerm*fractionTerm.numerdenom[1]+fractionTerm.numerdenom[0];
		f.numerdenom[1]=fractionTerm.numerdenom[1];
		
		return f;
	}
	
	public static Fraction add(MixedFraction f1, MixedFraction f2) {
		return Fraction.add(f1.getFraction(), f2.getFraction());
	}
	
	public static Fraction subtract(MixedFraction f1, MixedFraction f2) {
		return Fraction.subtract(f1.getFraction(), f2.getFraction());
	}
	

	public static Fraction multiply(MixedFraction f1, MixedFraction f2) {
		return Fraction.multiply(f1.getFraction(), f2.getFraction());
	}
		

	public static Fraction divide(MixedFraction f1, MixedFraction f2) {
		return Fraction.divide(f1.getFraction(), f2.getFraction());
	}

}
