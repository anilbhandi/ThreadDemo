

/**
 * Runnable example
 * Sleep example
 * join example
 * @author anilbhandi
 *
 */


class Runnable1 implements Runnable{
	
	public void run() {
		for(int i =0; i<=5; i++) {
			System.out.println("Runnable 1 : " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Runnable2 implements Runnable{
	
	public void run() {
		for(int i =0; i<=5; i++) {
			System.out.println("Runnable 2 : " + i);
		}
	}
	
}


public class RunnableExample {
	
	public static void main(String[] args){
		
		Thread t1 = new Thread(new Runnable1());
		Thread t2 = new Thread(new Runnable2());
		
		t1.start();
		
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t2.start();
	}

}
