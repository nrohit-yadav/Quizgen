import java.util.ArrayList;
import java.util.Random;

public class ProblemAndAnswerPolynomial {

	public String problemStatement;
	public String answerHint;
	public ArrayList<Polynomial> correctAnswers = new ArrayList<>();
	
	public String getProblemStatement(){
		return problemStatement;
	}
	
	public ArrayList<ArrayList<Polynomial>> getWrongAnswerChoices(int degree, int count){
		ArrayList<ArrayList<Polynomial>> result = new ArrayList<>();
		
		Random r = new Random();
		
		for(int k=0; k<count; k++){
			ArrayList<Polynomial> incorrectAnswerSet = new ArrayList<>();
			for(int j=0; j<correctAnswers.size(); j++){
				incorrectAnswerSet.add(Polynomial.getSimilarPolynomial(correctAnswers.get(j)));
			}
			
			result.add(incorrectAnswerSet);
		}
		
		return result;
		
	}
	
	public ArrayList<Polynomial> getCorrectAnswerChoice(){
		return correctAnswers;
	}
}
