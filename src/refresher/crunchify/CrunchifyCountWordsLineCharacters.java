/**
 * 
 */
package refresher.crunchify;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author clif
 *
 */
public class CrunchifyCountWordsLineCharacters {
	
	public static void readFileAndPrintCounts(String inFile) throws FileNotFoundException{
		
		BufferedReader buffer = null;
		int totalWords = 0;
		int totalLines = 0;
		int totalCharacters = 0;
		
		String line = "";
		
		buffer = new BufferedReader(new FileReader(inFile));
		try {
			
			logIt("================= File Content ==================");
			
			while((line = buffer.readLine()) != null){
				logIt(line);
				
				// increment line count
				if (line.trim().length() > 0){

					totalLines++;
				
					// increment character count
					String[] myWords = line.trim().replace("\\s+", " ").split(" ");
					for(String s: myWords){
						totalCharacters += s.trim().length();
					}
					
					// increment word count
					totalWords += myWords.length;
				}
			}

		} catch (IOException e){
			e.printStackTrace();
		}

		logIt("\n ================== Result ===================");
		
		logIt("Total Lines:      " + totalLines);
		logIt("Total Words:      " + totalWords);
		logIt("Total Characters: " + totalCharacters);

	}
	
	
	public static void logIt(String msg){
		System.out.println(msg);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String inFile = "/Users/clif/armedia_test/report.py";
		try {
			readFileAndPrintCounts(inFile);
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}

}
