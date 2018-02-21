import java.util.ArrayList;
import java.util.Random;

public class LENickelDimeProblem implements IAlgebraProblem{

	private double dNoNickels;
	private double dNoDimes;
	private double dAmount;
	
	private ArrayList<String> problemStatements = new ArrayList<>();
	
	
	
	public LENickelDimeProblem(){
		
		for(;;){
			Random r = new Random();
			int p = r.nextInt(25)+1;
			int q = r.nextInt(50)+4;
			
			if (q<p){
				int lower = q;
				q= p;
				p = lower;
			}
			else if (p==q){
				p = 9;
			}
			
			dNoDimes = p;
			dNoNickels = q;
			dAmount = q*0.05+p*0.1;
			dAmount = (1.0*(int)(dAmount*100))/100.0;
			
			if(dAmount>3) {
				problemStatements.add("A collection of nickel and dimes is worth $"+dAmount+". If the total coins in the collection are "+(dNoNickels+dNoDimes)+", how many of each kind of coin are there?");
				problemStatements.add("If Jaden has a collecition of $"+dAmount+" in nickels and dimes totalling "+(dNoNickels+dNoDimes)+" coins, how many of each coin type does he have?");
				
				break;
			}
		}
		
	}
	
	@Override
	public ProblemAndAnswer generateProblem(int category){
		
		ProblemAndAnswer pna = new ProblemAndAnswer();
		Random r = new Random();
		int randIndex = r.nextInt(this.problemStatements.size());
		
		pna.problemStatement = problemStatements.get(randIndex);
		pna.correctAnswers.add(dNoNickels);
		pna.correctAnswers.add(dNoDimes);
		
		return pna;
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
		for(int k=0; k<count; k++){
			LENickelDimeProblem s = new LENickelDimeProblem();
			ProblemAndAnswer pa = s.generateProblem(0);
			
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
			System.out.println(answers[k]);
		}
	}
	
	public static void printProblemsWithAnswers(int count){
		
		for(int k=0; k<count; k++){
			LENickelDimeProblem s = new LENickelDimeProblem();
			ProblemAndAnswer pa = s.generateProblem(0);
			
			System.out.println(pa.problemStatement);			
			String ci = String.format("%s", "Ans");
			printAnswerChoice(ci, pa.correctAnswers);
				
			System.out.println();
			
		}
	}
	
	public static void printProblemsWithNoAnswerChoices(int count){
		
		for(int k=0; k<count; k++){
			LENickelDimeProblem s = new LENickelDimeProblem();
			ProblemAndAnswer pa = s.generateProblem(0);
			
			System.out.println(pa.problemStatement);
			
			for(int i=0; i<20; i++)
				System.out.println();						
			
		}
	}
	
	
}
