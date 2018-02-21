import java.util.ArrayList;
import java.util.Random;

public class LESequenceProblem implements IAlgebraProblem{

	
	private ProblemAndAnswer randIndexBasedLinearSequenceFunction() {
		// generate a random sequence of the form An+B
		Random r = new Random();
		int A = r.nextInt(10)+1;
		int B = r.nextInt(5)+1;
		int[] seq = new int[6];
		
		int ans = -1;
		int rand_indx = r.nextInt(4)+1;
		
		ProblemAndAnswer pa = new ProblemAndAnswer();
		pa.problemStatement="Complete the sequence: ";
		ArrayList<Double> answers = new ArrayList<>();
		for(int k=0; k<6; k++) {
			seq[k]=A*k+B;
			if (k==rand_indx) {				
				answers.add(1.0*seq[k]);
				pa.problemStatement +="__, ";				
				pa.correctAnswers=answers;
				pa.answerHint="S(n)="+A+"n+"+B;
			}
			else {
				if (k!=5) {
					pa.problemStatement +=seq[k]+", ";
				}
				else {
					pa.problemStatement +=seq[k];
				}
			}
		}		
		return pa;	
	}
	
	private ProblemAndAnswer randIndexBasedQuadraticSequenceFunction() {
		// generate a random sequence of the form An+B
		Random r = new Random();
		int A = r.nextInt(15)+1;
		int B = r.nextInt(10)+1;
		int C = r.nextInt(20)+1;
		int[] seq = new int[6];
		
		int ans = -1;
		int rand_indx = r.nextInt(4)+1;
		
		ProblemAndAnswer pa = new ProblemAndAnswer();
		pa.problemStatement="Complete the sequence: ";
		ArrayList<Double> answers = new ArrayList<>();
		for(int k=0; k<6; k++) {
			seq[k]=A*k*k+B*k+C;
			if (k==rand_indx) {				
				answers.add(1.0*seq[k]);
				pa.problemStatement +="__, ";				
				pa.correctAnswers=answers;
				pa.answerHint="S(n)="+A+"n^2+"+B+"n+"+C;
			}
			else {
				if (k!=5) {
					pa.problemStatement +=seq[k]+", ";
				}
				else {
					pa.problemStatement +=seq[k];
				}
			}
		}		
		return pa;	
	}
	
	private ProblemAndAnswer randPrevElementBasedLinearSequenceFunction() {
		// generate a random sequence of the form An+B
		Random r = new Random();
		int A = r.nextInt(15)+1;
		int B = r.nextInt(10)+1;
		int C = r.nextInt(20)+1;
		int[] seq = new int[6];
		
		int ans = -1;
		int rand_indx = r.nextInt(4)+1;
		
		ProblemAndAnswer pa = new ProblemAndAnswer();
		pa.problemStatement="Complete the sequence: ";
		ArrayList<Double> answers = new ArrayList<>();
		int prev = r.nextInt(50)+1;
		for(int k=0; k<6; k++) {
			seq[k]=prev+(B*k+C);
			if (k==rand_indx) {				
				answers.add(1.0*seq[k]);
				pa.problemStatement +="__, ";				
				pa.correctAnswers=answers;
				pa.answerHint="S(n)=S(n-1)+"+B+"n+"+C;
			}
			else {
				if (k!=5) {
					pa.problemStatement +=seq[k]+", ";
				}
				else {
					pa.problemStatement +=seq[k];
				}
			}
			prev = seq[k]; 
		}		
		return pa;	
	}
	
	private ProblemAndAnswer randPrevTwoElementsBasedLinearSequenceFunction() {
		// generate a random sequence of the form An+B
		Random r = new Random();
		int A = r.nextInt(15)+1;
		int B = r.nextInt(10)+1;
		int C = r.nextInt(20)+1;
		int[] seq = new int[6];
		
		int ans = -1;
		
		ProblemAndAnswer pa = new ProblemAndAnswer();
		pa.problemStatement="Complete the sequence: ";
		ArrayList<Double> answers = new ArrayList<>();
		int prev = r.nextInt(50)+1;
		seq[0]=prev;
		seq[1]=r.nextInt(50)+1;
		if (seq[0]>seq[1]) {
			int tmp = seq[0];
			seq[0]=seq[1];
			seq[1]=tmp;
		}
		prev = seq[0];
		int prev2 = seq[1];
		pa.problemStatement +=seq[0]+", ";
		pa.problemStatement +=seq[1]+", ";
		
		int rand_indx = r.nextInt(3)+2;
		
		for(int k=2; k<6; k++) {
			seq[k]=prev+prev2+C;
			if (k==rand_indx) {				
				answers.add(1.0*seq[k]);
				pa.problemStatement +="__, ";				
				pa.correctAnswers=answers;
				pa.answerHint="S(n)=S(n-1)+S(n-2)+"+C;
			}
			else {
				if (k!=5) {
					pa.problemStatement +=seq[k]+", ";
				}
				else {
					pa.problemStatement +=seq[k];
				}
			}
			prev = seq[k-2];
			prev2 = seq[k-1];
		}		
		return pa;	
	}
	
	public LESequenceProblem(){
		
		
	}
	
	@Override
	public ProblemAndAnswer generateProblem(int category){
		Random r = new Random();
		int A = r.nextInt(4);
		if (A==0) {
			return randIndexBasedLinearSequenceFunction();
		}
		else if (A==1) {
			return randIndexBasedQuadraticSequenceFunction();
		}
		else if (A==2) {
			return randPrevTwoElementsBasedLinearSequenceFunction();
		}
		else {
			return randPrevElementBasedLinearSequenceFunction();
		}
		 
	}
	
	private static void printAnswerChoice(String ch, ArrayList<Double> answers){
	
		System.out.print(ch+") ");
		for(int j=0; j<answers.size(); j++){
			Double d = answers.get(j);
			System.out.print(d);
			if (j!=answers.size()-1){
				System.out.print(", ");
			}
		}
	}
	
	public static void printProblemsWithMultipleChoiceAnswers(int count){
		
		
		String[] answers = new String[count];
		String[] answersHints = new String[count];
		for(int k=0; k<count; k++){
			LESequenceProblem s = new LESequenceProblem();
			ProblemAndAnswer pa = s.generateProblem(0);
			
			System.out.print(k+1+". ");
			System.out.println(pa.problemStatement);
			ArrayList<ArrayList<Double>> wrongAnswerLists = pa.getWrongAnswerChoices(3,0);
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
			LESequenceProblem s = new LESequenceProblem();
			ProblemAndAnswer pa = s.generateProblem(0);
			
			System.out.println(pa.problemStatement);			
			String ci = String.format("%s", "Ans");
			printAnswerChoice(ci, pa.correctAnswers);
				
			System.out.println();
			
		}
	}
	
	public static void printProblemsWithNoAnswerChoices(int count){
		
		for(int k=0; k<count; k++){
			LESequenceProblem s = new LESequenceProblem();
			ProblemAndAnswer pa = s.generateProblem(0);
			
			System.out.println(pa.problemStatement);
			
			for(int i=0; i<20; i++)
				System.out.println();						
			
		}
	}
	
	
}
