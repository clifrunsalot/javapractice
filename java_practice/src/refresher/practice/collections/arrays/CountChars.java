package refresher.practice.collections.arrays;

import refresher.practice.helpers.LogIt;

public class CountChars {

	private static LogIt logger = new LogIt(CountChars.class.getName());

	/**
	 * Returns sum of the times <code>find</code> appears in the
	 * <code>inThis</code>.
	 * 
	 * @param find
	 *            The string to find.
	 * @return The count.
	 */
	public static int countCharacters(String find, String inThis) {

		int sum = 0;
		String tmp = "";
		for (int i = 0; i <= (inThis.length() - 1); i++) {
			tmp = inThis.substring(i, inThis.length());
			if (tmp.startsWith(find))
				sum += 1;
		}

		return sum;
	}

	public static void main(String[] args) {

		logger.logFunc("countCharacters", "xx,abcxx", "" + countCharacters("xx", "abcxx"));
		logger.logFunc("countCharacters", "xx,xxx", "" + countCharacters("xx", "xxx"));
		logger.logFunc("countCharacters", "xx,xxxx", "" + countCharacters("xx", "xxxx"));

	}

}
