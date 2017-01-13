package refresher.practice.collections;

import refresher.practice.binary.Conversion;
import refresher.practice.helpers.LogIt;

public class ZipDecimal {

    /*
     * Returns a new decimal representing the merge between A and B.
     * such that:
     *
     * (a=123, b=456) => 142536
     *
     */
    private static int zipIt(int A, int B) {

        StringBuilder sb = new StringBuilder();
        String aStr = Integer.toString(A);
        String bStr = Integer.toString(B);

        int totalLen = aStr.length() + bStr.length();

        boolean stop = false;

        while (!stop) {

            for (int i = 0; i < totalLen; i++) {

                if (i < aStr.length())
                    sb.append(aStr.charAt(i));
                else {
                    if (i <= (bStr.length() - 1)) {
                        sb.append(bStr.substring(i));
                        stop = true;
                        break;
                    }
                }

                if (i < bStr.length())
                    sb.append(bStr.charAt(i));
                else {
                    if (i <= (aStr.length() - 1))
                        sb.append(aStr.substring(i));
                    stop = true;
                    break;
                }

            }
            if (stop)
                break;

        }

        return Integer.parseInt(sb.toString());

    }

    public static void main(String[] args) {

        LogIt logger = new LogIt(ZipDecimal.class.getName());

        int A = 53;
        int B = 53;
        logger.logFunc("zipIt", A + "," + B, "" + zipIt(A, B));

        B = 1234;
        logger.logFunc("zipIt", A + "," + B, "" + zipIt(A, B));

        A = 1357;
        B = 0;
        logger.logFunc("zipIt", A + "," + B, "" + zipIt(A, B));

        A = 1357;
        B = 246890;
        logger.logFunc("zipIt", A + "," + B, "" + zipIt(A, B));

        A = 0;
        B = 0;
        logger.logFunc("zipIt", A + "," + B, "" + zipIt(A, B));

        A = 1;
        B = 2;
        logger.logFunc("zipIt", A + "," + B, "" + zipIt(A, B));
    }

}
