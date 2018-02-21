import java.util.ArrayList;
import java.util.Random;

public class PolynomialFactorizationProblem implements IPolynomialProblem{

	
	private ProblemAndAnswerPolynomial secondOrderTwoEqualPolynomialFactorizationProblem() {
		
		
		Polynomial p1 = Polynomial.getRandomPolynomial(2);
		//Polynomial p2 = Polynomial.getRandomPolynomial(B);
		Polynomial result = p1.multiply(p1);
		
		
		ProblemAndAnswerPolynomial pa = new ProblemAndAnswerPolynomial();
		pa.problemStatement="Factorize ";
		pa.problemStatement+=""+result.toString();
		//pa.problemStatement+=" by "+p2.toString();
		
		pa.correctAnswers = new ArrayList<>();
		pa.correctAnswers.add(p1);
		pa.correctAnswers.add(p1);
		
		return pa;	
	}
	
	private ProblemAndAnswerPolynomial sumOfCubesPolynomialFactorizationProblem() {

		
		Polynomial p1 = Polynomial.getRandomPolynomial(1);
		while(p1.coefficients.get(0)<=0.0 || p1.coefficients.get(1)<=0.0) {			
				p1 = Polynomial.getRandomPolynomial(1);			
		}
		
		Polynomial p2 = new Polynomial();
		p2.coefficients = new ArrayList<>();
		p2.coefficients.add(Math.pow(p1.coefficients.get(0),2));
		p2.coefficients.add(-1.0*p1.coefficients.get(0)*p1.coefficients.get(1));
		p2.coefficients.add(Math.pow(p1.coefficients.get(1),2));
		p2.degree = 2;
		
		Polynomial result = p1.multiply(p2);
		
		
		ProblemAndAnswerPolynomial pa = new ProblemAndAnswerPolynomial();
		pa.problemStatement="Factorize ";
		pa.problemStatement+=""+result.toString();
		//pa.problemStatement+=" by "+p2.toString();
		
		pa.correctAnswers = new ArrayList<>();
		pa.correctAnswers.add(p1);
		pa.correctAnswers.add(p2);
		
		return pa;	
	}
	
	private ProblemAndAnswerPolynomial diffOfCubesPolynomialFactorizationProblem() {
		
		
		Polynomial p1 = Polynomial.getRandomPolynomial(1);
		while(p1.coefficients.get(0)<=0.0 || p1.coefficients.get(1)<=0.0) {			
				p1 = Polynomial.getRandomPolynomial(1);			
		}
		p1.coefficients.set(1, -1.0*p1.coefficients.get(1));
		Polynomial p2 = new Polynomial();
		p2.coefficients = new ArrayList<>();
		p2.coefficients.add(Math.pow(p1.coefficients.get(0),2));
		p2.coefficients.add(-1.0*p1.coefficients.get(0)*p1.coefficients.get(1));
		p2.coefficients.add(Math.pow(p1.coefficients.get(1),2));
		p2.degree = 2;
		
		Polynomial result = p1.multiply(p2);
		
		
		ProblemAndAnswerPolynomial pa = new ProblemAndAnswerPolynomial();
		pa.problemStatement="Factorize ";
		pa.problemStatement+=""+result.toString();
		//pa.problemStatement+=" by "+p2.toString();
		
		pa.correctAnswers = new ArrayList<>();
		pa.correctAnswers.add(p1);
		pa.correctAnswers.add(p2);
		
		return pa;	
	}
	
	private ProblemAndAnswerPolynomial secondOrderTwoUnequalPolynomialFactorizationProblem() {
				
		Polynomial p1 = Polynomial.getRandomPolynomial(2);
		Polynomial p2 = Polynomial.getRandomPolynomial(2);
		Polynomial result = p1.multiply(p2);
		
		
		ProblemAndAnswerPolynomial pa = new ProblemAndAnswerPolynomial();
		pa.problemStatement="Factorize ";
		pa.problemStatement+=""+result.toString();
		
		
		pa.correctAnswers = new ArrayList<>();
		pa.correctAnswers.add(p1);
		pa.correctAnswers.add(p2);
		
		return pa;	
	}
	
	private ProblemAndAnswerPolynomial randOrderTwoUnequalPolynomialFactorizationProblem() {
		Random r = new Random();
		
		Polynomial p1 = Polynomial.getRandomPolynomial(r.nextInt(4)+1);
		Polynomial p2 = Polynomial.getRandomPolynomial(r.nextInt(4)+1);
		Polynomial result = p1.multiply(p2);
		
		
		ProblemAndAnswerPolynomial pa = new ProblemAndAnswerPolynomial();
		pa.problemStatement="Factorize ";
		pa.problemStatement+=""+result.toString();
		
		
		pa.correctAnswers = new ArrayList<>();
		pa.correctAnswers.add(p1);
		pa.correctAnswers.add(p2);
		
		return pa;	
	}
	
