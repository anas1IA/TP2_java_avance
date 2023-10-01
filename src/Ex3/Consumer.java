package Ex3;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer implements Runnable{
	
	private File<Integer> file;
	private ReentrantLock lock;
	private Condition consumerCondition;
	private Condition producerCondition;
	
	public Consumer(
			File<Integer> file,
			ReentrantLock lock , 
			Condition consumerCondition ,
			Condition producerCondition) {
		
		this.file = file;
		this.lock = lock;
		this.consumerCondition = consumerCondition;
		this.producerCondition = producerCondition; 
	}

	@Override
	public void run() {
		
		for(int i=0; i<10;i++)
			consume();
		
	}	
	
	private void consume() {
		lock.lock();
		
		try {
			while(file.isEmpty()) {
				System.out.println("file is Empty, Consumer is waiting...");
				producerCondition.signal();
				consumerCondition.await();
			}
			
			int data = file.poll();
			System.out.println("Consumed : " + data);
			producerCondition.signal();
			
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}finally {
			lock.unlock();
		}
	}
}
