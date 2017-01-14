package refresher.practice.collections;

import refresher.practice.helpers.LogIt;

public class ZipDecimal {

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
    private static int zipIt(int A, int B) {

        char[] aAry = Integer.toString(A).toCharArray();
        char[] bAry = Integer.toString(B).toCharArray();

        int totalLen = aAry.length + bAry.length;

        int aIdx = 0;
        int bIdx = 0;

        StringBuilder sb = new StringBuilder();

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

        return Integer.parseInt(sb.toString());

    }

    public static void main(String[] args) {

        LogIt logger = new LogIt(ZipDecimal.class.getName());

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
    }

}
