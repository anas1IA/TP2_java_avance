package Ex3;

public class FileElement<T> {
	
	private T data = null;
	private FileElement<T> next = null;
	
	public void setData(T data) {
		this.data = data;
	}
	
	public void setNext(FileElement<T> next) {
		this.next = next;
	}
	
	public FileElement<T> getNext(){
		return next;
	}
	
	public T getData(){
		return data;
	}
	
}
