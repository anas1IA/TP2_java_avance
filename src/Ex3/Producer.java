package Ex3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Producer implements Runnable{
	
	private File<Integer> file;
	private ReentrantLock lock;
	private Condition consumerCondition;
	private Condition producerCondition;
	
	public Producer(
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
			produce(i);
		
	}	
	
	private void produce(int data) {
		lock.lock();
		
		try {
			while(file.isFull()) {
				System.out.println("file is Full, Producer is waiting...");
				consumerCondition.signal();
				producerCondition.await();
			}
			
			file.offer(data);
			System.out.println("Prduced : " + data);
			consumerCondition.signal();
			
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}finally {
			lock.unlock();
		}
	}
}
