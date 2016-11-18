/**
 * 
 */
package refresher.javacollections.com;

/**
 * @author clif
 *
 */
public class Question6 {

	public static void main(String[] args) {
		displayInitials("Securities Accounting Management");
	}
	
	public static void displayInitials(String msg){
		String name = msg;
		int i = 0;
		boolean startWord = true;
		
		for(i=0; i<name.length(); i++){
			if(startWord){
				if (!Character.toString(name.charAt(i)).equals("")){
					System.out.print(name.charAt(i));
				}
			}
			if(name.charAt(i) == ' '){
				startWord = true;
			} else {
				startWord = false;
			}
		}
		
	}

}
