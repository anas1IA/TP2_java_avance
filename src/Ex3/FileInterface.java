package Ex3;

public interface FileInterface<T> {
	
	public void offer(T data);
	
	public T poll();
	
	public int getSize();
	
	public Boolean isFull();
	
	public Boolean isEmpty();
	
	private T get(int index)  {
		return null;
	}
	
	
}
