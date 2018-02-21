import java.util.ArrayList;
import java.util.Random;

public class FractionAdditionProblem implements IAlgebraProblemFraction{

	private Fraction f1 = new Fraction();
	private Fraction f2 = new Fraction();
	
	
	public FractionAdditionProblem(){
		
		
			Random r = new Random();
			int n = r.nextInt(10)+1;
			int d = r.nextInt(5)+5;
		
			f1.set(n, d);			
		
			int n2 = r.nextInt(10)+1;
			int d2 = r.nextInt(5)+5;
		
			f2.set(n2, d2);
			
		
	}
	
	@Override
	public ProblemAndAnswerFraction generateProblem(int category){
		
		ProblemAndAnswerFraction pna = new ProblemAndAnswerFraction();
		
		pna.problemStatement = f1.getFractionHTMLString()+"&nbsp;"+"+"+"&nbsp;"+f2.getFractionHTMLString();
		Fraction fdiv = Fraction.add(f1, f2);
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
	
	private static void printHTMLHeader() {
		String htmlString = "<!DOCTYPE html>";
		htmlString += "<html>";
		
		htmlString += "<head>";
		htmlString += "<meta charset=\"UTF-8\">";
		htmlString += "<title>Fraction Addition Problems</title>";
		htmlString += "</head>";
		htmlString += "<body>";

		System.out.println(htmlString);

	}
	
	public static void printHTMLTail() {
		String htmlString2 = "</body>";
		htmlString2 += "</html>";
		System.out.println(htmlString2);
		
	}
	
	public static void printProblemsWithMultipleChoiceAnswers(int count){
		String[] answers = new String[count];
		
		printHTMLHeader();
				
		for(int k=0; k<count; k++){
			FractionAdditionProblem s = new FractionAdditionProblem();
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
		
		printHTMLTail();
	}
	
	public static void printProblemsWithAnswers(int count){
		
		printHTMLHeader();
		for(int k=0; k<count; k++){
			FractionAdditionProblem s = new FractionAdditionProblem();
			ProblemAndAnswerFraction pa = s.generateProblem(0);
			
			System.out.println(pa.problemStatement);			
			String ci = String.format("%s", "Ans");
			printAnswerChoice(ci, pa.correctAnswers);
				
			System.out.println("<br/>");
			
		}
		printHTMLTail();
	}
	
	public static void printProblemsWithNoAnswerChoices(int count){
		
		printHTMLHeader();
		for(int k=0; k<count; k++){
			FractionAdditionProblem s = new FractionAdditionProblem();
			ProblemAndAnswerFraction pa = s.generateProblem(0);
			
			System.out.println(pa.problemStatement);
			
			for(int i=0; i<20; i++) {
				System.out.println();	
				System.out.println("<br/>");
			
			}
				
		}
		printHTMLTail();
	}
	
	
}
