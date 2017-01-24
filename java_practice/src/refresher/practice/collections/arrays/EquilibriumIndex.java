package refresher.practice.collections.arrays;

import refresher.practice.helpers.LogIt;

import java.util.ArrayList;

/**
 * Returns the index of the array with a value that equals the sum of the
 * rest of the values in the array.
 * <p>
 * e.g. [0] [1] [2] [3] [4] [5] [6] [7]
 * -1   3  -4   5   1  -6   2   1
 * <p>
 * Skipping index 1 means that
 * <p>
 * a[0] = a[2] + a[3] + a[4] + a[5] + a[6] + a[7]
 * <p>
 * findAnIndex([-1, 3, -4, 5, 1, -6, 2, 1]) => 1
 * findAnIndex([-1, -6, -2, 1, -1, -6, -2]) => 3
 * findAnIndex([3, 1, -4, 5, -6, 2, 3]) => 2
 */
public class EquilibriumIndex {

    /**
     * Returns index of equilibrium value.
     *
     * @param inAry int []
     * @return The index.
     */
    private static int findAnIndex(int[] inAry) {

        int sumBefore = 0;
        int sumAfter = 0;
        int skip = 0;
        int foundOne = 0;
        ArrayList<Integer> equals = new ArrayList<Integer>();

        if (inAry.length > 0) {

            for (int i = 0; i < inAry.length; i++) {

                sumBefore = 0;
                sumAfter = 0;
                skip = i;

                // System.out.println("skip index: [" + i + "]");
                for (int j = 0; j < inAry.length; j++) {

                    if (j < skip) {
                        sumBefore += inAry[j];
                    }

                }
                // System.out.println("sum before: [" + i + "] = " + sumBefore);

                for (int j = 0; j < inAry.length; j++) {

                    if (j > skip) {
                        sumAfter += inAry[j];
                    }

                }

                // System.out.println("sum after: [" + i + "] = " + sumAfter);
                // System.out.println();
                // System.out.println();

                // if sums are equals, an equilibrium had been found.
                if (sumBefore == sumAfter) {
                    foundOne = i;
                    //equals.add(foundOne);
                    break;
                }
            }
        }

//		LogIt.logTest("findAnIndex", "", LogIt.toIntString(equals.toArray()));

        return foundOne;

    }

    public static void main(String[] args) {

        LogIt logger = new LogIt(EquilibriumIndex.class.getName());

        int[] ary1 = {-1, 3, -4, 5, 1, -6, 2, 1};
        logger.logFunc("findAnIndex", LogIt.toIntString(ary1), "" + findAnIndex(ary1));

        int[] ary2 = {-1, -6, -2, 1, -1, -6, -2};
        logger.logFunc("findAnIndex", LogIt.toIntString(ary2), "" + findAnIndex(ary2));

        int[] ary3 = {3, 1, -4, 5, -6, 2, 3};
        logger.logFunc("findAnIndex", LogIt.toIntString(ary3), "" + findAnIndex(ary3));
    }

}
