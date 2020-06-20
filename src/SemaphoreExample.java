import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downloader {

	INSTANCE;

	private Semaphore semaphore = new Semaphore(3, true);

	public void DownloadData() {
		try {
			semaphore.acquire();
			download();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

	public void download() {
		System.out.println("Downloader");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class SemaphoreExample {

	public static void main(String [] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i <= 12; i++) {
			executorService.execute(new Runnable() {

				@Override
				public void run() {
					Downloader.INSTANCE.DownloadData();
				}
			});
		}
	}

}
