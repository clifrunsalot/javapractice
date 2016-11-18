/**
 * 
 */
package refresher.javacollections.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author clif
 *
 */
public class ExceptionExamples {

	private static void logIt(String s) {
		System.out.println(s);
	}

	private static void useExceptions() {

		try {

			String[] myStrList = { "two", "1" };
			List<String> myList = new ArrayList<String>(Arrays.asList(myStrList));
			for (String s : myList) {
				if (Integer.parseInt(s) == 1)
					throw new NullPointerException();
				else
					throw new NumberFormatException();
			}

		} catch (NullPointerException | NumberFormatException e) {
			if (e instanceof NullPointerException) {
				logIt("caught npe");
			} else if (e instanceof NumberFormatException) {
				logIt("caught iobe");
			}
		} finally {
			logIt("Done");
		}

		final String myFile = "C:\\Users\\clif\\workspace\\java_practice\\src\\refresher\\armediatest\\com\\event.txt";
		String line = "";
		try (BufferedReader br = new BufferedReader(new FileReader(myFile))) {
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				if (line.contains("kittens")) {
					System.out.println("found kitten");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Done reading file");
		}

	}

	public static void main(String[] args) {
		ExceptionExamples.useExceptions();
	}

}

//************ Output ***********************
//	caught iobe
//	Done
//	one
//	two
//	kittens
//	found kitten
//	cats
//	dogs
//	Done reading file
