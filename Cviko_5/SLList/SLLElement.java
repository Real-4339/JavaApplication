package fiit.cvicenia.Teachers_code.SLList;

public class SLLElement<T> {
	private T data;
	private SLLElement<T> next;

	public SLLElement() { }	
	public SLLElement(T d) {
		data = d;
	}
	public T getData() {
		return data;
	}
	public void setData(T d) {
		data = d;
	}

	public SLLElement<T> getNext() {
		return next;
	}
	public void setNext(SLLElement<T> e) {
		next = e;
	}
	public String toString() {
		return data.toString();
	}

}
