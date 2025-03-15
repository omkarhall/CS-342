import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DealerTest {
	
	private static Dealer d;
	private static Character[] suits = {'C', 'D', 'S', 'H'};
	private static Integer[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
	private static ArrayList<Character> expectedSuits;
	private static ArrayList<Integer> expectedValues;
	
	@BeforeAll
	static void setup() {
		d = new Dealer();
		expectedSuits = new ArrayList<Character>();
		Collections.addAll(expectedSuits, suits);
		expectedValues = new ArrayList<Integer>();
		Collections.addAll(expectedValues, values);
	}
	
	// constructor test
	@Test
	void dealerDeckConstructorTest() {
		ArrayList<Character> actualSuits = new ArrayList<Character>();
		ArrayList<Integer> actualValues = new ArrayList<Integer>();
		for (Card c : d.theDeck) {
			actualSuits.add(c.suit);
			actualValues.add(c.value);
		}
		assertTrue(expectedSuits.containsAll(actualSuits), "Dealer's deck contains wrong suits");
		assertTrue(expectedValues.containsAll(actualValues), "Dealer's deck contains wrong values");
	}
	
	// checks if the dealer's hand is initially empty
	@Test
	void dealerInitialEmptyHandTest() {
		assertTrue(d.dealersHand.isEmpty(), "dealer's hand not empty");
	}
	
	// checks if the dealer's initial hand is size 0
	@Test
	void dealerInitialHandIsSizeZeroTest() {
		assertEquals(0, d.dealersHand.size(), "dealer's hand not empty");
	}
	
	// tests if the cards dealt are in the deck
	@Test
	void dealHandTest() {
		ArrayList<Card> testHand = new ArrayList<Card>();
		testHand = d.dealHand();
		
		Deck testDeck = new Deck();
		
		for (Card c : testHand) {
			assertEquals(false, testDeck.indexOf(c) != -1, "card not in the deck");
		}
	}
	
	// tests if the deck has 34 cards or less, then shuffle a new deck and pick 3 cards from the new deck
	@Test
	void deckIsTooSmallTest() {
		for (int i = 0; i < 18; i++) {
			d.theDeck.remove(i);
		}
		
		ArrayList<Card> testHand = new ArrayList<Card>();
		testHand = d.dealHand();
		
		assertEquals(49, d.theDeck.size(), "deck size was not reset before dealing 3 cards");
	}
	
	// tests if the size of the hand is 3
	@Test
	void dealHandSizeTest() {
		ArrayList<Card> testHand = new ArrayList<Card>();
		testHand = d.dealHand();
		assertEquals(3, testHand.size(), "dealer's hand does not have 3 cards");
	}
	
	// tests if the size of the initial deck is 52
	@Test
	void dealDeckSizeTest() {
		d = new Dealer();
		assertEquals(52, d.theDeck.size(), "wrong size");
	}
}
