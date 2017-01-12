package refresher.practice.collections.map;

import java.util.Arrays;
import java.util.HashMap;

import refresher.practice.binary.Conversion;
import refresher.practice.helpers.LogIt;

public class Unique {

	/*
	 * Returns the unpaired value in array pairs
	 * 
	 * e.g. 
	 * 
	 * findUnpairedValues([1, 1, 2, 2, 4, 5, 5, 5, 98, 98]) => 4
	 * findUnpairedValues([3, 3, 6, 6, 7, 8, 8, 9, 9, 9]) => 7
	 * findUnpairedValues([7, 7, 1, 1, 4, 4, 2, 9, 9, 33, 33, 33]) => 2
	 * findUnpairedValues([888, 888, 5, 5, 1, 2, 2, 4, 4]) => 1
	 * findUnpairedValues([77, 65, 65, 3, 3]) => 77
	 * findUnpairedValues([1, 1]) => 0
	 * findUnpairedValues([]) => 0
	 */
	private static int findUnpairedValues(int[] pairs) {

		HashMap<Integer, Integer> matches = new HashMap<Integer, Integer>();

		int unpaired = 0;
		int count = 0;
		if (pairs.length > 0) {

			for (int value : pairs) {
				count = 0;
				if (matches.containsKey(value)) {
					count = matches.get(value);
					count += 1;
					matches.put(value, count);
				} else {
					matches.put(value, 1);
				}
			}
		}

		for (int value : matches.keySet()) {

			count = matches.get(value);
			if (count == 1) {
				unpaired = value;
				break;
			}

		}
		return unpaired;
	}

	public static void main(String[] args) {

	    LogIt logger = new LogIt(Unique.class.getName()).getLogger();
	    
	    int[] ary1 = { 1, 1, 2, 2, 4, 5, 5, 5, 98, 98 };
		logger.info("findUnpairedValues", LogIt.toIntString(ary1), "" + findUnpairedValues(ary1));

		int[] ary2 = { 3, 3, 6, 6, 7, 8, 8, 9, 9, 9 };
		logger.info("findUnpairedValues", LogIt.toIntString(ary2), "" + findUnpairedValues(ary2));

		int[] ary3 = { 7, 7, 1, 1, 4, 4, 2, 9, 9, 33, 33, 33 };
		logger.info("findUnpairedValues", LogIt.toIntString(ary3), "" + findUnpairedValues(ary3));

		int[] ary4 = { 888, 888, 5, 5, 1, 2, 2, 4, 4 };
		logger.info("findUnpairedValues", LogIt.toIntString(ary4), "" + findUnpairedValues(ary4));

		int[] ary5 = { 77, 65, 65, 3, 3 };
		logger.info("findUnpairedValues", LogIt.toIntString(ary5), "" + findUnpairedValues(ary5));

		int[] ary6 = { 1, 1 };
		logger.info("findUnpairedValues", LogIt.toIntString(ary6), "" + findUnpairedValues(ary6));

		int[] ary7 = new int[0];
		logger.info("findUnpairedValues", LogIt.toIntString(ary7), "" + findUnpairedValues(ary7));

	}

}
