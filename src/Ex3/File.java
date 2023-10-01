package Ex3;


public class File<T> implements FileInterface<T>{
	
	private FileElement<T> head = new FileElement<T>();
	private FileElement<T> back = new FileElement<T>();
	private int size = 0;
	private int maxCapacity = 0;
	
	public File(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	@Override
	public void offer(T data) {
		
		if(size >= maxCapacity) return;
		
		FileElement<T> e = new FileElement<T>();
		e.setData(data);
		
		if(head.getNext() == null) head.setNext(e);
		else back.getNext().setNext(e);
			
		back.setNext(e);	
	
		size++;
		
	}

	@Override
	public T poll() {
		
		T data = head.getNext().getData();
		head = head.getNext();
		
		size--;
		
		return data;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public Boolean isFull() {
		return size >= maxCapacity;
	}

	@Override
	public Boolean isEmpty() {
		return size == 0; 
	}

	private T get(int index) {
		
		FileElement<T> curr = head.getNext();
		
		int i = 0;
		while(i<index) {
			curr = curr.getNext();
			i++;
		}
		return curr.getData();
	}
	
	@Override
	public String toString() {
		
		String message= "[";
		
		for(int i = 0; i < getSize() - 1; i++) message += get(i) + " , ";
		
		try {
			message += get(getSize()-1) + "]";			
		} catch (Exception e) {
			return "[]";
		}
		
		return message;
	}
	
}