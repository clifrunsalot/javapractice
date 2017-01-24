/**
 *
 */
package refresher.practice.collections.arrays;

import java.util.ArrayList;

import refresher.practice.helpers.LogIt;

/**
 * @author clif
 */
public class SumPower {

    /**
     * Returns an array of all integers between lowest and highest where each
     * value equals the sum of each digit to the power of the value's length.
     * <p>
     * e.g. (-10, 153) => [153]
     *
     * @param lowest  - An integer that is 0 < x < highest.
     * @param highest - An integer that is > lowest.
     * @return An array of integers that satisfy criteria.
     */
    public static int[] findSumPower(int lowest, int highest) {

        ArrayList<Integer> tmpAry = new ArrayList<Integer>();
        int power = 0;
        int sum = 0;
        int tmpValue = 0;
        int tmpSum = 0;
        char[] parsedNumber = null;
        lowest = Math.abs(lowest);
        highest = Math.abs(highest);

        for (int i = lowest; i <= highest; i++) {

            sum = 0;
            parsedNumber = String.valueOf(i).toCharArray();
            power = parsedNumber.length;

            // add up the calculated result of each digit
            for (int j = 0; j < parsedNumber.length; j++) {
                try {
                    tmpValue = Integer.parseInt(String.valueOf(parsedNumber[j]), 10);
                    tmpSum = (int) Math.round(Math.pow(tmpValue, power));
                    sum += tmpSum;
                } catch (NumberFormatException nfe) {
                    // do nothing
                }
            }

            // build array of values that work.
            if (sum == i) {
                tmpAry.add(i);
            }

        }

        // convert back into int[].
        int[] outAry = new int[tmpAry.size()];
        for (int i = 0; i < tmpAry.size(); i++) {
            outAry[i] = tmpAry.get(i);
        }

        return outAry;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        LogIt logger = new LogIt(SumPower.class.getName());

        int lowest = -10;
        int highest = 153;
        logger.logFunc("findSumPower", "" + -10 + "," + highest, LogIt.toIntString(findSumPower(lowest, highest)));

        lowest = 10;
        highest = 999;
        logger.logFunc("findSumPower", "" + -10 + "," + highest, LogIt.toIntString(findSumPower(lowest, highest)));

        lowest = 10;
        highest = 999999;
        logger.logFunc("findSumPower", "" + -10 + "," + highest, LogIt.toIntString(findSumPower(lowest, highest)));

        lowest = 999999;
        highest = 999999;
        logger.logFunc("findSumPower", "" + -10 + "," + highest, LogIt.toIntString(findSumPower(lowest, highest)));

    }

}
