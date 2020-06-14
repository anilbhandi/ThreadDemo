/**
 * Volatile Example
 * @author anilbhandi
 *
 */

class Worker implements Runnable{
	
	public volatile boolean isTerminated = false;

	public  boolean isTerminated() {
		return isTerminated;
	}

	public  void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}

	@Override
	public void run() {
		while(!isTerminated) {
			System.out.println("Worker class is running");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

public class VolatileExample1 {
	

    public static void main(String[] args) {
    	Worker worker = new Worker();
    	
    	Thread t1 = new Thread(worker);
    	t1.start();
    	
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	worker.setTerminated(true);
    	
    	System.out.println("Program Terminated..");
    	
        
    }
	
}
