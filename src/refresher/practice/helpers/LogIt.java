package refresher.practice.helpers;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogIt {

    private Logger logger;

    public LogIt(String className) {
        this.logger = Logger.getLogger(className);
    }

    public Logger getLogger() {
        return this.logger;
    }

    public void logFunc(String funcName, String input, String result) {
        String message = String.format("%-2s(%s) => %s\n", funcName, input, result);
        logger.log(Level.INFO, message);
    }

    public static <T> String toNonPrimString(T[] ary) {
        return Arrays.toString(ary);
    }

    public static String toByteString(byte[] ary) {
        return Arrays.toString(ary);
    }

    public static String toIntString(int[] ary) {
        return Arrays.toString(ary);
    }

    public static String toDblString(double[] ary) {
        return Arrays.toString(ary);
    }

}
