import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Workers {
	
	

	ArrayList<Integer> list = new ArrayList<Integer>();

	Lock lock = new ReentrantLock();
	
	Condition condition = lock.newCondition();

	public void producer() throws InterruptedException {

		lock.lock();
		System.out.println("Producer Method");
		condition.await();
		System.out.println("Producer again");
		lock.unlock();

	}

	public void consumer() throws InterruptedException {

		lock.lock();
		Thread.sleep(3000);
		System.out.println("Consumer Method");
		condition.signal();
		lock.unlock();
	}

}

public class ProducerConsumerLocks {

	public static void main(String[] args) {
		Workers factory = new Workers();

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
