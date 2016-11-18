/**
 * 
 */
package refresher.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @author clif
 *
 */
public class Misc {

	private String greeting = null;

	public Misc() {

	}

	public void say(String msg) {
		System.out.println(msg);
	}

	public String getSubstring(String searchString, String findThis) {
		String found = "";
		int searchStringLen = searchString.length();
		int findThisLen = findThis.length();
		int startIdx = searchString.indexOf(findThis);
		if (findThisLen > 0 && startIdx > -1) {
			found = searchString.substring(startIdx, startIdx + findThisLen);
		}
		return found;
	}

	public String[] getStringArray(String csvStr) {
		return csvStr.split(",");
	}

	public String getChoice(String question) {
		String resp = "";
		switch (question.trim().toUpperCase()) {
		case "ONE":
			resp = "ONE";
			break;
		case "TWO":
			resp = "TWO";
			break;
		case "THREE":
			resp = "THREE";
			break;
		default:
			break;
		}
		return resp;
	}

	public int getSumOfRandomValue(int maxValue) {
		Random generator = new Random();
		int sum = 0;
		while (sum < maxValue) {
			sum += generator.nextInt(maxValue);
		}
		return sum;
	}

	public boolean findMatch(int maxValue, int findThis) {
		boolean found = false;
		int val = 0;
		Random generator = new Random();
		while (val != findThis) {
			val = generator.nextInt(maxValue);
			System.out.println("val: " + val);
			if (val == findThis) {
				found = true;
				break;
			}
		}
		return found;
	}

	public ArrayList<String> getArrayList() {
		ArrayList<String> ary = new ArrayList<>();
		ary.add("one");
		ary.add("two");
		ary.add("three");
		return ary;
	}

	public ArrayList<Integer> getIntArrayList() {
		ArrayList<Integer> intAryList = new ArrayList<>();
		intAryList.add(1);
		intAryList.add(2);
		intAryList.add(3);
		return intAryList;
	}

	public int getSumForEachIntArray(int maxValue) {
		Random generator = new Random();
		int sum = 0;
		ArrayList<Integer> intAry = new ArrayList<>();
		intAry.add(generator.nextInt(maxValue));
		intAry.add(generator.nextInt(maxValue));
		intAry.add(generator.nextInt(maxValue));
		intAry.add(generator.nextInt(maxValue));

		if (!intAry.isEmpty()) {
			// Show contents
			for (Integer i : intAry) {
				System.out.println("IntAry[" + i + "]: " + i.intValue());
			}

			// Add contents
			for (Integer i : intAry) {
				sum += i.intValue();
			}
		}
		return sum;
	}

	public int[] getCopyOfIntArray(int[] origIntAry) {
		int[] ary = new int[origIntAry.length];
		ary = Arrays.copyOf(origIntAry, ary.length);
		return ary;
	}

	public ArrayList<String> getStringArrayListFromStringArray(String[] origAry) {
		ArrayList<String> newAry = new ArrayList<>(Arrays.asList(origAry));
		return newAry;
	}

	public ArrayList<String> getSortedArrayList(ArrayList<String> origAry) {
		Collections.sort(origAry);
		return origAry;
	}

	public String[] getSortedArray(String[] origAry) {
		Arrays.sort(origAry);
		return origAry;
	}

	public void build2dEquilateralTriangleArray(int side) {
		for (int r = 0; r < side; r++) {
			for (int c = 0; c < (r + 1); c++) {
				System.out.print("x");
			}
			System.out.println("");
		}
	}

	public static double getAverage(double... values) {
		double avg = 0;
		double sum = 0;
		for (int i = 0; i < values.length; i++) {
			sum += values[i];
		}
		avg = sum / values.length;
		return avg;
	}

	public void getMonthCalendar(int yr, int mn) {

		LocalDate date = LocalDate.of(yr, mn, 1);
		String mon = date.getMonth().name();
		mon = mon.substring(0,  3).toUpperCase();
		int maxDays = date.lengthOfMonth();
		System.out.println("          " + mon + " " + date.getYear());

		int day = 0;
		String name = "";
		day = date.get(ChronoField.DAY_OF_WEEK);
		System.out.println("Mon  Tue  Wed  Thu  Fri  Sat  Sun");
		for (int d = 1; d <= maxDays; d++) {
			date = LocalDate.of(yr, mn, d);
			day = date.getDayOfWeek().getValue();
			name = date.getDayOfWeek().toString();
			name = name.substring(0, 3).toLowerCase();
			switch (name) {
			case "mon":
				System.out.printf(" %s", d);
				break;
			case "tue":
				if (d == 1) {
					System.out.printf("      %s", d);
				} else {
					if (d <= 10){
						System.out.printf("    %s", d);
					} else {
						System.out.printf("   %s", d);
					}
				}
				break;
			case "wed":
				if (d == 1) {
					System.out.printf("           %s", d);
				} else {
					if (d <= 10){
						System.out.printf("    %s", d);
					} else {
						System.out.printf("   %s", d);
					}
				}
				break;
			case "thu":
				if (d == 1) {
					System.out.printf("                %s", d);
				} else {
					if (d <= 10){
						System.out.printf("    %s", d);
					} else {
						System.out.printf("   %s", d);
					}
				}
				break;
			case "fri":
				if (d == 1) {
					System.out.printf("                     %s", d);
				} else {
					if (d <= 10){
						System.out.printf("    %s", d);
					} else {
						System.out.printf("   %s", d);
					}
				}
				break;
			case "sat":
				if (d == 1) {
					System.out.printf("                          %s", d);
				} else {
					if (d <= 10){
						System.out.printf("    %s", d);
					} else {
						System.out.printf("   %s", d);
					}
				}
				break;
			case "sun":
				if (d == 1) {
					System.out.printf("                               %s\n", d);
				} else {
					if (d <= 10){
						System.out.printf("    %s\n", d);
					} else {
						System.out.printf("   %s\n", d);
					}
				}
				break;
			}
		}
		System.out.println();
		System.out.println();

	}
	
	public boolean isEqual(String compareThis, String toThat){
		boolean eql = compareThis.equals(toThat);
		System.out.println("Comparing: " + compareThis + " to " + toThat + " > " + eql);
		return eql;
	}
}
