package refresher.practice.collections;

import refresher.practice.binary.Conversion;
import refresher.practice.helpers.LogIt;

public class SearchString {
	
	// Returns the index of find in inHere or -1.
	private static int findSubString(int find, int inHere){
		
		String findStr = Integer.toString(find);
		String inHereStr = Integer.toString(inHere);
		return (inHereStr.indexOf(findStr) != -1) ? inHereStr.indexOf(findStr) : -1;
		
	}

	public static void main(String[] args) {
		
	    LogIt logger = new LogIt(SearchString.class.getName()).getLogger();
		
		int inHere = 1953786;
		int find = 53;
		logger.info("findSubString", "" + find + "," + inHere, String.valueOf(findSubString(find,inHere)));

		find = 37;
		logger.info("findSubString", "" + find + "," + inHere, String.valueOf(findSubString(find,inHere)));

		inHere = 999999999;
		find = 9;
		logger.info("findSubString", "" + find + "," + inHere, String.valueOf(findSubString(find,inHere)));
	}

}
