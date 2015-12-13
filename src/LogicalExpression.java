import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LogicalExpression {
	static String expression;
	static int numVariables;
	static String[] varArray = new String[5];

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
				continue;
			case "~":
				continue;
			case "|":
				continue;
			case " ":
				continue;
			case "(":
				continue;
			case ")":
				continue;
			default:
				if (numVariables == 0) {
					varArray[numVariables] = expChar;
					numVariables++;
				} else {
					for (int j = 0; j < numVariables; j++) {
						if (expChar.equals(varArray[j])) {
							break;
						} else {
							varArray[numVariables] = expChar;
							numVariables++;
						}
					}
				}
			}
		}
	}
}