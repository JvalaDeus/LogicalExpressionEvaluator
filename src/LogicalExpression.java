import java.io.IOException;
import java.util.Arrays;

public class logicalExpression {
	static String firstExpression = "a | b";
	static String secondExpression = "a & b";
	static int numVariables;
	static String[] varArray = new String[2];

	public static void main(String[] args) throws IOException {
		logicalExpression expression = new logicalExpression();
		variableValues values = new variableValues(null, false);
		countVariables();
	}

	public logicalExpression() {
		operations();
		valid();
		contingent();
		satisfiable();
	}

	public static void countVariables() {
		int ExpLength = firstExpression.length();
		String expChar;
		for (int i = 0; i < ExpLength; i++) {
			expChar = Character.toString(firstExpression.charAt(i));
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
					value[numVariables] = expChar;
					numVariables++;
				} else {
					for (int j = 0; j < numVariables; j++) {
						if (expChar.equals(varArray[j])) {
							break;
						} else {
							value[numVariables] = expChar;
							numVariables++;
						}
					}
				}
			}
		}
		System.out.println(Arrays.toString(varArray));
	}

	public static void truthTable() {

	}

	public static void paraenthesis() {

	}

	public static void negate() {

	}

	public static void and() {

	}

	public static void or() {

	}

	public static void operations() {
		paraenthesis();
		negate();
		and();
		or();
	}

	public static void valid() {

	}

	public static void contingent() {

	}

	public static void satisfiable() {

	}

	public static void entails() {

	}

	public static void equivalent() {

	}
}