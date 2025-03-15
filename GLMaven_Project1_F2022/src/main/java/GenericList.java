import java.util.Iterator;
import java.util.ArrayList;
import java.util.ListIterator;


public abstract class GenericList<T> implements Iterable<T> {

	private Node<T> head;  // head of the list
	private int length;  // length of the list
	
	public void print() {
		if (head == null) {
			System.out.println("Empty List");
		} else {
			Node<T> temp = head;
			while (temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}
	
	public abstract void add(T data);
	
	public T delete() {
		if (head == null) {
			return null;
		}
		Node<T> temp = head;
		head = head.next;
		length--;
		return temp.data;
	}
	

	public ArrayList<T> dumpList() {
		ArrayList<T> list = new ArrayList<T>();
		Node<T> temp = head;
		while (temp != null) {
			list.add(temp.data);
			temp = temp.next;
		}
		// clear linked list
		head = null;
		length = 0;
		return list;
	}
	
	public T get(int index) {
		if (index < 0 || index >= length) {
			return null;
		}
		Node<T> temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.data;
	}
	
	public T set(int index, T element) {
		if (index < 0 || index >= length) {
			return null;
		}
		Node<T> temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		T oldVal = temp.data;
		temp.data = element;
		return oldVal;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int l) {
		length = l;
	}
	
	public Node<T> getHead() {
		return head;
	}
	
	public void setHead(Node<T> newH) {
		head = newH;
	}
	
	
	public ListIterator<T> listIterator(int index) {
		return new GLListIterator<T>(head, index, length);
	}
	
	public Iterator<T> descendingIterator() {
		return new ReverseGLLIterator<T>(head, length);
	}
	
	@Override
	public Iterator<T> iterator() {
		return new GLLIterator<T>(head);
	}
	
	public class Node<T> {
		public T data;
		public Node<T> next;
		
		public Node(T val) {
			data = val;
		}
	}
}
