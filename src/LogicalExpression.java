import java.io.IOException;
import java.util.Arrays;

public class logicalExpression {
	static String firstExpression = "a | b";
	static String secondExpression = "a & b";
	static int numVariables;
	static String[] varArray = new String[2];

	public static void main(String[] args) throws IOException {
		logicalExpression expression = new logicalExpression();
	}

	public logicalExpression() {
		countVariables();
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
		System.out.println(Arrays.toString(varArray));
	}

	public static void truthTable() {
		boolean a, b, c;
		a = false;
		System.out.println("a\tb\tc\t(a && b) && a|| !c");
		do {
			b = false;
			do {
				c = false;
				do {
					System.out.println(a + "\t" + b + "\t" + c + "\t" + ((a && b) && a  || !c));
					c = !c;
				} while (c);
				// System.out.println(a + "\t" + b + "\t" + (a && b));
				b = !b;
			} while (b);
			a = !a;
		} while (a);
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