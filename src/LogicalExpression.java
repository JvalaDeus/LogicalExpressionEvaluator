/**
 * This program takes two expressions. The two expressions are hard coded into
 * their truth table methods. To change them you must change the operators for
 * their method.First it calls the constructor which calls the methods. The
 * first method the constructor calls is the first expression's truth table. It
 * then prints the truth table and finds if the expression is valid, contingent,
 * and/or satisfiable. Then it prints the second expression's truth table. Then
 * it finds if the two expressions are equivalent. Finally it finds if the first
 * expression entails the second expression. The program, of course, prints all
 * of this out.
 */
public class logicalExpression {
	/**
	 * The following are the global variables used in the arrays. The arrays are
	 * used to store the boolean results of each truth table combination for
	 * each expression.
	 */
	static int returnValue = 0;
	static int numVariables = 4;
	static int numCombinations = (int) Math.pow(2, numVariables);
	static boolean[] firstExpVals = new boolean[numCombinations];
	static boolean[] secondExpVals = new boolean[numCombinations];

	// This is the main method, it calls the constructor
	public static void main(String[] args) {
		logicalExpression expression = new logicalExpression();
	}

	// this is the constructor, it calls all the methods and prints the results
	// of each method
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

	/**
	 * This is the first expression's truth table. It starts with 4 variabls (I
	 * can change the size by adding more variables and adding another do/while
	 * loop. It prints out the title, which is each variable, and the
	 * expression. Then it sets each variable to all the different combinations
	 * using do/while loops. It increases trueCount & falseCount, in a for loop,
	 * which are used in the satisfiable, contingent, and valid methods to find
	 * out which of those the expression is, by setting a integer to a certain
	 * number that is used in the previously mentioned methods.
	 */
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

	/**
	 * This is the second expression's truth table. It does the exact same
	 * things as the first expression's truth table. Except it does not test for
	 * validity, contingency, and/or satisfiablity.
	 */
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

	/**
	 * Valid tests if the first expression is valid. To be valid the expression
	 * must always be true. So it tests if the return value (from the first
	 * expression truth table method) is 1 (always true), 0 (sometimes true), or
	 * -1 (never true). If it is 1 (always true), it prints that the expression
	 * is valid.
	 */
	public static void valid() {
		if (returnValue == 1) {
			System.out.println("The expression is valid");
		} else {
			System.out.println("The expression is not valid");
		}
	}

	/**
	 * Just like the valid method, it checks the return value of the first
	 * expression's truth table. Contingent means that it must not have all true
	 * evaluations, or all false evaluations. If it is 0 (sometimes true,
	 * sometimes false), it is contingent and prints that it is. If it is 1 or
	 * -1, it prints that it is not contingent.
	 */
	public static void contingent() {
		if (returnValue == 0) {
			System.out.println("The expression is contingent");
		} else {
			System.out.println("The expression is not contingent");
		}
	}

	/**
	 * Just like the previous two. Satisfiable means that at least one
	 * evaluation is = true. So if it sees that the return value is not -1
	 * (never true) it prints that the expression is satisfiable. If it is -1,
	 * then it prints that it is not satisfiable.
	 */
	public static void satisfiable() {
		if (returnValue == -1) {
			System.out.println("The expression is not satisfiable");
		} else {
			System.out.println("The expression is satisfiable");
		}
	}

	/**
	 * Equivalent checks the both the expressions' truth values in their arrays.
	 * The values must always be the same. If the two values are always the same
	 * in each position, then they are equivalent. Else, they are not
	 * equivalent. This is checked by setting the equivReturn int to 1 if they
	 * are the same and 0 if they are not the same. If they are not the same,
	 * the for loop breaks. When the loop ends, it checks equivReturn's value.
	 * If it is 1, it prints that they are the same. If it is 0, it prints that
	 * they are not the same.
	 */
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

	/**
	 * Entails works the same as equivalent. It checks through a for loop the
	 * values in each position for each expression. If the first expression is
	 * true, and teh secon is false at the same position, then the first does
	 * not entail the second. Otherwise, they do entail each other. It checks in
	 * the same way as equivalent. It set entailReturn to 0 if the first is true
	 * and the second is false, then breaks. Otherwise, it sets it to 1. When
	 * the loop ends, it checks the value. If entailReturn = 1, it prints that
	 * the first entails the second. If it equals 0, it prints that the first
	 * does not entail the second.
	 */
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
		if (entailReturn == 0) {
			System.out.println("The first expression does not entail the second expression");
		} else {
			System.out.println("The first expression entails the second expression");
		}
	}
}