import java.util.ArrayList;
import java.util.Random;

public class PolynomialMultiplicationProblem implements IPolynomialProblem{

	
	private ProblemAndAnswerPolynomial randPolynomialMultiplicationProblem(int deg1, int deg2) {
		// generate a random sequence of the form An+B
		Random r = new Random();
		int A = r.nextInt(deg1)+1;
		int B = r.nextInt(deg2)+1;
		
		Polynomial p1 = Polynomial.getRandomPolynomial(A);
		Polynomial p2 = Polynomial.getRandomPolynomial(B);
		Polynomial result = p1.multiply(p2);
		
		
		ProblemAndAnswerPolynomial pa = new ProblemAndAnswerPolynomial();
		pa.problemStatement="Multiply these polynomials: ";
		pa.problemStatement+=""+p1.toString();
		pa.problemStatement+=" and "+p2.toString();
		
		pa.correctAnswers = new ArrayList<>();
		pa.correctAnswers.add(result);
		
		return pa;	
	}
	
	@Override
	public ProblemAndAnswerPolynomial generateProblem(int category) {
		Random r = new Random();
		int A = r.nextInt(3)+1;
		int B = r.nextInt(2)+1;
		return randPolynomialMultiplicationProblem(A, B);
	}
	
	public PolynomialMultiplicationProblem() {
		// TODO Auto-generated constructor stub
	}
	
	private static void printAnswerChoice(String ch, ArrayList<Polynomial> answers){
		
		System.out.print(ch+") ");
		for(int j=0; j<answers.size(); j++){
			Polynomial d = answers.get(j);
			d.printPolynomial();
			if (j!=answers.size()-1){
				System.out.print(", ");
			}
		}
	}
	
	public static void printProblemsWithMultipleChoiceAnswers(int count){
			
		String[] answers = new String[count];
		String[] answersHints = new String[count];
		for(int k=0; k<count; k++){
			PolynomialMultiplicationProblem s = new PolynomialMultiplicationProblem();
			ProblemAndAnswerPolynomial pa = s.generateProblem(0);
			
			System.out.print(k+1+". ");
			System.out.println(pa.problemStatement);
			ArrayList<ArrayList<Polynomial>> wrongAnswerLists = pa.getWrongAnswerChoices(3,3);
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
			System.out.print(" ["+answersHints[k]+"]");
			System.out.println();
		}
		
		
	}
	
	public static void printProblemsWithAnswers(int count){	
		for(int k=0; k<count; k++){
			PolynomialMultiplicationProblem s = new PolynomialMultiplicationProblem();
			ProblemAndAnswerPolynomial pa = s.generateProblem(0);
			
			System.out.println(pa.problemStatement);			
			String ci = String.format("%s", "Ans");
			printAnswerChoice(ci, pa.correctAnswers);
				
			System.out.println();
			
		}
	}
	
	public static void printProblemsWithNoAnswerChoices(int count){
		
		for(int k=0; k<count; k++){
			PolynomialMultiplicationProblem s = new PolynomialMultiplicationProblem();
			ProblemAndAnswerPolynomial pa = s.generateProblem(0);
			
			System.out.println(pa.problemStatement);
			
			for(int i=0; i<20; i++)
				System.out.println();						
			
		}
	}
	
	
}