/**
 *
 */
package refresher.practice.exceptions;

import refresher.practice.helpers.LogIt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

/**
 * Demonstrates exception processing.
 */
public class StackTrace {

    static LogIt logger = new LogIt(StackTrace.class.getName());

    private static void useExceptions() {

        try {

            String[] myStrList = {"two", "1"};
            List<String> myList = new ArrayList<String>(Arrays.asList(myStrList));
            for (String s : myList) {
                if (Integer.parseInt(s) == 1)
                    throw new NullPointerException();
                else
                    throw new NumberFormatException();
            }

        } catch (NullPointerException | NumberFormatException e) {
            if (e instanceof NullPointerException) {
                logger.getLogger().log(Level.SEVERE, "caught npe");
            } else if (e instanceof NumberFormatException) {
                logger.getLogger().log(Level.SEVERE, "caught iobe");
            }
        } finally {
            logger.getLogger().log(Level.INFO, "Done");
        }

        final String myFile = "C:\\Users\\clif\\workspace\\java_practice\\src\\refresher\\armediatest\\com\\event.txt";
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(myFile))) {
            while ((line = br.readLine()) != null) {
                logger.getLogger().log(Level.INFO, line);
                if (line.contains("kittens")) {
                    logger.getLogger().log(Level.SEVERE, "found kitten");
                }
            }
        } catch (IOException e) {
            logger.getLogger().log(Level.SEVERE, e.getLocalizedMessage());
        } finally {
            logger.getLogger().log(Level.INFO, "Done reading file");
        }

    }

    public static void main(String[] args) {
        StackTrace.useExceptions();
    }

}

