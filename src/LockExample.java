import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

	public static int counter = 0;
	public static Lock lock = new ReentrantLock();

	public static void increment() {
		//Use try catch if any exception lock will not be released
		lock.lock();
		
		try {
			Thread.sleep(100);
			for (int i = 0; i < 1000; i++) {
				counter++;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		lock.unlock();
	}

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				increment();

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				increment();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(counter);

	}

}
