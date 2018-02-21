import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class Polynomial {
	
	// An x^n + An-1
	public int degree;
	public ArrayList<Double> coefficients = new ArrayList<>();
	
	
	public void printPolynomial() {
		System.out.print(this.toString());
	}
	
	public Polynomial getDeepCopy() {
		Polynomial p = new Polynomial();
		p.coefficients = new ArrayList<>();
		for(Double d : this.coefficients) {
			p.coefficients.add(d);
		}
		p.degree = this.degree;
		
		return p;
	}
	
	
	
	public String toString() {
		String res = "";
		for(int i =0; i<this.degree+1; i++){
			if (i!=this.degree) {
				if (i>0) {
					// For non-first terms, if coefficient is zero, just ignore and continue
					if (this.coefficients.get(i)==0.0) {
						continue;
					}
					else // For non-first terms, if coefficient greater than zero, put a plus sign
					if (this.coefficients.get(i)>0) {
						res+="+";
						
					}// For non-first terms, if coefficient is less than zero, just write out the sign
					/*else if (this.coefficients.get(i)<0) {
						System.out.print("-");
						
					}*/
					
					// For non-first terms whose exponent is 1
					if (this.degree-i==1) {
						double diff = Math.round(this.coefficients.get(i))-this.coefficients.get(i);
						if (diff!=0.0) {
							res+=this.coefficients.get(i)+"x ";
						}
						else {
							res+=Math.round(this.coefficients.get(i))+"x ";
						}
					}
					else {
						double diff = Math.round(this.coefficients.get(i))-this.coefficients.get(i);
						if (diff!=0.0) {
							res+=this.coefficients.get(i)+"x"+"^"+(this.degree-i)+ " ";
						}
						else {
							res+=Math.round(this.coefficients.get(i))+"x"+"^"+(this.degree-i)+ " ";							
						}
						
					}
					
				}
				else { //i==0
					double diff = Math.round(this.coefficients.get(i))-this.coefficients.get(i);
					if (this.coefficients.get(i)!=0.0 && this.coefficients.get(i)!=1.0 && this.coefficients.get(i)!=-1.0) {
						
						if (diff!=0.0) {
							if (this.degree-i>1)
								res+=this.coefficients.get(i)+"x"+"^"+(this.degree-i)+" ";
							else
								res+=this.coefficients.get(i)+"x"+" ";
						}
						else {
							if (this.degree-i>1)
								res+=Math.round(this.coefficients.get(i))+"x"+"^"+(this.degree-i)+" ";
							else
								res+=Math.round(this.coefficients.get(i))+"x"+" ";
						}
					}
					else if (this.coefficients.get(i)==0.0) {
						continue;
					}
					else if (this.coefficients.get(i)==1.0) {
						
						if (this.degree-i>1)
							res+="x"+"^"+(this.degree-i)+" ";
						else							
							res+="x"+" ";
					}
					else if (this.coefficients.get(i)==-1.0) {
						if (this.degree-i>1)
							res+="-x"+"^"+(this.degree-i)+" ";
						else
							res+="-x"+" ";
					}
					
				}
				
			}
			else {
				if (this.coefficients.get(i)>0.0) {
					res+="+";
					double diff = Math.round(this.coefficients.get(i))-this.coefficients.get(i);
					if (diff!=0.0) {
						res+=this.coefficients.get(i);
					}
					else {
						res+=Math.round(this.coefficients.get(i));						
					}
					
				}
				else if (this.coefficients.get(i)<0) {
					double diff = Math.round(this.coefficients.get(i))-this.coefficients.get(i);
					if (diff!=0.0) {
						res+=this.coefficients.get(i);
					}
					else {
						res+=Math.round(this.coefficients.get(i));						
					}
				}
				else if (this.coefficients.get(i)==0) {
					continue;
				}
			}
		}
		//System.out.println();
		return res;
	}
	
	public static Polynomial getRandomPolynomial(int degree) {
		Polynomial p = new Polynomial();
		p.degree = degree;
		
		Random r = new Random();
		int A = r.nextInt(15)+1;
		int sign = r.nextInt(2);
		ArrayList<Double> coeffs = new ArrayList<>();
		
		for(int i =0; i<p.degree+1; i++) {
			if (i==0) {
				sign = r.nextInt(2);
				double multiplier = 1.0;
				if (sign==1) {
					multiplier = -1.0;
				}
				coeffs.add(multiplier*r.nextInt(10)+1);
			}
			else {
				sign = r.nextInt(2);
				double multiplier = 1.0;
				coeffs.add(multiplier*r.nextInt(10));
			}			
		}
		
		p.coefficients = coeffs;
		
		return p;
	}
	
	public static Polynomial getSimilarPolynomial(Polynomial orig) {
		
		
		// flip signs of orig poly and interchange coefficients randomly
		Polynomial p = new Polynomial();
		p.degree = orig.degree;
		
		if (p.degree>2) {
			Random r = new Random();
			int sign = r.nextInt(2);
			ArrayList<Double> coeffs = new ArrayList<>();
			
			for(int i =0; i<p.degree+1; i++) {
				
				sign = r.nextInt(2);
				double multiplier = 1.0;
				if (sign==1) {
					multiplier = -1.0;
				}
				coeffs.add(multiplier*orig.coefficients.get(r.nextInt(p.degree+1)));
						
			}
			
			p.coefficients = coeffs;
			
		}
		else {
			p = getRandomPolynomial(orig.degree);
		}
		
		return p;
	}

	public Polynomial multiply(Polynomial p) {
		Polynomial result = new Polynomial();
		result.degree = this.degree+p.degree;
		
		java.util.Dictionary<Integer, Double> multiplyresult = new Hashtable<>();
		for(int k=0; k<this.degree+1; k++) {
			for(int l=0; l<p.degree+1; l++) {
				double res = this.coefficients.get(k)*p.coefficients.get(l);
				int deg = (this.degree-k)+(p.degree-l);
				if (multiplyresult.get(deg)==null) {
					multiplyresult.put(deg, res);
				}
				else {
					double nres = multiplyresult.get(deg)+res;
					multiplyresult.put(deg, nres);
				}
				
			}
		}
		
		 for(int a=0; a<result.degree+1; a++) {
			 if (multiplyresult.get(result.degree-a)!=null) {
				 result.coefficients.add(multiplyresult.get(result.degree-a));
			 }
			 else {
				 result.coefficients.add(0.0);
			 }
		 }
		 
		 return result;
	}
}
