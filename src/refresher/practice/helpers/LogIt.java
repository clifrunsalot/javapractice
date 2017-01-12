package refresher.practice.helpers;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogIt {
	
    private static Logger logger;
	
	public LogIt(String className){
	    logger = LogManager.getLogger(className);
	}
	
	public LogIt getLogger(){
		return this;
	}
	
	public void info(String msg){
		logger.info(msg);
	}

	public void info(String funcName, String input, String result) {
		String message = String.format("%-2s(%s) => %s\n",funcName,input,result);
		logger.info(message);
	}
	
	public void error(String msg){
		logger.error(msg);
	}

	public static <T> String toNonPrimString(T[] ary){
		return Arrays.toString(ary);
	}
	
	public static String toByteString(byte[] ary){
		return Arrays.toString(ary);
	}

	public static String toIntString(int[] ary){
		return Arrays.toString(ary);
	}

	public static String toDblString(double[] ary){
		return Arrays.toString(ary);
	}

}
