/**
 * 
 */
package refresher.javacollections.com;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author clif
 *
 */
public class Question7 {

	/**
	 * Filters values that meet criteria. Assumes 0 <= lowest < highest. This
	 * will strip the negative sign, essentially converting any negative number
	 * into a positive number.
	 * 
	 * @param lowest
	 *            - An integer that is < highest.
	 * @param highest
	 *            - An integer that is > lowest.
	 * @return An array of integers that satisfy criteria.
	 */
	public static int[] findNumberEqualToSumOfDigitsToPowerOfLength(int lowest, int highest) {

		ArrayList<Integer> tmpAry = new ArrayList<Integer>();
		int power = 0;
		int sum = 0;
		int tmpValue = 0;
		int tmpSum = 0;
		char[] parsedNumber = null;

		for (int i = lowest; i <= highest; i++) {

			sum = 0;
			parsedNumber = String.valueOf(i).toCharArray();
			power = parsedNumber.length;

			// add up the calculated result of each digit
			for (int j = 0; j < parsedNumber.length; j++) {
				try {
					tmpValue = Integer.parseInt(String.valueOf(parsedNumber[j]), 10);
					tmpSum = (int) Math.round(Math.pow(tmpValue, power));
					sum += tmpSum;
				} catch (NumberFormatException nfe) {
					// do nothing
				}
			}

			// build array of values that work.
			if (sum == i) {
				tmpAry.add(i);
			}

		}

		// convert back into int[].
		int[] outAry = new int[tmpAry.size()];
		for (int i = 0; i < tmpAry.size(); i++) {
			outAry[i] = tmpAry.get(i);
		}

		return outAry;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] sortedAry = Question7.findNumberEqualToSumOfDigitsToPowerOfLength(-10, 153);
		System.out.println("Array of Values: " + Arrays.toString(sortedAry));
		sortedAry = Question7.findNumberEqualToSumOfDigitsToPowerOfLength(10, 999);
		System.out.println("Array of Values: " + Arrays.toString(sortedAry));
		sortedAry = Question7.findNumberEqualToSumOfDigitsToPowerOfLength(10, 999999);
		System.out.println("Array of Values: " + Arrays.toString(sortedAry));
		sortedAry = Question7.findNumberEqualToSumOfDigitsToPowerOfLength(999999, 999999);
		System.out.println("Array of Values: " + Arrays.toString(sortedAry));
	}

}
