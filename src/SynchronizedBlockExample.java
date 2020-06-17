
public class SynchronizedBlockExample {

	private static int count1 = 0;
	private static int count2 = 0;
	
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	public  static void add() {
		//replace SynchronizedBlockExample.class to add class level lock
		//replace with lock object it add locks at object level
		synchronized (lock1) {
			count1++;
		}
		
	}

	public synchronized static void addAgain() {
		synchronized (lock2) {
			System.out.println("Thead 2");
			count2++;
		}
	}

	public static void compute() {
		add();
		addAgain();
	}

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					compute();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					compute();
				}

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
		
		System.out.println(count1 + " " + count2);

	}
}
