package refresher.practice.collections.arrays;

import refresher.practice.helpers.LogIt;

/**
 * Demonstrates classic bubble sort. Nothing fancy.
 */
public class BubbleSort {

    /**
     * Returns a sorted int[].
     *
     * @param inAry unsorted int [].
     * @return int [] sorted.
     */
    private static int[] useBubbleSort(int[] inAry) {

        int tmp = 0;

        for (int i = 0; i < inAry.length; i++) {

            for (int j = 1; j <= inAry.length - 1; j++) {

                if (inAry[j - 1] > inAry[j]) {
                    tmp = inAry[j - 1];
                    inAry[j-1] = inAry[j];
                    inAry[j] = tmp;
                }
            }

        }

        return inAry;

    }

    public static void main(String[] args) {

        LogIt logger = new LogIt(BubbleSort.class.getName());

        int[] ary1 = { 1, 1, 2, 2, 4, 5, 5, 5, 98, 98 };
        logger.logFunc("useBubbleSort", LogIt.toIntString(ary1), "" + LogIt.toIntString(useBubbleSort(ary1)));

        int[] ary2 = { 3, 3, 6, 6, 7, 8, 8, 9, 9, 9 };
        logger.logFunc("useBubbleSort", LogIt.toIntString(ary2), "" + LogIt.toIntString(useBubbleSort(ary2)));

        int[] ary3 = { 7, 7, 1, 1, 4, 4, 2, 9, 9, 33, 33, 33 };
        logger.logFunc("useBubbleSort", LogIt.toIntString(ary3), "" + LogIt.toIntString(useBubbleSort(ary3)));

        int[] ary4 = { 888, 888, 5, 5, 1, 2, 2, 4, 4 };
        logger.logFunc("useBubbleSort", LogIt.toIntString(ary4), "" + LogIt.toIntString(useBubbleSort(ary4)));

        int[] ary5 = { 77, 65, 65, 3, 3 };
        logger.logFunc("useBubbleSort", LogIt.toIntString(ary5), "" + LogIt.toIntString(useBubbleSort(ary5)));

        int[] ary6 = { 1, 1 };
        logger.logFunc("useBubbleSort", LogIt.toIntString(ary6), "" + LogIt.toIntString(useBubbleSort(ary6)));

        int[] ary7 = new int[0];
        logger.logFunc("useBubbleSort", LogIt.toIntString(ary7), "" + LogIt.toIntString(useBubbleSort(ary7)));


    }

}
