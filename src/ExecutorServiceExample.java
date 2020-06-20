import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Structure implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ExecutorServiceExample {

	public static void main(String[] args) {
		
		//Created all thread in one go if all threads are busy created new thread
		//ExecutorService executorService = Executors.newCachedThreadPool();
		//creates 2 thread and waits for 2 thread to finish then reuses those threads
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		//Creates new thread and uses it each time when its done
		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		for (int i = 0; i < 5; i++) {
			executorService.submit(new Structure());
		}
		
		executorService.shutdown();

	}

}
