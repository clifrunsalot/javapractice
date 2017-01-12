/**
 * 
 */
package refresher.practice.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import refresher.practice.helpers.LogIt;

/**
 * @author clif
 *
 */
public class StackTrace {

    static LogIt logger = new LogIt(StackTrace.class.getName()).getLogger();

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
				logger.error("caught npe");
			} else if (e instanceof NumberFormatException) {
				logger.error("caught iobe");
			}
		} finally {
			logger.info("Done");
		}

		final String myFile = "C:\\Users\\clif\\workspace\\java_practice\\src\\refresher\\armediatest\\com\\event.txt";
		String line = "";
		try (BufferedReader br = new BufferedReader(new FileReader(myFile))) {
			while ((line = br.readLine()) != null) {
				logger.info(line);
				if (line.contains("kittens")) {
					logger.info("found kitten");
				}
			}
		} catch (IOException e) {
			logger.error(e.getLocalizedMessage());
		} finally {
			logger.info("Done reading file");
		}

	}

	public static void main(String[] args) {
		StackTrace.useExceptions();
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
