package refresher.practice.threads;

public class TwoThreadsDemo {
	public static void main(String[] args) {
		new SimpleThread("Jamaica").start();
		new SimpleThread("Fiji").start();
	}
}
