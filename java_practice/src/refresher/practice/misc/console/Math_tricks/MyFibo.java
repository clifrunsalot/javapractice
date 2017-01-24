package refresher.practice.misc.console.Math_tricks;

import java.util.ArrayList;
import java.util.Arrays;

import refresher.practice.helpers.LogIt;

public class MyFibo {

	private static LogIt logger = new LogIt(MyFibo.class.getName());
	private static ArrayList<Integer> fibs = new ArrayList<Integer>();

	/**
	 * Recursively adds fibonacci numbers up to but excluding the
	 * <code>lastNbr</code>.
	 * 
	 * @param start
	 *            The first number to add.
	 * @param sum
	 *            The expected sum.
	 * @param lastNbr
	 *            The last number up to which the sequence is calculated.
	 */
	private static void getFibo(int start, int sum, int lastNbr) {

		int newStart = sum;
		sum = start + sum;
		if (sum != lastNbr) {
			fibs.add(sum);
			getFibo(newStart, sum, lastNbr);
		}

	}

	public static void main(String[] args) {

		int lastNbr = 317811;
		getFibo(0, 1, lastNbr);
		logger.getLogger().info("Fibonacci numbers for " + lastNbr + "\n");
		logger.getLogger().info(Arrays.toString(fibs.toArray()));

	}

}
