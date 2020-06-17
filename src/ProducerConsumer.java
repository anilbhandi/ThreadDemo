import java.util.ArrayList;

class Factory {

	ArrayList<Integer> list = new ArrayList<Integer>();

	public static int LIMIT = 5;
	public static int BOTTOM = 0;
	public int value = 0;
	public Object lock = new Object();

	public void producer() throws InterruptedException {

		synchronized (lock) {
			while (true) {

				if (list.size() == LIMIT) {
					System.out.println("Producer: List is full. Wait for Consumer to consume");
					lock.wait();
				} else {
					System.out.println("Producer: Adding object to list " + ++value);
					list.add(value);
					lock.notify();
				}

				Thread.sleep(1000);
			}
		}

	}

	public void consumer() throws InterruptedException {

		synchronized (lock) {
			while (true) {
				if (list.size() == BOTTOM) {
					System.out.println("Consumer: List is empty. Wait for Producer to producer");
					lock.wait();
				} else {
					System.out.println("Consumer: Removing object from list" + value);
					list.remove(--value);
					lock.notify();
				}
				Thread.sleep(1000);
			}
		}

	}

}

public class ProducerConsumer {

	public static void main(String[] args) {
		Factory factory = new Factory();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					factory.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					factory.consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
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
