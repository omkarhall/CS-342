
public class GenericQueue<T> extends GenericList<T>{

	private Node<T> tail;  // tail of list
	
	public GenericQueue(T val) {
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
		if (getHead() == null) {  // add to empty list
			setHead(new Node<T>(data));
			tail = getHead();
			setLength(1);
		} else {
			Node<T> temp = new Node<T>(data);
			tail.next = temp;
			tail = temp;
			setLength(getLength() + 1);
		}
		
	}
	
	public void enqueue(T data) {
		add(data);
	}
	
	public T dequeue() {
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
