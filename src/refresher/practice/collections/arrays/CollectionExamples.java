/**
 * 
 */
package refresher.practice.collections.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import refresher.practice.binary.Conversion;
import refresher.practice.helpers.LogIt;

/**
 * @author clif
 *
 */
public class CollectionExamples {

	/**
	 * Returns true if the input is a palindrome.
	 * 
	 * @param msg
	 *            The string to test.
	 * @return True if the input is a palindrome.
	 */
	private static boolean isPalindrome(String msg) {

		boolean isPalindrome = false;

		// Strip away blanks and non-word characters and change to lowercase.
		msg = msg.replaceAll("\\W+", "").toLowerCase();
		char[] fAry = msg.toCharArray();
		int len = fAry.length;
		char[] bAry = new char[fAry.length];

		int rIdx = 0;
		for (int i = len - 1; i >= 0; i--) {
			bAry[rIdx] = fAry[i];
			rIdx += 1;
		}

		for (int i = 0; i < len; i++) {
			if (fAry[i] == bAry[i]) {
				isPalindrome = true;
			} else {
				isPalindrome = false;
				break;
			}
		}

		return isPalindrome;
	}

	/**
	 * Parses string into a sorted list of words.
	 * 
	 * @param msg
	 *            The string to convert into a ordered list of words.
	 */
	private static String convertStringIntoSortedList(String msg) {

		// Replace non-word characters; use the '+' to include repetitive
		// characters.
		String[] _msg = msg.replaceAll("\\W+", " ").replaceAll("\\ +", " ").split(" ");
		List<String> lst = Arrays.asList(_msg);
		Collections.sort(lst);
		return lst.toString();
	}

	/**
	 * Sorts list of numbers.
	 * 
	 * @param nums
	 *            The integer array.
	 */
	private static String convertNumbersIntoSortedList(int[] nums) {

		LinkedList<Integer> iLst = new LinkedList<Integer>();
		for (int i : nums) {
			iLst.add(Integer.valueOf(i));
		}

		Collections.sort(iLst);
		return iLst.toString();
	}

	/**
	 * Converts int array into a hashmap with duplicates identified.
	 * 
	 * @param nums
	 *            Integer array to parse.
	 */
	private static String useMapToFindDuplicateNumbers(int[] nums) {

		int[] iAry = nums;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int cnt = 0;
		for (Integer i : iAry) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				cnt = map.get(i);
				cnt += 1;
				map.put(i, cnt);
			}
		}

		return map.toString();
	}

	/**
	 * Converts string into a hashmap with word instances identified.
	 * 
	 * @param msg
	 *            The string to parse.
	 */
	private static String useMapToFindDuplicateWords(String msg) {

		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		String[] lst = msg.replaceAll("\\W+", " ").split(" ");
		int cnt = 0;
		for (String s : lst) {
			if (!hash.containsKey(s)) {
				hash.put(s, 1);
			} else {
				cnt = hash.get(s);
				cnt += 1;
				hash.put(s, cnt);
			}
		}

		return hash.toString();
	}

	/**
	 * Validates string for matching opening and closing characters. Displays
	 * indices of invalid matches.
	 * 
	 * @param input
	 *            The string to test.
	 * @param opening
	 *            The opening character of the pair.
	 * @param closing
	 *            The closing character of the pair.
	 */
	public static boolean hasMatchingBrackets(String input, char opening, char closing) {

		char[] msg = input.toCharArray();
		int len = msg.length;

		Stack<Character> stack = new Stack<Character>();
		int left = 0;
		char elem = ' ';
		boolean matched = false;

		for (int i = 0; i < len; i++) {

			elem = msg[i];

			// The first character must be opening.
			if (stack.isEmpty()) {
				if (elem == opening) {
					stack.add(msg[i]);
					left += 1;
				} else {
					// return false because the characters
					// are unmatched.
					matched = false;
					break;
				}
			} else {

				// add opening
				if (elem == opening) {
					left += 1;
					stack.add(elem);
				} else {

					// pop one off whenever a closing is seen.
					if (left > 0) {
						stack.pop();
						matched = true;
					}
				}
			}
		}

		return matched && stack.isEmpty();

	}

	/**
	 * Returns true if the number is a factorial.
	 * 
	 * @param num
	 *            The integer to test.
	 * @return true is number is a factorial.
	 */
	private static boolean isFactorial(int num) {

		boolean isFact = false;
		int save = 1;
		int incr = 1;
		ArrayList<Integer> factors = new ArrayList<Integer>();

		do {
			factors.add(incr);
			save = save * incr;
			if (save == num) {
				isFact = true;
				break;
			}
			incr += 1;
		} while (save < num);

		return isFact;
	}

	public static void main(String[] args) {
		
	    LogIt logger = new LogIt(CollectionExamples.class.getName()).getLogger();
	    
		CollectionExamples.isPalindrome("a,b|}c{b+a");

		logger.info("isPalindrome", "\"a,b|}c{b+a\"", String.valueOf(isPalindrome("a,b|}c{b+a")));
		logger.info("isPalindrome", "\"Anne. I vote more cars race Rome to Vienna!\"",
				String.valueOf(isPalindrome("Anne. I vote more cars race Rome to Vienna!")));
		logger.info("isPalindrome", "\"A but tuxa\"", String.valueOf(isPalindrome("A but tuxa")));

		logger.info("convertStringIntoSortedList", "\"hello, world. this is a simple string.\"",
				convertStringIntoSortedList("hello, world. this is a simple string."));

		int[] ary1 = { 9, 8, 7, 6, 7, 8, 3, 2, 1, 5, -3 };
		logger.info("convertNumbersIntoSortedList", "" + LogIt.toIntString(ary1), convertNumbersIntoSortedList(ary1));

		int[] ary2 = { 99, 45, -6, 33, 24, 2, 2, 567, 2, 99, -6 };
		logger.info("useMapToFindDuplicateNumbers", LogIt.toIntString(ary2), useMapToFindDuplicateNumbers(ary2));

		String str = "Sam I am and am I Sam";
		logger.info("useMapToFindDuplicateWords", "\"" + str + "\"", useMapToFindDuplicateWords(str));

		String parens = "[[[]]]";
		char leftParen = '[';
		char rightParen = ']';
		logger.info("hasMatchingBrackets", "(\"" + parens + "\",'" + leftParen + "','" + rightParen + "')",
				String.valueOf(hasMatchingBrackets(parens, leftParen, rightParen)));

		parens = "(((()(((";
		leftParen = '(';
		rightParen = '(';
		logger.info("hasMatchingBrackets", "(\"" + parens + "\",'" + leftParen + "','" + rightParen + "')",
				String.valueOf(hasMatchingBrackets(parens, leftParen, rightParen)));

		parens = "[][[[]]]";
		leftParen = '[';
		rightParen = ']';
		logger.info("hasMatchingBrackets", "(\"" + parens + "\",'" + leftParen + "','" + rightParen + "')",
				String.valueOf(hasMatchingBrackets(parens, leftParen, rightParen)));

		parens = ")))()()(";
		leftParen = '(';
		rightParen = ')';
		logger.info("hasMatchingBrackets", "(\"" + parens + "\",'" + leftParen + "','" + rightParen + "')",
				String.valueOf(hasMatchingBrackets(parens, leftParen, rightParen)));

		for (int i = 1; i < 10000000; i++) {
			if (isFactorial(i))
				logger.info("isFactorial", "" + i, String.valueOf(isFactorial(i)));
		}
	}

}
