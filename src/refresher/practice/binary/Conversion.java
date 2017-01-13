package refresher.practice.binary;

import java.util.Random;

import refresher.practice.helpers.LogIt;

public class Conversion {

	// Returns the binary value of decimal number.
	private static byte[] getBinary(int number) {

		final int TWO = 2;
		int remainder = 0;
		double quotient = 0;
		int dividend = number;
		byte[] bits = new byte[32];
		int idx = 31;

		do {
			// get bit
			remainder = dividend % TWO;

			// get integer part of dividend
			quotient = dividend / TWO;

			bits[idx--] = (byte) remainder;

			dividend = (int) Math.floor(quotient);

		} while (quotient > 0);

		return bits;
	}

	// Returns the decimal value of binary number.
	private static int getDecimal(byte[] binary) {

		int sum = 0;
		byte[] number = binary;
		byte remainder = 0;
		int powerOf2 = 0;

		// Start of least significant.
		// but use powerOf2 index to manager sum.
		for (int i = (binary.length - 1); i >= 0; i--, powerOf2++) {

			remainder = number[i];
			sum += (int) (remainder * Math.pow(2, powerOf2));

		}

		return sum;
	}

	// Return length of longest contiguous sequence of 0 in binary.
	private static int getLongest0SequenceInBinary(byte[] binary) {

		byte[] number = binary;
		int count = 0;
		int curr = 0;
		int highestCount = 0;
		boolean start = false;

		for (int i = 0; i <= (binary.length-1); i++) {

			// get remainder, starting from least significant
			// we'll call it curr
			curr = number[i];

			if (curr == 1) {

				// This means the block of zeros ended
				// evaluate highest count
				if (start) {
					highestCount = (highestCount < count) ? count : highestCount;
					count = 0;

				} else {

					// reset flag because we have to start counting again.
					start = true;
					count = 0;
				}

				// go to next remainder
				continue;

			} else {

				// Process 0's within block
				if (!start) {

					// go to next remainder
					continue;

				} else {

					count += 1;

				}

			}

		}

		return highestCount;
	}

	public static void main(String[] args) {
		
	    LogIt logger = new LogIt(Conversion.class.getName());

		Random random = new Random();
		int largestRandom = 3000;
		int value = 0;
		byte[] binary;
		int seqCount = 0;
		for (int i = 0; i < 5; i++) {
			value = random.nextInt(largestRandom - 1) + 1;
			binary = getBinary(value);
			logger.logFunc("getBinary", "" + value, "" + LogIt.toByteString(binary));
			value = getDecimal(binary);
			logger.logFunc("getDecimal", "" + LogIt.toByteString(binary), "" + value);
			seqCount = getLongest0SequenceInBinary(binary);
			logger.logFunc("getLongest0SequenceInBinary", "" + LogIt.toByteString(binary), "" + seqCount);
			System.out.println();

		}
	}
}
