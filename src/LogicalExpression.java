import java.io.IOException;
import java.util.Arrays;

public class logicalExpression {
	static boolean result = false;
	static int returnValue = 0;

	public static void main(String[] args) throws IOException {
		logicalExpression expression = new logicalExpression();
	}

	public logicalExpression() {
		returnValue = truthTable();
		valid();
		contingent();
		satisfiable();
	}

	public static int truthTable() {
		boolean a, b, c, d;
		a = false;
		int trueCount = 0;
		int falseCount = 0;
		int returnValue = 0;
		System.out.println("a\tb\tc\td\t(a && b) && d|| !c");
		do {
			b = false;
			do {
				c = false;
				do {
					d = false;
					System.out.println(a + "\t" + b + "\t" + c + "\t" + d + "\t" + ((a && b) && d || !c));
					result = ((a && b) && d || !c);
					if (result == true) {
						trueCount++;
					} else {
						falseCount++;
					}
					c = !c;
					while (d)
						;
					d = !d;
				} while (c);
				// System.out.println(a + "\t" + b + "\t" + (a && b));
				b = !b;
			} while (b);
			a = !a;
		} while (a);

		if (trueCount == 0) {
			returnValue = -1;
		} else if (falseCount == 0) {
			returnValue = 1;
		} else {
			returnValue = 0;
		}
		return returnValue;
	}

	public static int secondTruthTable() {
		boolean a, b, c, d;
		a = false;
		int trueCount = 0;
		int falseCount = 0;
		int returnValue = 0;
		System.out.println("a\tb\tc\td\t(a && b) && d|| !c");
		do {
			b = false;
			do {
				c = false;
				do {
					d = false;
					System.out.println(a + "\t" + b + "\t" + c + "\t" + d + "\t" + ((a && b) && d || !c));
					result = ((a && b) && d || !c);
					if (result == true) {
						trueCount++;
					} else {
						falseCount++;
					}
					c = !c;
					while (d)
						;
					d = !d;
				} while (c);
				// System.out.println(a + "\t" + b + "\t" + (a && b));
				b = !b;
			} while (b);
			a = !a;
		} while (a);

		if (trueCount == 0) {
			returnValue = -1;
		} else if (falseCount == 0) {
			returnValue = 1;
		} else {
			returnValue = 0;
		}
		return returnValue;
	}

	public static void valid() {
		if (returnValue == 1) {
			System.out.println("The expression is valid");
		} else {
			System.out.println("The expression is not valid");
		}
	}

	public static void contingent() {
		if (returnValue == 0) {
			System.out.println("The expression is contingent");
		} else {
			System.out.println("The expression is not contingent");
		}
	}

	public static void satisfiable() {
		if (returnValue == -1) {
			System.out.println("The expression is not satisfiable");
		} else {
			System.out.println("The expression is satisfiable");
		}
	}

	public static void equivalent() {

	}

	public static void entails() {

	}
}