/**
 * 
 */
package refresher.practice.generics;

/**
 * @author clif
 *
 */

interface Pair<K, V> {

	public K getKey();

	public V getValue();
}

class OrderedPair<K, V> implements Pair<K, V> {

	private K k;
	private V v;

	public OrderedPair(K key, V val) {
		this.k = key;
		this.v = val;
	}

	@Override
	public K getKey() {
		return k;
	}

	@Override
	public V getValue() {
		return v;
	}

}

class Box<T> {
	T t;

	public Box(T x) {
		this.t = x;
	}

	public T getT() {
		return t;
	}
}

public class GenericExamples {

	private static <U extends Number> U getValue(U val) {
		return val;
	}

	private static <K, V> boolean isValidPair(K key, V val) {
		Box<String> val2 = (Box<String>) val;
		Box<String> b = val2;
		if (!key.equals(b.getT()))
			return true;
		else
			return false;
	}

	private static void useGenerics() {
		Box<String> b = new Box<String>("hello,clif");
		logIt(b.getT());

		if (GenericExamples.isValidPair("Clifton", new Box<String>("Hudson"))) {
			OrderedPair<String, Box<String>> op = new OrderedPair<>("name", new Box<String>("Clif Hudson"));
			logIt("Key:   " + op.getKey());
			logIt("Value: " + ((Box<String>) op.getValue()).getT());
		}
	}

	private static void logIt(String s) {
		System.out.println(s);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenericExamples.useGenerics();
		logIt(GenericExamples.getValue(new Integer(6)).toString());
	}

}
