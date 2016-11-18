/**
 * 
 */
package refresher.javacollections.com;

/**
 * @author clif
 *
 */
public class Question1 {

	public void test1() {
		char[][] pic = new char[6][6];
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 6; j++) {
				if (i == j || i == 0 || i == 5)
					pic[i][j] = '*';
				else
					pic[i][j] = '.';
			}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++)
				System.out.print(pic[i][j]);
			System.out.println();
		}
	}

}
