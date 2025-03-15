import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.ArrayList;

public class GQTest {

	private static GenericQueue<Integer> gq;
	
	@BeforeAll
	static void setup() {
		gq = new GenericQueue<Integer>(5);
	}
	
	@Test
	void nodeConstructorTest() {
		GenericList<Integer>.Node<Integer> test = gq.new Node<Integer>(3);
		assertEquals(3, test.data, "Node should have value of 3");
		assertNull(test.next, "Node.next should be null");
	}
	
	@Test
	void constructorTest() {
		assertEquals(gq.getHead().data, gq.getTail().data, "Head and tail should be same");
		assertEquals(1, gq.getLength(), "Length should be 1");
		assertEquals(5, gq.getHead().data, "Head should be 5");
	}
	
	@Test
	void removeTailTest() {
		Integer val = gq.removeTail();
		assertEquals(5, val, "Old tail should be 5");
		assertNull(gq.getTail(), "Tail should be null");
		assertNull(gq.getHead(), "Head should be null");
		assertEquals(0, gq.getLength(), "Length should be 0");
	}
	
	@Test
	void removeTailTestTwo() {
		GenericQueue<Integer> gq2 = new GenericQueue<Integer>(1);
		gq2.add(3);
		gq2.add(5);
		gq2.add(7);
		Integer val = gq2.removeTail();
		assertEquals(7, val, "Old tail should be 7");
		assertEquals(5, gq2.getTail().data, "Tail should be 5");
		assertEquals(3, gq2.getLength(), "Length should be 3");
	}
	
	@Test
	void addTest() {
		GenericQueue<Integer> gq2 = new GenericQueue<Integer>(5);
		gq2.add(3);
		assertEquals(5, gq2.getHead().data, "Head should be 5");
		assertEquals(3, gq2.getTail().data, "Tail should be 3");
		assertEquals(2, gq2.getLength(), "Length should be 2");
		
	}
	
	@Test
	void addTestTwo() {
		GenericQueue<Integer> gq2 = new GenericQueue<Integer>(5);
		gq2.dequeue();
		gq2.add(3);
		assertEquals(3, gq2.getHead().data, "Head should be 3");
		assertEquals(3, gq2.getTail().data, "Tail should be 3");
		assertEquals(1, gq2.getLength(), "Length should be 1");
	}
	
	@Test
	void enqueueTest() {
		GenericQueue<Integer> gq2 = new GenericQueue<Integer>(5);
		gq2.enqueue(3);
		assertEquals(5, gq2.getHead().data, "Head should be 5");
		assertEquals(3, gq2.getTail().data, "Tail should be 3");
		assertEquals(2, gq2.getLength(), "Length should be 2");
	}
	
	@Test
	void enqueueTestTwo() {
		GenericQueue<Integer> gq2 = new GenericQueue<Integer>(5);
		gq2.dequeue();
		gq2.enqueue(3);
		assertEquals(3, gq2.getHead().data, "Head should be 3");
		assertEquals(3, gq2.getTail().data, "Tail should be 3");
		assertEquals(1, gq2.getLength(), "Length should be 1");
	}
	
	@Test
	void dequeueTest() {
		GenericQueue<Integer> gq2 = new GenericQueue<Integer>(5);
		Integer val = gq2.dequeue();
		assertEquals(5, val, "Old head should be 5");
		assertNull(gq2.getTail(), "Tail should be null");
		assertNull(gq2.getHead(), "Head should be null");
		assertEquals(0, gq2.getLength(), "Length should be 0");
	}
	
	@Test
	void dequeueTestTwo() {
		GenericQueue<Integer> gq2 = new GenericQueue<Integer>(1);
		gq2.add(3);
		gq2.add(5);
		gq2.add(7);
		Integer val = gq2.dequeue();
		assertEquals(1, val, "Old head should be 1");
		assertEquals(3, gq2.getHead().data, "Head should be 3");
		assertEquals(7, gq2.getTail().data, "Tail should be 7");
		assertEquals(3, gq2.getLength(), "Length should be 3");
	}
	
	@Test
	void forEachTest() {
		GenericQueue<Integer> gq2 = new GenericQueue<Integer>(1);
		gq2.add(3);
		gq2.add(5);
		gq2.add(7);
		int[] expected = {1, 3, 5, 7};
		int i = 0;
		for(int x : gq2) {
			assertEquals(x, expected[i], "for each prints wrong values");
			i++;
		}
	}
	
