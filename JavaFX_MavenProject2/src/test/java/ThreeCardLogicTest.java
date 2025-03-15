import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ThreeCardLogicTest {
	
	Player p;
	Dealer d;
	
	@Test
	void evalHandThreeOfAKindTest() {
		ArrayList<Card> testHand = new ArrayList<Card>(); // 3 of a kind
		testHand.add(new Card('D', 12));
		testHand.add(new Card('H', 12));
		testHand.add(new Card('S', 12));
		
		assertEquals(2, ThreeCardLogic.evalHand(testHand), "wrong hand");	
	}
	
	@Test
	void evalHandStraightFlushTest() {
		ArrayList<Card> testHand = new ArrayList<Card>(); // straight flush
		testHand.add(new Card('D', 14));
		testHand.add(new Card('D', 13));
		testHand.add(new Card('D', 12));
		
		assertEquals(1, ThreeCardLogic.evalHand(testHand), "wrong hand");
	}
	
	@Test
	void evalHandFlushTest() {
		ArrayList<Card> testHand = new ArrayList<Card>(); // flush
		testHand.add(new Card('D', 5));
		testHand.add(new Card('D', 13));
		testHand.add(new Card('D', 6));
		
		assertEquals(4, ThreeCardLogic.evalHand(testHand), "wrong hand");
	}
	
	@Test
	void evalHandStraightTest() {
		ArrayList<Card> testHand = new ArrayList<Card>(); // straight
		testHand.add(new Card('D', 8));
		testHand.add(new Card('S', 7));
		testHand.add(new Card('H', 6));
		
		assertEquals(3, ThreeCardLogic.evalHand(testHand), "wrong hand");
	}
	
	@Test
	void evalPairTest() {
		ArrayList<Card> testHand = new ArrayList<Card>(); // pair
		testHand.add(new Card('H', 13));
		testHand.add(new Card('C', 13));
		testHand.add(new Card('S', 8));
		
		assertEquals(5, ThreeCardLogic.evalHand(testHand), "wrong hand");
	}
	
	@Test
	void evalHandHighCardTest() {
		ArrayList<Card> testHand = new ArrayList<Card>(); // high card
		testHand.add(new Card('D', 5));
		testHand.add(new Card('S', 13));
		testHand.add(new Card('C', 6));
		
		assertEquals(0, ThreeCardLogic.evalHand(testHand), "wrong hand");
	}
	
	// test winnings for pair
	@Test
	void evalPPPairTest() {
		ArrayList<Card> testHand = new ArrayList<Card>();
		testHand.add(new Card('H', 13));
		testHand.add(new Card('C', 13));
		testHand.add(new Card('S', 8));
		
		int bet = 5;
		int winnings = ThreeCardLogic.evalPPWinnings(testHand, bet);
		
		assertEquals(10, winnings, "wrong amount won"); // 1 to 1 payout
	}
	
	// test winnings for flush
	@Test
	void evalPPFlushTest() {
		ArrayList<Card> testHand = new ArrayList<Card>(); // flush
		testHand.add(new Card('D', 5));
		testHand.add(new Card('D', 13));
		testHand.add(new Card('D', 6));
		
		int bet = 5;
		int winnings = ThreeCardLogic.evalPPWinnings(testHand, bet);
		
		assertEquals(20, winnings, "wrong amount won"); // 3 to 1 payout
	}
	
	// test winnings for straight
	@Test
	void evalPPStraightTest() {
		ArrayList<Card> testHand = new ArrayList<Card>(); // straight
		testHand.add(new Card('D', 8));
		testHand.add(new Card('S', 7));
		testHand.add(new Card('H', 6));
		
		int bet = 5;
		int winnings = ThreeCardLogic.evalPPWinnings(testHand, bet);
		
		assertEquals(35, winnings, "wrong amount won"); // 6 to 1 payout
	}
	
	// test winnings for 3 of kind
	@Test
	void evalPP3OfaKindTest() {
		ArrayList<Card> testHand = new ArrayList<Card>(); // 3 of a kind
		testHand.add(new Card('D', 12));
		testHand.add(new Card('H', 12));
		testHand.add(new Card('S', 12));
		
		int bet = 5;
		int winnings = ThreeCardLogic.evalPPWinnings(testHand, bet);
		
		assertEquals(155, winnings, "wrong amount won"); // 30 to 1 payout
	}
	
	// test winnings for straight flush
	@Test
	void evalPPStraightFlushTest() {
		ArrayList<Card> testHand = new ArrayList<Card>(); // straight flush
		testHand.add(new Card('D', 14));
		testHand.add(new Card('D', 13));
		testHand.add(new Card('D', 12));
		
		int bet = 5;
		int winnings = ThreeCardLogic.evalPPWinnings(testHand, bet);
		
		assertEquals(205, winnings, "wrong amount won"); // 40 to 1 payout
	}
	
	// test if dealer's hand is greater than the player's hand
	@Test
	void compareHandsDealerGreaterThanPlayerTest() {
		ArrayList<Card> dealerHand = new ArrayList<Card>();
		ArrayList<Card> playerHand = new ArrayList<Card>();
		
		dealerHand.add(new Card('D', 14));
		dealerHand.add(new Card('D', 13));
		dealerHand.add(new Card('D', 12));
		
		playerHand.add(new Card('H', 13));
		playerHand.add(new Card('C', 13));
		playerHand.add(new Card('S', 8));
		
		assertEquals(1, ThreeCardLogic.compareHands(dealerHand, playerHand));
	}
	
	// test if dealer's hand is less than the player's hand
	@Test
	void compareHandsDealerLessThanPlayerTest() {
		ArrayList<Card> dealerHand = new ArrayList<Card>();
		ArrayList<Card> playerHand = new ArrayList<Card>();
		
		playerHand.add(new Card('D', 14));
		playerHand.add(new Card('D', 13));
		playerHand.add(new Card('D', 12));
		
		dealerHand.add(new Card('H', 13));
		dealerHand.add(new Card('C', 13));
		dealerHand.add(new Card('S', 8));
		
		assertEquals(2, ThreeCardLogic.compareHands(dealerHand, playerHand));
	}
	
	// test the same hand first card, dealer wins
	@Test
	void compareHandsDealerEqualsPlayerFirstCardDealerWinsTest() {
		ArrayList<Card> dealerHand = new ArrayList<Card>();
		ArrayList<Card> playerHand = new ArrayList<Card>();
		
		dealerHand.add(new Card('D', 14)); // test with straight flush
		dealerHand.add(new Card('D', 13));
		dealerHand.add(new Card('D', 12));
		
		playerHand.add(new Card('D', 13));
		playerHand.add(new Card('D', 12));
		playerHand.add(new Card('D', 11));
		
		assertEquals(1, ThreeCardLogic.compareHands(dealerHand, playerHand));
	}
	
	// test the same hand first card, player wins
	@Test
	void compareHandsDealerEqualsPlayerFirstCardPlayerWinsTest() {
		ArrayList<Card> dealerHand = new ArrayList<Card>();
		ArrayList<Card> playerHand = new ArrayList<Card>();
		
		playerHand.add(new Card('D', 14)); // test with 3 of a kind
		playerHand.add(new Card('D', 13));
		playerHand.add(new Card('D', 11));
		
		dealerHand.add(new Card('D', 13));
		dealerHand.add(new Card('D', 12));
		dealerHand.add(new Card('D', 10));
		
		assertEquals(2, ThreeCardLogic.compareHands(dealerHand, playerHand));
	}
	
	// test the same hand second card, dealer wins
	@Test
	void compareHandsDealerEqualsPlayerSecondCardDealerWinsTest() {
		ArrayList<Card> dealerHand = new ArrayList<Card>();
		ArrayList<Card> playerHand = new ArrayList<Card>();
		
		dealerHand.add(new Card('D', 14)); // test with 3 of a kind
		dealerHand.add(new Card('D', 13));
		dealerHand.add(new Card('D', 12));
		
		playerHand.add(new Card('D', 14));
		playerHand.add(new Card('D', 12));
		playerHand.add(new Card('D', 11));
		
		assertEquals(1, ThreeCardLogic.compareHands(dealerHand, playerHand));
	}
	
	// test the same hand second card, player wins
	@Test
	void compareHandsDealerEqualsPlayerSecondCardPlayerWinsTest() {
		ArrayList<Card> dealerHand = new ArrayList<Card>();
		ArrayList<Card> playerHand = new ArrayList<Card>();
		
		playerHand.add(new Card('D', 14)); // test with 3 of a kind
		playerHand.add(new Card('D', 13));
		playerHand.add(new Card('D', 11));
		
		dealerHand.add(new Card('D', 14));
		dealerHand.add(new Card('D', 12));
		dealerHand.add(new Card('D', 10));
		
		assertEquals(2, ThreeCardLogic.compareHands(dealerHand, playerHand));
	}
	
	// test the same hand third card, dealer wins
	@Test
	void compareHandsDealerEqualsPlayerThirdCardDealerWinsTest() {
		ArrayList<Card> dealerHand = new ArrayList<Card>();
		ArrayList<Card> playerHand = new ArrayList<Card>();
		
		dealerHand.add(new Card('D', 14)); // test with 3 of a kind
		dealerHand.add(new Card('D', 13));
		dealerHand.add(new Card('D', 11));
		
		playerHand.add(new Card('D', 14));
		playerHand.add(new Card('D', 13));
		playerHand.add(new Card('D', 10));
		
		assertEquals(1, ThreeCardLogic.compareHands(dealerHand, playerHand));
	}
	
	// test the same hand third card, player wins
	@Test
	void compareHandsDealerEqualsPlayerThirdCardPlayerWinsTest() {
		ArrayList<Card> dealerHand = new ArrayList<Card>();
		ArrayList<Card> playerHand = new ArrayList<Card>();
		
		playerHand.add(new Card('D', 14)); // test with 3 of a kind
		playerHand.add(new Card('D', 13));
		playerHand.add(new Card('D', 11));
		
		dealerHand.add(new Card('D', 14));
		dealerHand.add(new Card('D', 13));
		dealerHand.add(new Card('D', 10));
		
		assertEquals(2, ThreeCardLogic.compareHands(dealerHand, playerHand));
	}
	
	// test the exact same hand for both player and dealer
	@Test
	void compareHandsTieTest() {
		ArrayList<Card> dealerHand = new ArrayList<Card>();
		ArrayList<Card> playerHand = new ArrayList<Card>();
		
		dealerHand.add(new Card('D', 14)); // test with straight flush
		dealerHand.add(new Card('D', 13));
		dealerHand.add(new Card('D', 12));
		
		playerHand.add(new Card('D', 14));
		playerHand.add(new Card('D', 13));
		playerHand.add(new Card('D', 12));
		
		assertEquals(0, ThreeCardLogic.compareHands(dealerHand, playerHand));
	}
}