	private ProblemAndAnswerPolynomial secondOrderTwoProductOfDiffOfSquares() {
		
		
		Polynomial p1 = Polynomial.getRandomPolynomial(2);
		p1.coefficients.set(1, 0.0);
		if (p1.coefficients.get(2)>0) {
			p1.coefficients.set(2, -1.0*p1.coefficients.get(2));
		}
		else if (p1.coefficients.get(2)==0) {
			p1.coefficients.set(2, -2.0);
		}
		
		Polynomial p2 = p1.getDeepCopy();
		if (p2.coefficients.get(2)>0) {
			p2.coefficients.set(2, -1.0*p2.coefficients.get(2));
		}
		else if (p2.coefficients.get(2)==0) {
			p2.coefficients.set(2, 2.0);
		}
		
		Polynomial result = p1.multiply(p2);
		
		
		ProblemAndAnswerPolynomial pa = new ProblemAndAnswerPolynomial();
		pa.problemStatement="Factorize ";
		pa.problemStatement+=""+result.toString();
		//pa.problemStatement+=" by "+p2.toString();
		
		pa.correctAnswers = new ArrayList<>();
		pa.correctAnswers.add(p1);
		pa.correctAnswers.add(p2);
		
		return pa;	
	}
	
	public PolynomialFactorizationProblem(){
		
		
	}
	
	
	public ProblemAndAnswerPolynomial generateProblem(int toss){
		System.out.println(toss);
		if (toss==0)
			return randOrderTwoUnequalPolynomialFactorizationProblem();
		else if (toss==1){
			return secondOrderTwoEqualPolynomialFactorizationProblem();
		}
		else if (toss==2) {
			return secondOrderTwoProductOfDiffOfSquares();
		}
		else if (toss==3) {
			return secondOrderTwoUnequalPolynomialFactorizationProblem();
		}
		else if (toss==4) {
			return sumOfCubesPolynomialFactorizationProblem();
		}
		else {
			return diffOfCubesPolynomialFactorizationProblem();
		}
	}
	
	
	private static void printAnswerChoice(String ch, ArrayList<Polynomial> answers){
		
		System.out.print(ch+") ");
		for(int j=0; j<answers.size(); j++){
			Polynomial d = answers.get(j);
			System.out.print("(");
			d.printPolynomial();
			System.out.print(")");
			
		}
	}
	
	public static void printProblemsWithMultipleChoiceAnswers(int count){
		
		
		String[] answers = new String[count];
		String[] answersHints = new String[count];
		
		Random r1 = new Random();
		
		for(int k=0; k<count; k++){
			PolynomialFactorizationProblem s = new PolynomialFactorizationProblem();
			int toss = r1.nextInt(6);			
			ProblemAndAnswerPolynomial pa = s.generateProblem(toss);
			
			System.out.print(k+1+". ");
			System.out.println(pa.problemStatement);
			ArrayList<ArrayList<Polynomial>> wrongAnswerLists = pa.getWrongAnswerChoices(pa.correctAnswers.get(0).degree,3);
			Random r = new Random();
			int randIndex = r.nextInt(wrongAnswerLists.size()+1);
			char choiceIndex = 'a';
			int wrongIndex = 0;
			for(int j = 0; j<wrongAnswerLists.size()+1; j++){
				if (randIndex==j){
					String ci = String.format("%s", choiceIndex);
					printAnswerChoice(ci, pa.correctAnswers);					
					answers[k] = ci;
					answersHints[k]=pa.answerHint;
				}
				else{
					String ci = String.format("%s", choiceIndex);
					printAnswerChoice(ci, wrongAnswerLists.get(wrongIndex));
					wrongIndex++;
				}
				choiceIndex++;
				System.out.println();
			}
			
						
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		System.out.println("--------Answer key--------");
		for(int k=0; k<count; k++){
			System.out.print(k+1+". ");
			System.out.print(answers[k]);
			if (answersHints[k]!=null) System.out.print(" ["+answersHints[k]+"]");
			System.out.println();
		}
		
		
	}
	
	public static void printProblemsWithAnswers(int count){
		
		for(int k=0; k<count; k++){
			PolynomialFactorizationProblem s = new PolynomialFactorizationProblem();
			ProblemAndAnswerPolynomial pa = s.generateProblem(2);
			
			System.out.println(pa.problemStatement);			
			String ci = String.format("%s", "Ans");
			printAnswerChoice(ci, pa.correctAnswers);
				
			System.out.println();
			
		}
	}
	
	public static void printProblemsWithNoAnswerChoices(int count){
		
		for(int k=0; k<count; k++){
			PolynomialFactorizationProblem s = new PolynomialFactorizationProblem();
			ProblemAndAnswerPolynomial pa = s.generateProblem(0);
			
			System.out.println(pa.problemStatement);
			
			for(int i=0; i<20; i++)
				System.out.println();						
			
		}
	}
	
	
}
