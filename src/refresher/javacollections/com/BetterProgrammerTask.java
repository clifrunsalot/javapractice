/**
 * 
 */
package refresher.javacollections.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author clif
 *
 */
public class BetterProgrammerTask {

	/**
	 * Filters array for positive integers. Assumes array length > 0.
	 * 
	 * @param a
	 *            - Array of unsorted integers
	 * @return Sorted array on positive integers
	 */
	public static int[] retainPositiveNumbers(int[] a) {

		ArrayList<Integer> tmpAry = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				tmpAry.add(a[i]);
			}
		}

		Collections.sort(tmpAry);

		int[] outAry = new int[tmpAry.size()];
		for (int i = 0; i < tmpAry.size(); i++) {
			outAry[i] = tmpAry.get(i);
		}

		return outAry;
	}

	public static void main(String[] args) {

		int[] unsortedAry = { 9, -8, 7, -6, 5, -4, 3, -2, 1 };
		int[] sortedPosAry = retainPositiveNumbers(unsortedAry);
		System.out.println("Sorted, Positive Integer Array: " + Arrays.toString(sortedPosAry));

	}

}
