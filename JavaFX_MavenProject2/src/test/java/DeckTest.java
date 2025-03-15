import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DeckTest {
	
	private static Deck d;
	private static Character[] suits = {'C', 'D', 'S', 'H'};
	private static Integer[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
	private static ArrayList<Character> expectedSuits;
	private static ArrayList<Integer> expectedValues;

	@BeforeAll
	static void setup() {
		d = new Deck();
		expectedSuits = new ArrayList<Character>();
		Collections.addAll(expectedSuits, suits);
		expectedValues = new ArrayList<Integer>();
		Collections.addAll(expectedValues, values);
	}

	@Test
	void testConstructorSize() {
		assertEquals(d.size(), 52, "Deck should have 52 cards");
	}
	
	@Test
	void testConstructorContents() {
		ArrayList<Character> actualSuits = new ArrayList<Character>();
		ArrayList<Integer> actualValues = new ArrayList<Integer>();
		for (Card c : d) {
			actualSuits.add(c.suit);
			actualValues.add(c.value);
		}
		assertTrue(expectedSuits.containsAll(actualSuits), "Deck contains wrong suits");
		assertTrue(expectedValues.containsAll(actualValues), "Deck contains wrong values");
	}
	
	// tests if a new deck can be made
	@Test
	void newDeckTest() {
			
		ArrayList<Integer> actualValues = new ArrayList<Integer>();
		for (Card c : d) {
			actualValues.add(c.value);
		}
			
		d.newDeck();
			
		ArrayList<Integer> newValues = new ArrayList<Integer>();
		for (Card c : d) {
			newValues.add(c.value);
		}
			
		assertFalse(newValues.equals(actualValues), "Contains the same values");
	}
}
