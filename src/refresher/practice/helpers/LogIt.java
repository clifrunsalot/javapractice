package refresher.practice.helpers;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A wrapper for the default Logger. Mainly for formatting
 * function output results.
 */
public class LogIt {

    private Logger logger;

    /**
     * Constructor.
     *
     * @param className The name of the class used by the logger.
     */
    public LogIt(String className) {
        this.logger = Logger.getLogger(className);
    }

    /**
     * Returns a logger reference for using the default logging.
     *
     * @return A logger.
     */
    public Logger getLogger() {
        return this.logger;
    }

    /**
     * Prints a formatted string of the function, its arguments, and results.
     *
     * @param funcName The function name.
     * @param input    The input argument(s).
     * @param result   The output.
     */
    public void logFunc(String funcName, String input, String result) {
        String message = String.format("%-2s(%s) => %s\n", funcName, input, result);
        logger.log(Level.INFO, message);
    }

    /**
     * Returns a formatted string version of input array.
     *
     * @param ary The array of non-primitive type.
     * @param <T> The type of array.
     * @return The string version.
     */
    public static <T> String toNonPrimString(T[] ary) {
        return Arrays.toString(ary);
    }

    /**
     * int
     * Returns a formatted string version of input array.
     *
     * @param ary The array of byte type.
     * @return The string version.
     */
    public static String toByteString(byte[] ary) {
        return Arrays.toString(ary);
    }

    /**
     * Returns a formatted string version of input array.
     *
     * @param ary The array of byte type.
     * @return The string version.
     */
    public static String toIntString(int[] ary) {
        return Arrays.toString(ary);
    }

    /**
     * Returns a formatted string version of input array.
     *
     * @param ary The array of double type.
     * @return The string version.
     */
    public static String toDblString(double[] ary) {
        return Arrays.toString(ary);
    }

}
