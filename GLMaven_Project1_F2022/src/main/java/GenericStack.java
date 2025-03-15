
public class GenericStack<T> extends GenericList<T> {

	private Node<T> tail;  // tail of list
	
	public GenericStack(T val) {
		setHead(new Node<T>(val));
		tail = getHead();
		setLength(1);
	}
	
	public T removeTail() {
		if (tail == null) {
			return null;
		} else if (getHead() == tail) {  // list is length 1
			T val = tail.data;
			setHead(null);
			tail = null;
			setLength(0);
			return val;
		}
		T val = tail.data;
		Node<T> prev = null;
		Node<T> cur = getHead();
		// iterate until second to last node
		while (cur.next != null) {
			prev = cur;
			cur = cur.next;
		}
		cur = null;
		prev.next = null;
		tail = prev;
		setLength(getLength() - 1);
		return val;
	}
	
	@Override
	public void add(T data) {
		if (getHead() == null) {
			setHead(new Node<T>(data));
			tail = getHead();
			setLength(1);
		} else {
			Node<T> temp = new Node<T>(data);
			temp.next = getHead();
			setHead(temp);
			setLength(getLength() + 1);
		}
	}
	
	public void push(T data) {
		add(data);
	}
	
	public T pop() {
		T val = delete();
		if (getHead() == null) {
			tail = null;  // if list is empty after delete() set tail to null
		}
		return val;
	}
	
	public Node<T> getTail() {
		return tail;
	}

}
