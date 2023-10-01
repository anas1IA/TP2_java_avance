package Ex3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class main {
	
	private static ReentrantLock lock = new ReentrantLock();
	
	
	private static Condition consumerCondition = lock.newCondition();
	private static Condition producerCondition = lock.newCondition();
	
	private static File<Integer> file = new File<Integer>(5);
	
	public static void main(String[] args) throws InterruptedException{
		
		Producer prod = new Producer(file, lock, consumerCondition, producerCondition);
		
		Consumer cons = new Consumer(file, lock, consumerCondition, producerCondition);
		
		Thread prod_t = new Thread(prod);
		Thread cons_t = new Thread(cons);
		
		prod_t.start();
		cons_t.start();
		
		prod_t.join();
		cons_t.join();
		
		 
		
	}
	
}