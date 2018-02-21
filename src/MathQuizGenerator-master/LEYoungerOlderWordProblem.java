import java.util.ArrayList;
import java.util.Random;

public class LEYoungerOlderWordProblem implements IAlgebraProblem{

	private double dAgeYounger;
	private double dAgeOlder;
	
	private ArrayList<String> problemStatements = new ArrayList<>();
	
	
	
	public LEYoungerOlderWordProblem(){
		
		for(;;){
			Random r = new Random();
			int p = r.nextInt(10)+1;
			int q = r.nextInt(10)+3;
			
			if (q<p){
				int lower = q;
				q= p;
				p = lower;
			}
			else if (p==q){
				p = 2;
			}
			
			int k = r.nextInt(10)+1;
			double alpha = (r.nextInt(3)+1) * Math.ceil(1.0*k/p);
			double d = alpha * (q-p);
					
			dAgeYounger = -1*k+((d*p)/(q-p));
			dAgeOlder = dAgeYounger + d;
			
			if(d<=15) {
				problemStatements.add("John is "+d+" years younger than his sister Jane."+" In "+k+" years, John will be "+p+"/"+q+" as old as Jane. How old are John and Jane now.");
				problemStatements.add("Julia is "+d+" years younger than her borther Joseph."+" In "+k+" years, Julia will be "+p+"/"+q+" as old as Joseph. How old are Julia and Joseph now.");
				
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
		pna.correctAnswers.add(dAgeYounger);
		pna.correctAnswers.add(dAgeOlder);
		
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
			LEYoungerOlderWordProblem s = new LEYoungerOlderWordProblem();
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
			LEYoungerOlderWordProblem s = new LEYoungerOlderWordProblem();
			ProblemAndAnswer pa = s.generateProblem(0);
			
			System.out.println(pa.problemStatement);			
			String ci = String.format("%s", "Ans");
			printAnswerChoice(ci, pa.correctAnswers);
				
			System.out.println();
			
		}
	}
	
	public static void printProblemsWithNoAnswerChoices(int count){
		
		for(int k=0; k<count; k++){
			LEYoungerOlderWordProblem s = new LEYoungerOlderWordProblem();
			ProblemAndAnswer pa = s.generateProblem(0);
			
			System.out.println(pa.problemStatement);
			
			for(int i=0; i<20; i++)
				System.out.println();						
			
		}
	}
	
	
}
