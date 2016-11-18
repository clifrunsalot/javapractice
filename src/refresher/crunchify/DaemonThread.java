/**
 * 
 */
package refresher.crunchify;

/**
 * @author clif
 *
 */
public class DaemonThread extends Thread {
	
	public void run(){
		
		logIt("Main Method Exit");
		
		try{
			
			logIt("in run method: currentThread() is " + Thread.currentThread());
			
			while(true){
				
				try{
					Thread.sleep(1000);
				} catch(InterruptedException e){
					// Ignore
				}
				
				logIt("in run method: currentThread() is " + Thread.currentThread());
			}
			
		} finally {
			
			logIt("Run method exit");

		}
		
	}
	
	public static void logIt(String msg){
		System.out.println(msg);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		logIt("Main Method Entry");
		
		DaemonThread t = new DaemonThread();
		t.setDaemon(true);
		t.start();
		
		try{
			Thread.sleep(3000);
		} catch(InterruptedException e){
			// ignore
		}
		
		logIt("Main method exit");

	}

}
