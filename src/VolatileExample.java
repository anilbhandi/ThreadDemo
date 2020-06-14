/**
 * Volatile Example
 * @author anilbhandi
 *
 */

public class VolatileExample {
	
static class ChangeListener extends Thread {
        @Override
        public void run() {
            int local_value = MY_INT;
            while ( local_value < 5){
            	
            	//System.out.println("ChangeListener :: Thread");
            	
                if( local_value!= MY_INT){
                    System.out.println("Got Change for MY_INT :"  +  ++local_value);
                     //local_value= MY_INT;
                }
            }
        }
    }

    static class ChangeMaker extends Thread{
        @Override
        public void run() {

            int local_value = MY_INT;
            while (MY_INT <5){
                System.out.println("Incrementing MY_INT to: " + ++MY_INT);
                //MY_INT = ++local_value;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

    private static volatile int MY_INT = 0;

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeMaker().start();
    }
	
}
