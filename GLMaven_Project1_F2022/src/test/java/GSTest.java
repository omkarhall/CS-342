import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.ArrayList;

public class GSTest {
	private static GenericStack<Integer> gs;
	
	@BeforeAll
	static void setup() {
		gs = new GenericStack<Integer>(5);
	}
	
	@Test
	void nodeConstructorTest() {
		GenericList<Integer>.Node<Integer> test = gs.new Node<Integer>(3);
		assertEquals(3, test.data, "Node should have value of 3");
		assertNull(test.next, "Node.next should be null");
	}
	
	@Test
	void constructorTest() {
		assertEquals(gs.getHead().data, gs.getTail().data, "Head and tail should be same");
		assertEquals(1, gs.getLength(), "Length should be 1");
		assertEquals(5, gs.getHead().data, "Head should be 5");
	}
	
	@Test
	void removeTailTest() {
		Integer val = gs.removeTail();
		assertEquals(5, val, "Old tail should be 5");
		assertNull(gs.getTail(), "Tail should be null");
		assertNull(gs.getHead(), "Head should be null");
		assertEquals(0, gs.getLength(), "Length should be 0");
	}
	
	@Test
	void removeTailTestTwo() {
		GenericStack<Integer> gs2 = new GenericStack<Integer>(5);
		gs2.add(3);
		gs2.add(5);
		gs2.add(7);
		Integer val = gs2.removeTail();
		assertEquals(5, val, "Old tail should be 5");
		assertEquals(3, gs2.getTail().data, "Tail should be 3");
		assertEquals(3, gs2.getLength(), "Length should be 3");
	}
	
	@Test
	void addTest() {
		GenericStack<Integer> gs2 = new GenericStack<Integer>(5);
		gs2.add(3);
		assertEquals(3, gs2.getHead().data, "Head should be 3");
		assertEquals(5, gs2.getTail().data, "Tail should be 5");
		assertEquals(2, gs2.getLength(), "Length should be 2");
		
	}
	
	@Test
	void addTestTwo() {
		GenericStack<Integer> gs2 = new GenericStack<Integer>(5);
		gs2.pop();
		gs2.add(3);
		assertEquals(3, gs2.getHead().data, "Head should be 3");
		assertEquals(3, gs2.getTail().data, "Tail should be 3");
		assertEquals(1, gs2.getLength(), "Length should be 1");
	}
	
	@Test
	void pushTest() {
		GenericStack<Integer> gs2 = new GenericStack<Integer>(5);
		gs2.push(3);
		assertEquals(3, gs2.getHead().data, "Head should be 3");
		assertEquals(5, gs2.getTail().data, "Tail should be 5");
		assertEquals(2, gs2.getLength(), "Length should be 2");
	}
	
	@Test
	void pushTestTwo() {
		GenericStack<Integer> gs2 = new GenericStack<Integer>(5);
		gs2.pop();
		gs2.push(3);
		assertEquals(3, gs2.getHead().data, "Head should be 3");
		assertEquals(3, gs2.getTail().data, "Tail should be 3");
		assertEquals(1, gs2.getLength(), "Length should be 1");
	}
	
	@Test
	void popTest() {
		GenericStack<Integer> gs2 = new GenericStack<Integer>(5);
		Integer val = gs2.pop();
		assertEquals(5, val, "Old head should be 5");
		assertNull(gs2.getTail(), "Tail should be null");
		assertNull(gs2.getHead(), "Head should be null");
		assertEquals(0, gs2.getLength(), "Length should be 0");
	}
	
	@Test
	void popTestTwo() {
		GenericStack<Integer> gs2 = new GenericStack<Integer>(1);
		gs2.add(3);
		gs2.add(5);
		gs2.add(7);
		Integer val = gs2.pop();
		assertEquals(7, val, "Old head should be 7");
		assertEquals(5, gs2.getHead().data, "Head should be 5");
		assertEquals(1, gs2.getTail().data, "Tail should be 1");
		assertEquals(3, gs2.getLength(), "Length should be 3");
	}
	
	@Test
	void forEachTest() {
		GenericStack<Integer> gs2 = new GenericStack<Integer>(1);
		gs2.add(3);
		gs2.add(5);
		gs2.add(7);
		int[] expected = {7, 5, 3, 1};
		int i = 0;
		for(int x : gs2) {
			assertEquals(x, expected[i], "for each prints wrong values");
			i++;
		}
	}
	
