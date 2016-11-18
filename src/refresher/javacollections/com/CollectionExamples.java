/**
 * 
 */
package refresher.javacollections.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

		System.out.println("++++++++++++++ String (Original) +++++++++++++");
		System.out.println(msg);

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

		if (isPalindrome) {
			System.out.println("String is a palindrome");
		} else {
			System.out.println("String is NOT a palindrome");
		}
		System.out.println("Word Forward:  " + Arrays.toString(fAry));
		System.out.println("Word Backward: " + Arrays.toString(bAry));

		return isPalindrome;
	}

	/**
	 * Parses string into a sorted list of words.
	 * 
	 * @param msg
	 *            The string to convert into a ordered list of words.
	 */
	private static void convertStringIntoSortedList(String msg) {

		System.out.println("++++++++++++++ String (Original) +++++++++++++");
		System.out.println(msg);

		// Replace non-word characters; use the '+' to include repetitive
		// characters.
		String[] _msg = msg.replaceAll("\\W+", " ").replaceAll("\\ +", " ").split(" ");
		List<String> lst = Arrays.asList(_msg);
		Iterator<String> iter = lst.iterator();

		System.out.println("List (Unsorted)");
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();

		System.out.println("List (Sorted)");
		Collections.sort(lst);
		Iterator<String> iter2 = lst.listIterator();
		while (iter2.hasNext()) {
			System.out.print(iter2.next() + " ");
		}
	}

	/**
	 * Sorts list of numbers.
	 * 
	 * @param nums
	 *            The integer array.
	 */
	private static void convertNumbersIntoSortedList(int[] nums) {

		System.out.println("++++++++++++++ Integer Array (Original) +++++++++++++");
		System.out.println(Arrays.toString(nums));

		int[] iAry = nums;
		LinkedList<Integer> iLst = new LinkedList<Integer>();
		for (int i : iAry) {
			iLst.add(Integer.valueOf(i));
		}

		System.out.println("LinkedList (Unsorted)");
		System.out.println(iLst.toString());

		System.out.println("LinkedList (Sorted)");
		Collections.sort(iLst);
		System.out.println(iLst.toString());
	}

	/**
	 * Converts int array into a hashmap with duplicates identified.
	 * 
	 * @param nums
	 *            Integer array to parse.
	 */
	private static void useMapToFindDuplicateNumbers(int[] nums) {

		System.out.println("++++++++++++++ Integer Array (Original) +++++++++++++");
		System.out.println(Arrays.toString(nums));

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
		System.out.println("Hashmap of numbers");
		System.out.println(map.toString());
	}

	/**
	 * Converts string into a hashmap with word instances identified.
	 * 
	 * @param msg
	 *            The string to parse.
	 */
	private static void useMapToFindDuplicateWords(String msg) {

		System.out.println("++++++++++++++ String (Original) ++++++++++++++++");
		System.out.println(msg);

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

		System.out.println("Hashmap of strings and instance counts");
		System.out.println(hash.toString());
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
	public static void parseMatchingCharacters(String input, char opening, char closing) {

		char[] msg = input.toCharArray();
		int len = msg.length;
		System.out.println("++++++++++++++ Original String +++++++++++++");
		System.out.println(msg);

		boolean matched = false;
		boolean ordered = true;

		Stack<Integer> leftList = new Stack<Integer>();
		Stack<Integer> rightList = new Stack<Integer>();

		for (int i = 0; i < len; i++) {

			// check first opening position
			if (msg[0] == opening) {
				ordered = true;
			} else {
				ordered = false;
			}

			// count leftP
			if (msg[i] == opening) {
				leftList.add(i);
			}

			// count rightP
			if (msg[i] == closing) {
				rightList.add(i);
				if (leftList.size() > rightList.size() || leftList.size() > 0) {
					leftList.pop();
					rightList.pop();
					System.out.println("removed tail");
				}
			}

			// check last position
			if (msg[len - 1] == closing && leftList.size() == 0) {
				ordered = true;
			} else {
				ordered = false;
			}
		}

		if (leftList.size() == rightList.size()) {
			matched = true;
		}

		System.out.println("Matched: " + matched);
		System.out.println("Ordered: " + ordered);
		System.out.println("Opening:  " + leftList.size());
		System.out.println("Closing: " + rightList.size());

		System.out.println("Unmatched characters at the following indices: ");
		System.out.println("Left:  " + leftList.toString());
		System.out.println("Right: " + rightList.toString());

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

		if (isFact) {
			System.out.println(num + "! is a factorial: " + factors.toString());
		}

		return isFact;
	}

	public static void main(String[] args) {
		CollectionExamples.isPalindrome("a,b|}c{b+a");
		System.out.println();
		System.out.println();
		CollectionExamples.isPalindrome("Anne. I vote more cars race Rome to Vienna!");
		System.out.println();
		System.out.println();
		CollectionExamples.isPalindrome("A but tuxa");
		System.out.println();
		System.out.println();
		CollectionExamples.convertStringIntoSortedList("hello, world. this is a simple string.");
		System.out.println();
		System.out.println();
		CollectionExamples.convertNumbersIntoSortedList(new int[] { 9, 8, 7, 6, 7, 8, 3, 2, 1, 5, -3 });
		System.out.println();
		System.out.println();
		CollectionExamples.useMapToFindDuplicateNumbers(new int[] { 99, 45, -6, 33, 24, 2, 2, 567, 2, 99, -6 });
		System.out.println();
		System.out.println();
		CollectionExamples.useMapToFindDuplicateWords("Sam I am and am I Sam");
		System.out.println();
		System.out.println();
		CollectionExamples.parseMatchingCharacters("(((()(((", '(', ')');
		System.out.println();
		System.out.println();
		CollectionExamples.parseMatchingCharacters("[[()[[]", '[', ']');
		System.out.println();
		System.out.println();
		CollectionExamples.parseMatchingCharacters("[[()]]", '[', ']');
		System.out.println();
		System.out.println();
		CollectionExamples.parseMatchingCharacters(")))()()(", '(', ')');
		System.out.println();
		System.out.println();
		for(int i=1;i<10000000;i++){
			CollectionExamples.isFactorial(i);
		}
	}

}
