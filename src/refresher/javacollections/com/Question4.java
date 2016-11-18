/**
 * 
 */
package refresher.javacollections.com;

/**
 * @author clif
 *
 */
public class Question4 {
	
	static int getLargestIntValueFromArray(int[] ary){
		int smallest = -1_000_000_000;
		int largest = smallest;
		for(int i=0; i<ary.length;i++){
			if(smallest < ary[i]){
				largest = ary[i];
				smallest = largest;
			}
		}
		return largest;
	}

	public static void main(String[] args) {
		
		System.out.println("Largest Value: " + getLargestIntValueFromArray(new int[]{ 12, 34, 1, 0, 999, 1_000_999, -2 }));
		System.out.println("Largest Value: " + getLargestIntValueFromArray(new int[] { -2, -1, -999, -1_000_999, -999 }));
		System.out.println("Largest Value: " + getLargestIntValueFromArray(new int[] { -999999, -888888, -777777, -666666, 0, 1 }));
	}

}

//+++++++++++++  OUTPUT ++++++++++++++
//	Largest Value: 1000999
//	Largest Value: -1
//	Largest Value: 1