	@Test
	void descendingIteratorTest() {
		GenericQueue<Integer> gq2 = new GenericQueue<Integer>(1);
		gq2.add(3);
		gq2.add(5);
		gq2.add(7);
		int[] expected = {7, 5, 3, 1};
		int i = 0;
		Iterator<Integer> iter = gq2.descendingIterator();
		while (iter.hasNext()) {
			assertEquals(iter.next(), expected[i], "iterator prints wrong values");
			i++;
		}
	}
	
	@Test
	void listIteratorForwardTest() {
		GenericQueue<Integer> gq2 = new GenericQueue<Integer>(1);
		gq2.add(3);
		gq2.add(5);
		gq2.add(7);
		int[] expected = {1, 3, 5, 7};
		int i = 0;
		ListIterator<Integer> iter = gq2.listIterator(0);
		while (iter.hasNext()) {
			assertEquals(iter.nextIndex(), i);
			assertEquals(iter.next(), expected[i], "iterator prints wrong values");
			i++;
		}
	}
	
	@Test
	void listIteratorReverseTest() {
		GenericQueue<Integer> gq2 = new GenericQueue<Integer>(1);
		gq2.add(3);
		gq2.add(5);
		gq2.add(7);
		int[] expected = {1, 3, 5, 7};
		int i = 3;
		ListIterator<Integer> iter = gq2.listIterator(3);
		while (iter.hasPrevious()) {
			assertEquals(iter.previousIndex(), i);
			assertEquals(iter.previous(), expected[i], "iterator prints wrong values");
			i--;
		}
	}
	
	@Test
	void getTest() {
		GenericQueue<Integer> gq2 = new GenericQueue<Integer>(1);
		gq2.add(3);
		assertEquals(1, gq2.get(0), "get returns wrong val");
		assertEquals(3, gq2.get(1), "get returns wrong val");
	}
	
	@Test
	void setTest() {
		GenericQueue<Integer> gq2 = new GenericQueue<Integer>(1);
		gq2.add(3);
		gq2.add(5);
		gq2.add(7);
		gq2.set(0, 15);
		gq2.set(3, 12);
		assertEquals(15, gq2.get(0), "set changed wrong val");
		assertEquals(12, gq2.get(3), "set changed wrong val");
	}
	
	@Test
	void getLengthTest() {
		GenericQueue<Integer> gq2 = new GenericQueue<Integer>(1);
		assertEquals(1, gq2.getLength(), "getLength() returns wrong val");
	}
	
	@Test
	void getLengthTest2() {
		GenericQueue<Integer> gq2 = new GenericQueue<Integer>(1);
		gq2.add(3);
		gq2.add(5);
		gq2.add(7);
		assertEquals(4, gq2.getLength(), "getLength() returns wrong val");
	}
	
	@Test
	void setLengthTest() {
		GenericQueue<Integer> gq2 = new GenericQueue<Integer>(1);
		gq2.setLength(3);
		assertEquals(3, gq2.getLength(), "setLength() changed to wrong val");
	}
	
	@Test
	void getHeadTest() {
		GenericQueue<Integer> gq2 = new GenericQueue<Integer>(1);
		gq2.add(3);
		gq2.add(5);
		gq2.add(7);
		assertEquals(1, gq2.getHead().data, "getHead() returns wrong val");
	}
	
	@Test
	void setHeadTest() {
		GenericQueue<Integer> gq2 = new GenericQueue<Integer>(1);
		GenericList<Integer>.Node<Integer> test = gq2.new Node<Integer>(3);
		gq2.setHead(test);
		assertEquals(3, gq2.getHead().data, "setHead() changes to wrong val");
	}
	
	@Test
	void dumpListTest() {
		GenericQueue<Integer> gq2 = new GenericQueue<Integer>(1);
		gq2.add(3);
		gq2.add(5);
		gq2.add(7);
		ArrayList<Integer> list = gq2.dumpList();
		int[] expected = {1, 3, 5, 7};
		for (int i = 0; i < 4; i++) {
			assertEquals(expected[i], list.get(i), "dumpList contains wrong vals");
		}
	}
	
	@Test
	void getTailTest() {
		GenericQueue<Integer> gq2 = new GenericQueue<Integer>(1);
		gq2.add(3);
		gq2.add(5);
		gq2.add(7);
		assertEquals(7, gq2.getTail().data, "tail contains wrong val");
	}
}
