import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class LESalineSolutionWordProblem implements IAlgebraProblem{

	private double c1;
	private double c2;
	private double c3;
	private double vol;
	
	private double vol1;
	private double vol2;
	
	private ArrayList<String> problemStatements = new ArrayList<>();
	
	
	
	public LESalineSolutionWordProblem(){
		
		for(;;){
			Random r = new Random();
			int p = r.nextInt(100)+1;
			int q = r.nextInt(100)+1;
			int s =  r.nextInt(100)+1;
			
			int[] ints = {p, q, s};
			Arrays.sort(ints);
			
			c1 = ints[0];
			c2 = ints[2];
			c3 = ints[1];
			
			vol = r.nextInt(150)+25;

					
			
			if(c1!=c2 && c2!=c3 && c1!=c3) {
			
				vol1 = (c3-c2)*vol/(c1-c2);
				vol2 = (c1-c3)*vol/(c1-c2);
				
				vol1 = Math.ceil(vol1*100)/100.0;
				vol2 = Math.ceil(vol2*100)/100.0;
				
				problemStatements.add("A chemist has one solution that is "+c1+"% saline and a second that is "+c2+"% saline. How many gallons of each should be mixed together to get "+vol+" gallons of a solution that is "+c3+"% saline?");
				problemStatements.add("How many liters of "+c1+"% acid and "+c2+"% acid should be mixed to make "+vol+" liters of "+c3+"% acid solution?");
				
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
		pna.correctAnswers.add(vol1);
		pna.correctAnswers.add(vol2);
		
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
			LESalineSolutionWordProblem s = new LESalineSolutionWordProblem();
			ProblemAndAnswer pa = s.generateProblem(0);
			
			System.out.println(pa.problemStatement);
			ArrayList<ArrayList<Double>> wrongAnswerLists = pa.getWrongAnswerChoices(3,2);
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
			LESalineSolutionWordProblem s = new LESalineSolutionWordProblem();
			ProblemAndAnswer pa = s.generateProblem(0);
			
			System.out.println(pa.problemStatement);			
			String ci = String.format("%s", "Ans");
			printAnswerChoice(ci, pa.correctAnswers);
				
			System.out.println();
			
		}
	}
	
	public static void printProblemsWithNoAnswerChoices(int count){
		
		for(int k=0; k<count; k++){
			LESalineSolutionWordProblem s = new LESalineSolutionWordProblem();
			ProblemAndAnswer pa = s.generateProblem(0);
			
			System.out.println(pa.problemStatement);
			
			for(int i=0; i<20; i++)
				System.out.println();						
			
		}
	}
	
	
}
