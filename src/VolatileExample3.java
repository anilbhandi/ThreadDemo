
class Machine extends Thread {
	public volatile int counter = 0;

	public int getCounter() {
		return counter;
	}

	public synchronized void increment() {
		counter++;
	}

	public void process() {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					// increment();
					counter++;
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					// increment();
					counter++;
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
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

	}

}

public class VolatileExample3 {

	public static void main(String[] args) {

		Machine machine = new Machine();
		machine.process();

		System.out.println("Finished execution");
		System.out.println(machine.getCounter());

	}

}
