import java.util.ArrayList;
import java.util.Random;

public class ProblemAndAnswer {

	public String problemStatement;
	public String answerHint;
	public ArrayList<Double> correctAnswers = new ArrayList<>();
	
	public String getProblemStatement(){
		return problemStatement;
	}
	
	public ArrayList<ArrayList<Double>> getWrongAnswerChoices(int count, int decimalCount){
		ArrayList<ArrayList<Double>> result = new ArrayList<>();
		
		Random r = new Random();
		
		for(int k=0; k<count; k++){
			ArrayList<Double> incorrectAnswerSet = new ArrayList<>();
			for(int j=0; j<correctAnswers.size(); j++){
				if (decimalCount==0){
					int a = r.nextInt(100)+1;
					Double d = 1.0d*a;
					incorrectAnswerSet.add(d);
				}
				else if (decimalCount>0){
					int a = r.nextInt(10000)+1;
					Double d = 0.01d*a;
					d = Math.ceil(d*100)/100.d;
					incorrectAnswerSet.add(d);
				}
			}
			
			result.add(incorrectAnswerSet);
		}
		
		return result;
		
	}
	
	public ArrayList<Double> getCorrectAnswerChoice(){
		return correctAnswers;
	}
}
