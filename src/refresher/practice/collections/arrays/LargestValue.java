/**
 * 
 */
package refresher.practice.collections.arrays;

import refresher.practice.helpers.LogIt;

/**
 * @author clif
 *
 */
public class LargestValue {

	static int getLargestValue(int[] ary) {
		int smallest = -1_000_000_000;
		int largest = smallest;
		for (int i = 0; i < ary.length; i++) {
			if (smallest < ary[i]) {
				largest = ary[i];
				smallest = largest;
			}
		}
		return largest;
	}

	public static void main(String[] args) {

		LogIt logger = new LogIt(LargestValue.class.getName());

		int[] ary1 = new int[] { 12, 34, 1, 0, 999, 1_000_999, -2 };
		int[] ary2 = new int[] { -2, -1, -999, -1_000_999, -999 };
		int[] ary3 = new int[] { -999999, -888888, -777777, -666666, 0, 1 };

		logger.info("getLargestValue",LogIt.toIntString(ary1),"" + getLargestValue(ary1));
		logger.info("getLargestValue",LogIt.toIntString(ary2),"" + getLargestValue(ary2));
		logger.info("getLargestValue",LogIt.toIntString(ary3),"" + getLargestValue(ary3));
	}

}

// +++++++++++++ OUTPUT ++++++++++++++
// Largest Value: 1000999
// Largest Value: -1
// Largest Value: 1
