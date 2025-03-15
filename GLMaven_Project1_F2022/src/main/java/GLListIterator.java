import java.util.ListIterator;

public class GLListIterator<T> implements ListIterator<T> {

	private GenericList<T>.Node<T> current;
	private int index;  // starting index
	private int maxIndex;  // highest index of linked list
	
	public GLListIterator(GenericList<T>.Node<T> head, int index, int length) {
		current = head;
		this.index = index;
		maxIndex = length - 1;
	}
	
	@Override
	public boolean hasNext() {
		return index <= maxIndex;
	}

	@Override
	public T next() {
		if (index == -1) {
			index++;  // reset index to 0 if iterated reverse all the way
		}
		GenericList<T>.Node<T> temp = current;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		T data = temp.data;
		index++;
		return data;
	}

	@Override
	public boolean hasPrevious() {
		return index >= 0;
	}

	@Override
	public T previous() {
		if (index == maxIndex + 1) {
			index--;  // reset index to maxIndex if iterated forward all the way
		}
		GenericList<T>.Node<T> temp = current;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		T data = temp.data;
		index--;
		return data;
	}

	@Override
	public int nextIndex() {
		return index;
	}

	@Override
	public int previousIndex() {
		return index;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(T e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(T e) {
		// TODO Auto-generated method stub
		
	}
}
