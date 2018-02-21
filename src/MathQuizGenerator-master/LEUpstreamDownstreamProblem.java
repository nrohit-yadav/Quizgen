import java.util.ArrayList;
import java.util.Random;

public class LEUpstreamDownstreamProblem implements IAlgebraProblem{

	private double dDistance;
	private double dDownstreamTime;
	private double dUpstreamTime;
	
	private ArrayList<String> problemStatements = new ArrayList<>();
	
	
	
	public LEUpstreamDownstreamProblem(){
		
		Random r = new Random();
		int x = r.nextInt(20)+1;
		int y = r.nextInt(30)+1;
		
		if (x<y){
			int lower = x;
			x= y;
			y = lower;
		}
		dUpstreamTime = x;
		dDownstreamTime = y;
		dDistance = r.nextInt(100)+200;
		
		problemStatements.add("Person travels upstream for "+dUpstreamTime+" hours and the downstream for "+dDownstreamTime+". If distance each way is "+dDistance+" miles, find the speeds of the boat and the stream in mi/hr.");
		problemStatements.add("Person flys with headwind for "+dUpstreamTime+" hours and then with tailwind for "+dDownstreamTime+". If distance each way is "+dDistance+" miles, find the speeds of the plane and the wind in mi/hr.");
	}
	
	@Override
	public ProblemAndAnswer generateProblem(int category){
		
		ProblemAndAnswer pna = new ProblemAndAnswer();
		Random r = new Random();
		int randIndex = r.nextInt(this.problemStatements.size());
		
		pna.problemStatement = problemStatements.get(randIndex);
		
		double d = (dUpstreamTime+dDownstreamTime)*dDistance/(2*dUpstreamTime*dDownstreamTime);
		d = Math.ceil(d*100)/100.d;		
		pna.correctAnswers.add(d);
		
		d = (dUpstreamTime-dDownstreamTime)*dDistance/(2*dUpstreamTime*dDownstreamTime);
		d = Math.ceil(d*100)/100.d;
		pna.correctAnswers.add(d);
		
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
			LEUpstreamDownstreamProblem s = new LEUpstreamDownstreamProblem();
			ProblemAndAnswer pa = s.generateProblem(0);
			
			System.out.print(k+1+". ");
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
			LEUpstreamDownstreamProblem s = new LEUpstreamDownstreamProblem();
			ProblemAndAnswer pa = s.generateProblem(0);
			
			System.out.println(pa.problemStatement);			
			String ci = String.format("%s", "Ans");
			printAnswerChoice(ci, pa.correctAnswers);
				
			System.out.println();
			
		}
	}
	
	public static void printProblemsWithNoAnswerChoices(int count){
		
		for(int k=0; k<count; k++){
			LEUpstreamDownstreamProblem s = new LEUpstreamDownstreamProblem();
			ProblemAndAnswer pa = s.generateProblem(0);
			
			System.out.println(pa.problemStatement);
			
			for(int i=0; i<20; i++)
				System.out.println();						
			
		}
	}
	
	
}
