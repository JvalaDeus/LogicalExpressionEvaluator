import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LogicalExpression {
	static String expression;
	static int numVariables = 0;

	public static void main(String[] args) throws IOException {
		LogicalExpression expression = new LogicalExpression();
		countVariables();
	}

	public LogicalExpression() throws IOException {
		System.out.println("For this program, only use a-z. Also, only use parenthesis, and, or, or negate");
		System.out.println("And is &, or is |, negate is ~, and parenthesis are ().");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Type expression in: ");
		expression = br.readLine();
	}

	public static void countVariables() {
		int ExpLength = expression.length();
		String expChar;
		for (int i = 0; i < ExpLength; i++) {
			expChar = Character.toString(expression.charAt(i));
			switch (expChar) {
			case "&":
				System.out.println("Hit &");
				continue;
			case "~":
				System.out.println("Hit ~");
				continue;
			case "|":
				System.out.println("Hit |");
				continue;
			case " ":
				System.out.println("Hit space");
				continue;
			default:
				numVariables++;
			}
		}
		System.out.println(ExpLength);
		System.out.println(numVariables);
	}
}