import java.util.Iterator;

public class GLLIterator<T> implements Iterator<T> {
	
	private GenericList<T>.Node<T> current;
	
	public GLLIterator(GenericList<T>.Node<T> head) {
		current = head;
	}
	
	@Override
	public boolean hasNext() {
		return current != null;
	}
	
	@Override
	public T next() {
		T data = current.data;
		current = current.next;
		return data;
	}
}
