

/**
 * Runnable example
 * @author anilbhandi
 *
 */

class Thread1 extends Thread{
	
	public void run() {
		for(int i =0; i<=5; i++) {
			System.out.println("Runnable 1 : " + i);
		}
	}
}

class Thread2 extends Thread{
	
	public void run() {
		for(int i =0; i<=5; i++) {
			System.out.println("Runnable 2 : " + i);
		}
	}
	
}


public class ThreadExample {
	
	public static void main(String[] args){
		
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		
		t1.start();
		t2.start();
		
	}

}

