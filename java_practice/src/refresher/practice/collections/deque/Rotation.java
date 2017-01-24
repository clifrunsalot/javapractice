package refresher.practice.collections.deque;

import refresher.practice.helpers.LogIt;

import java.util.ArrayDeque;
import java.util.Random;

public class Rotation {

    /** Returns the inAry with element rotated to the right by K places.
     *
     * e.g.
     *
     * rotate([3, 8, 9, 7, 6],6) => [6, 3, 8, 9, 7]
     * rotate([3, 8, 9, 7, 6],10) => [3, 8, 9, 7, 6]
     * rotate([3, 8, 9, 7, 6],5) => [3, 8, 9, 7, 6]
     * rotate([3, 8, 9, 7, 6],7) => [7, 6, 3, 8, 9]
     * rotate([3, 8, 9, 7, 6],9) => [8, 9, 7, 6, 3]
     * rotate([3, 8, 9, 7, 6],14) => [8, 9, 7, 6, 3]
     * rotate([3, 8, 9, 7, 6],2) => [7, 6, 3, 8, 9]
     * rotate([3, 8, 9, 7, 6],14) => [8, 9, 7, 6, 3]
     * rotate([3, 8, 9, 7, 6],2) => [7, 6, 3, 8, 9]
     * rotate([3, 8, 9, 7, 6],5) => [3, 8, 9, 7, 6]
     * rotate([],5) => []
     *
     * @param inAry int[] of integers.
     * @param k The number of positions to rotate right.
     * @return An int[] after rotation.
     */
    private static int[] rotateWithDeque(int[] inAry, int k) {

        int[] outAry = new int[inAry.length];

        if (inAry.length > 0) {

            ArrayDeque<Integer> deque = new ArrayDeque<Integer>(inAry.length);

            // Put ary values into a queue for easy add/remove
            for (int i : inAry) {
                deque.add(i);
            }

            // Remove K elements from the end and add one by one to the front.
            int temp = 0;
            for (int i = 0; i < k; i++) {
                temp = deque.removeLast();
                deque.addFirst(temp);
            }

            // Put contents of deque into outbound ary.
            int i = 0;
            while (!deque.isEmpty()) {
                outAry[i] = deque.poll();
                i += 1;
            }
        }

        return outAry;

    }

    public static void main(String[] args) {

        LogIt logger = new LogIt(Rotation.class.getName());

        Random random = new Random();
        int largestRandom = 15;

        int[] newAry = {3, 8, 9, 7, 6};

        int rotation = 0;
        for (int i = 0; i < 10; i++) {
            rotation = random.nextInt(largestRandom - 1) + 1;
            String funcArgs = "" + LogIt.toIntString(newAry) + "," + rotation;
            String result = LogIt.toIntString(rotateWithDeque(newAry, rotation));
            logger.logFunc("rotate", funcArgs, "" + result);
        }

        // check empty array
        newAry = new int[0];
        rotation = 5;
        String funcArgs = "" + LogIt.toIntString(newAry) + "," + rotation;
        String result = LogIt.toIntString(rotateWithDeque(newAry, rotation));
        logger.logFunc("rotate", funcArgs, "" + result);


    }

}
