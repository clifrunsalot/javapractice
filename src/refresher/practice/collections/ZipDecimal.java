package refresher.practice.collections;

import refresher.practice.helpers.LogIt;

import java.util.logging.Level;

import static javax.swing.text.html.HTML.Tag.HEAD;

public class ZipDecimal {

    static LogIt logger = new LogIt(ZipDecimal.class.getName());

    /**
     * Returns a new decimal representing the merge between A and B.
     * such that:
     * <p>
     * (a=123, b=456) => 142536
     *
     * @param A An integer.
     * @param B An integer.
     * @return An integer merged from A and B.
     */
    public static int zipIt(int A, int B) {

        int result = -1;
        StringBuilder sb = new StringBuilder();

        try {

            if (A > 0 && B > 0) {

                char[] aAry = Integer.toString(A).toCharArray();
                char[] bAry = Integer.toString(B).toCharArray();

                int totalLen = aAry.length + bAry.length;

                int aIdx = 0;
                int bIdx = 0;

                for (int i = 0; i < totalLen; i++) {

                    if (aIdx < aAry.length) {

                        sb.append(aAry[aIdx]);
                        aIdx += 1;

                    }

                    if (bIdx < bAry.length) {

                        sb.append(bAry[bIdx]);
                        bIdx += 1;

                    }

                    if (sb.length() == totalLen) {
                        break;
                    }
                }

                result = Integer.parseInt(sb.toString());

            } else {

                logger.getLogger().log(Level.SEVERE,"Argument(s) must be > 0");
                throw new IllegalArgumentException("Arguments must be > 0");
            }

        } catch (IllegalArgumentException iae) {

            logger.getLogger().log(Level.SEVERE, "Zipped value exceeds capacity of an int type. Use smaller values.");
            throw new IllegalArgumentException("Zipped value exceeds capacity of an int type. Use smaller values.");

        }

        return result;

    }

    public static void main(String[] args) {

        int A = 53;
        int B = 53;
        logger.logFunc("zipIt", A + "," + B, "" + zipIt(A, B));

        A = 567;
        B = 1234;
        logger.logFunc("zipIt", A + "," + B, "" + zipIt(A, B));

        A = 1234;
        B = 567;
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

        A = 99999;
        B = 9999;
        logger.logFunc("zipIt", A + "," + B, "" + zipIt(A, B));

        A = -99999;
        B = 9999;
        logger.logFunc("zipIt", A + "," + B, "" + zipIt(A, B));

        A = 999999999;
        B = 999999999;
        logger.logFunc("zipIt", A + "," + B, "" + zipIt(A, B));

    }

}
