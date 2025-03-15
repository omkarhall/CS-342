import java.util.Iterator;
import java.util.ListIterator;
import java.util.ArrayList;

/*
 * Omkarnath Halleppanawar
 * ohalle2@uic.edu
 */

public class GLProject {

	public static void main(String[] args) {
		/*
		// TODO Auto-generated method stub
		GenericList<Integer> list = new GenericList<Integer>();
		//list.print();
		list.add(1);
		list.add(4);
		list.add(12);
		list.add(7);
		list.add(10);
		list.print();
		*/
		/*
		Iterator<Integer> itr = list.descendingIterator();
		//list.delete();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println();
		//list.delete();
		Iterator<Integer> itr2 = list.iterator();
		//list.delete();
		//list.set(0, 6);
		while (itr2.hasNext()) {
			System.out.println(itr2.next());
		}
		*/
		/*
		int x = list.set(0, 5);
		System.out.println("Old val: " + x);
		list.print();
		System.out.println("Index 0: " + list.get(0));
		
		ArrayList<Integer> a1 = list.dumpList();
		System.out.println(a1.toString());
		list.print();
		*/
		
		//ListIterator<Integer> ltr = list.listIterator(0);
		//System.out.println(ltr.nextIndex());
		/*
		while (ltr.hasNext()) {
			System.out.println(ltr.next());
		}
		System.out.println();
		while (ltr.hasPrevious()) {
			System.out.println(ltr.previous());
		}
		System.out.println();
		*/
		/*
		while (ltr.hasNext()) {
			System.out.println(ltr.next());
		}
		*/
		/*
		System.out.println(ltr.next());
		System.out.println(ltr.next());
		//System.out.println(ltr.previous());
		System.out.println(ltr.previousIndex());
		System.out.println(ltr.previous());
		System.out.println(ltr.nextIndex());
		
		*/
		GenericStack<Integer> gs = new GenericStack<Integer>(3);
		gs.add(4);
		gs.add(5);
		gs.print();
		Integer val = gs.removeTail();
		System.out.println("Old tail: " + val);
		gs.print();
		
	}
}
