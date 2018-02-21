import java.util.ArrayList;
import java.util.Random;

public class ProblemAndAnswerFraction {

	public String problemStatement;
	public String answerHint;
	public ArrayList<Fraction> correctAnswers = new ArrayList<>();
	
	public String getProblemStatement(){
		return problemStatement;
	}
	
	public ArrayList<ArrayList<Fraction>> getWrongAnswerChoices(int count, int decimalCount){
		ArrayList<ArrayList<Fraction>> result = new ArrayList<>();
		
		Random r = new Random();
		
		for(int k=0; k<count; k++){
			ArrayList<Fraction> incorrectAnswerSet = new ArrayList<>();
			for(int j=0; j<correctAnswers.size(); j++){				
					int a = r.nextInt(25)+1;
					int b = r.nextInt(30)+1;
					incorrectAnswerSet.add(new Fraction(a,b));				
			}
			
			result.add(incorrectAnswerSet);
		}
		
		return result;
		
	}
	
	public ArrayList<Fraction> getCorrectAnswerChoice(){
		return correctAnswers;
	}
}