	@Test
	void descendingIteratorTest() {
		GenericStack<Integer> gs2 = new GenericStack<Integer>(1);
		gs2.add(3);
		gs2.add(5);
		gs2.add(7);
		int[] expected = {1, 3, 5, 7};
		int i = 0;
		Iterator<Integer> iter = gs2.descendingIterator();
		while (iter.hasNext()) {
			assertEquals(iter.next(), expected[i], "iterator prints wrong values");
			i++;
		}
	}
	
	@Test
	void listIteratorForwardTest() {
		GenericStack<Integer> gs2 = new GenericStack<Integer>(1);
		gs2.add(3);
		gs2.add(5);
		gs2.add(7);
		int[] expected = {7, 5, 3, 1};
		int i = 0;
		ListIterator<Integer> iter = gs2.listIterator(0);
		while (iter.hasNext()) {
			assertEquals(iter.nextIndex(), i);
			assertEquals(iter.next(), expected[i], "iterator prints wrong values");
			i++;
		}
	}
	
	@Test
	void listIteratorReverseTest() {
		GenericStack<Integer> gs2 = new GenericStack<Integer>(1);
		gs2.add(3);
		gs2.add(5);
		gs2.add(7);
		int[] expected = {7, 5, 3, 1};
		int i = 3;
		ListIterator<Integer> iter = gs2.listIterator(3);
		while (iter.hasPrevious()) {
			assertEquals(iter.previousIndex(), i);
			assertEquals(iter.previous(), expected[i], "iterator prints wrong values");
			i--;
		}
	}
	
	@Test
	void getTest() {
		GenericStack<Integer> gs2 = new GenericStack<Integer>(1);
		gs2.add(3);
		assertEquals(3, gs2.get(0), "get returns wrong val");
		assertEquals(1, gs2.get(1), "get returns wrong val");
	}
	
	@Test
	void setTest() {
		GenericStack<Integer> gs2 = new GenericStack<Integer>(1);
		gs2.add(3);
		gs2.add(5);
		gs2.add(7);
		gs2.set(0, 15);
		gs2.set(3, 12);
		assertEquals(15, gs2.get(0), "set changed wrong val");
		assertEquals(12, gs2.get(3), "set changed wrong val");
	}
	
	@Test
	void getLengthTest() {
		GenericStack<Integer> gs2 = new GenericStack<Integer>(1);
		assertEquals(1, gs2.getLength(), "getLength() returns wrong val");
	}
	
	@Test
	void getLengthTest2() {
		GenericStack<Integer> gs2 = new GenericStack<Integer>(1);
		gs2.add(3);
		gs2.add(5);
		gs2.add(7);
		assertEquals(4, gs2.getLength(), "getLength() returns wrong val");
	}
	
	@Test
	void setLengthTest() {
		GenericStack<Integer> gs2 = new GenericStack<Integer>(1);
		gs2.setLength(3);
		assertEquals(3, gs2.getLength(), "setLength() changed to wrong val");
	}
	
	@Test
	void getHeadTest() {
		GenericStack<Integer> gs2 = new GenericStack<Integer>(1);
		gs2.add(3);
		gs2.add(5);
		gs2.add(7);
		assertEquals(7, gs2.getHead().data, "getHead() returns wrong val");
	}
	
	@Test
	void setHeadTest() {
		GenericStack<Integer> gs2 = new GenericStack<Integer>(1);
		GenericList<Integer>.Node<Integer> test = gs2.new Node<Integer>(3);
		gs2.setHead(test);
		assertEquals(3, gs2.getHead().data, "setHead() changes to wrong val");
	}
	
	@Test
	void dumpListTest() {
		GenericStack<Integer> gs2 = new GenericStack<Integer>(1);
		gs2.add(3);
		gs2.add(5);
		gs2.add(7);
		ArrayList<Integer> list = gs2.dumpList();
		int[] expected = {7, 5, 3, 1};
		for (int i = 0; i < 4; i++) {
			assertEquals(expected[i], list.get(i), "dumpList contains wrong vals");
		}
	}
	
	@Test
	void getTailTest() {
		GenericStack<Integer> gs2 = new GenericStack<Integer>(1);
		gs2.add(3);
		gs2.add(5);
		gs2.add(7);
		assertEquals(1, gs2.getTail().data, "tail contains wrong val");
	}
}
