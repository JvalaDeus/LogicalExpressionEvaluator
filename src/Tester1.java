
public class Tester1 {

	public static void main(String[] args) {
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
}
