/**
 * 
 */
package refresher.javacollections.com;

/**
 * @author clif
 *
 */
public class Question3b {

	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer("hello");
		StringBuffer sb2 = new StringBuffer("hello");

		if (sb1.equals(sb2))
			System.out.println("equal");
		else
			System.out.println("not equal");
	}
}
