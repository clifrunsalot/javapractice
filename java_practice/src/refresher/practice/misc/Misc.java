/**
 *
 */
package refresher.practice.misc;

import refresher.practice.helpers.LogIt;

import java.util.Arrays;

/**
 * Miscellaneous.
 */
public class Misc {

    private static LogIt logger = new LogIt(Misc.class.getName());

    private String greeting = null;

    /**
     * Returns substring of findThis in searchString.
     *
     * @param searchString
     * @param findThis
     * @return The string or -1.
     */
    private static String getSubstring(String searchString, String findThis) {
        return (searchString.indexOf(findThis) != -1) ? searchString.substring(searchString.indexOf(findThis))
                : "Not found";
    }

    /**
     * Returns a string array of the comma-delimited string.
     *
     * @param csvStr A comma-delimited string.
     * @return The string array.
     */
    private static String[] getStringArray(String csvStr) {
        return csvStr.split(",");
    }

    /**
     * Returns the results of a simple switch.
     *
     * @param question A string value of one of the switch cases.
     * @return The value of the case matched.
     */
    private static String getChoice(String question) {
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

    /**
     * Returns a sorted string array.
     *
     * @param origAry An unsorted string array.
     * @return The sorted string array.
     */
    private static String[] getSortedArray(String[] origAry) {
        Arrays.sort(origAry);
        return origAry;
    }

    /**
     * Prints a triangle.
     *
     * @param side The length of one side.
     * @return True if side is greater than 0.
     */
    private static boolean build2dEquilateralTriangleArray(int side) {
        if (side > 0) {
            for (int r = 0; r < side; r++) {
                for (int c = 0; c < (r + 1); c++) {
                    System.out.print("x");
                }
                System.out.println("");
            }
            return true;
        }
        return false;
    }

    /**
     * Returns the average of the array of doubles passed in.
     *
     * @param values double []
     * @return The average.
     */
    private static double getAverage(double... values) {
        double avg = 0;
        double sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        avg = sum / values.length;
        return avg;
    }

    public static void main(String[] args) {

        logger.logFunc("getSubstring", "\"" + "woodrose" + "\",\"" + "rose", getSubstring("woodrose", "rose"));
        logger.logFunc("getSubstring", "\"" + "woodrose" + "\",\"" + "pose", getSubstring("woodrose", "pose"));

        logger.logFunc("getStringArray", "\"w,o,o,d,r,o,s,e\"", LogIt.toNonPrimString(getStringArray("w,o,o,d,r,o,s,e")));

        logger.logFunc("getChoice", "\"one\"", getChoice("one"));

        // getSortedArray(String[] origAry) {
        String[] ary = {"one", "two", "three", "four", "five"};
        logger.logFunc("getSortedArray", LogIt.toNonPrimString(ary), LogIt.toNonPrimString(getSortedArray(ary)));

        // build2dEquilateralTriangleArray(int side) {
        logger.logFunc("build2dEquilateralTriangleArray", "8", "");
        build2dEquilateralTriangleArray(8);

        // getAverage(double... values) {
        double[] ary1 = {7, 6, 5, 4, 8, 9, 0};
        logger.logFunc("getAverage", LogIt.toDblString(ary1), "" + getAverage(ary1));

    }
}
