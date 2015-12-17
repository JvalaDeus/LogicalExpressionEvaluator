public class logicalExpression {
	static int returnValue = 0;
	static int numVariables = 4;
	static int numCombinations = (int) Math.pow(2, numVariables);
	static boolean[] firstExpVals = new boolean[numCombinations];
	static boolean[] secondExpVals = new boolean[numCombinations];

	public static void main(String[] args) {
		logicalExpression expression = new logicalExpression();
	}

	public logicalExpression() {
		System.out.println("Below is the first expression's truth table");
		returnValue = firstTruthTable();
		System.out.println("");
		System.out.println("");
		System.out.println("Is the first expression valid, contingent, and/or satisfiable?");
		valid();
		contingent();
		satisfiable();
		System.out.println("");
		System.out.println("");
		System.out.println("Below is the second expression's truth table");
		secondTruthTable();
		System.out.println("");
		System.out.println("");
		System.out.println("Are the two expression equivalent?");
		equivalent();
		System.out.println("");
		System.out.println("");
		System.out.println("Does the first expression entail the second?");
		entails();
	}

	public static int firstTruthTable() {
		boolean a, b, c, d;
		boolean result = false;
		a = false;
		int trueCount = 0;
		int falseCount = 0;
		int returnValue = 0;
		int index = 0;
		System.out.println("a\tb\tc\td\t(a && b) && d|| !c");
		do {
			b = false;
			do {
				c = false;
				do {
					d = false;
					do {
						System.out.println(a + "\t" + b + "\t" + c + "\t" + d + "\t" + ((a && b) && d || !c));
						result = ((a && b) && d || !c);
						firstExpVals[index] = result;
						index++;
						if (result == true) {
							trueCount++;
						} else {
							falseCount++;
						}
						d = !d;
					} while (d);
					c = !c;
				} while (c);
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

	public static void secondTruthTable() {
		boolean result = false;
		boolean a, b, c, d;
		int index = 0;
		a = false;
		System.out.println("a\tb\tc\td\t(a || ~b) && d && c");
		do {
			b = false;
			do {
				c = false;
				do {
					d = false;
					do {
						System.out.println(a + "\t" + b + "\t" + c + "\t" + d + "\t" + ((a || !b) && d && c));
						result = ((a || !b) && d && c);
						secondExpVals[index] = result;
						index++;
						d = !d;
					} while (d);
					c = !c;
				} while (c);
				b = !b;
			} while (b);
			a = !a;
		} while (a);
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

	public static int equivalent() {
		int i;
		int equivReturn = 0;
		for (i = 0; i < numCombinations; i++) {
			if (firstExpVals[i] == secondExpVals[i]) {
				equivReturn = 1;
			} else {
				equivReturn = 0;
				break;
			}

		}
		if (equivReturn == 1) {
			System.out.println("The two expressions are equivalent");
		} else {
			System.out.println("The two expressions are not equivalent");
		}
		return equivReturn;
	}

	public static void entails() {
		int i;
		int entailReturn = 0;
		for (i = 0; i < numCombinations; i++) {
			if (firstExpVals[i] == true && secondExpVals[i] == false) {
				entailReturn = 0;
				break;
			} else {
				entailReturn = 1;
			}
		}
		if (entailReturn == 0){
			System.out.println("The first expression does not entail the second expression");
		}
		else{
			System.out.println("The first expression entails the second expression");
		}
	}
}