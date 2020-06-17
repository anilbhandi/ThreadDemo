
class Processor{
	
	public void producer() throws InterruptedException{
		
		synchronized (this) {
			System.out.println("You are in Producer");
			wait(30000);
			System.out.println("Again in producer..");
		}
		
	}
	
	public void consumer() throws InterruptedException {
		Thread.sleep(10000);
		synchronized (this) {
			System.out.println("You are in consumer");
			notify();
		}
	}
}

public class SimpleProducerConsumer {
	
	public static void main(String [] args) {
		Processor processor = new Processor();
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					processor.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					processor.consumer();
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
