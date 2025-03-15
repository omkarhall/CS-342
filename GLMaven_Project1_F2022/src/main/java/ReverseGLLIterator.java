import java.util.Iterator;

public class ReverseGLLIterator<T> implements Iterator<T> {

	private GenericList<T>.Node<T> current;
	private int index;
	
	public ReverseGLLIterator(GenericList<T>.Node<T> head, int length) {
		current = head;
		index = length - 1;
	}
	
	@Override
	public boolean hasNext() {
		return index >= 0;
	}
	
	@Override
	public T next() {
		GenericList<T>.Node<T> temp = current;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		T data = temp.data;
		index--;
		return data;
	}
}
