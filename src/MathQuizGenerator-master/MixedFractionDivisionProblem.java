import java.util.ArrayList;
import java.util.Random;

public class MixedFractionDivisionProblem implements IAlgebraProblemFraction{

	private MixedFraction f1 = new MixedFraction();
	private MixedFraction f2 = new MixedFraction();
	
	
	public MixedFractionDivisionProblem(){
		
		
			Random r = new Random();
			int m = r.nextInt(10)+1;
			int n = r.nextInt(10)+1;
			int d = r.nextInt(5)+5;
		
			f1.set(m, n, d);
			
		
			int m2 = r.nextInt(10)+1;
			int n2 = r.nextInt(10)+1;
			int d2 = r.nextInt(5)+5;
		
			f2.set(m2, n2, d2);
			
		
	}
	
	@Override
	public ProblemAndAnswerFraction generateProblem(int category){
		
		ProblemAndAnswerFraction pna = new ProblemAndAnswerFraction();
		
		pna.problemStatement = f1.getFractionHTMLString()+"&nbsp;"+"&#xf7;"+"&nbsp;"+f2.getFractionHTMLString();
		Fraction fdiv = MixedFraction.divide(f1, f2);
		pna.correctAnswers.add(fdiv);
		
		
		return pna;
	}
	
	private static void printAnswerChoice(String ch, ArrayList<Fraction> answers){
	
		System.out.print(ch+") ");
		for(int j=0; j<answers.size(); j++){
			Fraction d = answers.get(j);
			d.printFractionHTML();
			if (j!=answers.size()-1){
				System.out.print(", ");
			}
		}
	}
	
	public static void printProblemsWithMultipleChoiceAnswers(int count){
		String[] answers = new String[count];
		
		String htmlString = "<!DOCTYPE html>";
		htmlString += "<html>";
		
		htmlString += "<head>";
		htmlString += "<meta charset=\"UTF-8\">";
		htmlString += "<title>Mixed Fraction Division Problems</title>";
		htmlString += "</head>";
		htmlString += "<body>";

		System.out.println(htmlString);
		
		for(int k=0; k<count; k++){
			MixedFractionDivisionProblem s = new MixedFractionDivisionProblem();
			ProblemAndAnswerFraction pa = s.generateProblem(0);
			
			System.out.println( (k+1)+")&nbsp;");
			System.out.println(pa.problemStatement);
			System.out.println("<br/>");
			
			ArrayList<ArrayList<Fraction>> wrongAnswerLists = pa.getWrongAnswerChoices(3,0);
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
				System.out.println("<br/>");
				
			}
			
						
			System.out.println();
			System.out.println("<br/>");
			
		}
		
		System.out.println();
		System.out.println("<br/>");
		System.out.println();
		System.out.println("<br/>");
		System.out.println("--------Answer key--------");
		System.out.println("<br/>");
		for(int k=0; k<count; k++){
			System.out.print(k+1+". ");
			System.out.println(answers[k]);
			System.out.println("<br/>");
			
		}
		
		String htmlString2 = "</body>";
		htmlString2 += "</html>";
		System.out.println(htmlString2);
		
	}
	
	public static void printProblemsWithAnswers(int count){
		
		String htmlString = "<!DOCTYPE html>";
		htmlString += "<html>";
		
		htmlString += "<head>";
		htmlString += "<meta charset=\"UTF-8\">";
		htmlString += "<title>Mixed Fraction Division Problems</title>";
		htmlString += "</head>";
		htmlString += "<body>";

		System.out.println(htmlString);
		for(int k=0; k<count; k++){
			MixedFractionDivisionProblem s = new MixedFractionDivisionProblem();
			ProblemAndAnswerFraction pa = s.generateProblem(0);
			
			System.out.println(pa.problemStatement);			
			String ci = String.format("%s", "Ans");
			printAnswerChoice(ci, pa.correctAnswers);
				
			System.out.println("<br/>");
			
		}
		
		String htmlString2 = "</body>";
		htmlString2 += "</html>";
		System.out.println(htmlString2);
		
	}
	
	public static void printProblemsWithNoAnswerChoices(int count){
		
		String htmlString = "<!DOCTYPE html>";
		htmlString += "<html>";
		
		htmlString += "<head>";
		htmlString += "<meta charset=\"UTF-8\">";
		htmlString += "<title>Mixed Fraction Division Problems</title>";
		htmlString += "</head>";
		htmlString += "<body>";
		
		for(int k=0; k<count; k++){
			MixedFractionDivisionProblem s = new MixedFractionDivisionProblem();
			ProblemAndAnswerFraction pa = s.generateProblem(0);
			
			System.out.println(pa.problemStatement);
			
			for(int i=0; i<20; i++) {
				System.out.println();	
				System.out.println("<br/>");
			
			}
				
		}
		
		String htmlString2 = "</body>";
		htmlString2 += "</html>";
		System.out.println(htmlString2);
		
	}
	
	
}
