package refresher.practice.collections.map;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import refresher.practice.helpers.LogIt;

public class ConcurrentMapCheck {

	private static int MAX = 10;
	private static LogIt logger = new LogIt(ConcurrentMapCheck.class.getName());
	private static ConcurrentHashMap<Integer, Double> map = new ConcurrentHashMap<Integer, Double>(MAX);

	/**
	 * Returns the value of the key in the map.
	 * 
	 * @param key
	 *            A simple int
	 * @return value of the map at the key.
	 */
	private static double getMappedValue(int key) {

		if (map.containsKey(key)) {
			return map.get(key);
		}

		throw new IllegalArgumentException("No value for key=" + key);
	}

	public static void main(String[] args) {

		Random random = new Random();
		DecimalFormat df = new DecimalFormat("#.###");

		// Set the range to 1 => 1.99
		for (int i = 0; i < MAX; i++) {
			double f = Double.valueOf(df.format(random.nextDouble() + 1));
			map.put(i, f);
		}

		logger.getLogger().info("\n" + map.toString().replace(',', '\n'));

		for (int i = 0; i < MAX; i++) {
			logger.logFunc("getMappedValue", "" + i, "" + df.format(getMappedValue(i)));
		}
	}

}
