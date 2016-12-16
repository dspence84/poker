// ==============================================================================
// | Daniel Spence
// | Arizona Holdem Project 2
// | Tests the player class
// ==============================================================================

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testBet() {
		Player playerOne = new Player(1, 100.0);
		
		assertEquals(100.0, playerOne.getCashOnHand(),1e-12);
		playerOne.bet(2.0);
		assertEquals(98.0, playerOne.getCashOnHand(),1e-12);
		
		playerOne.collectThePot(5.0);
		
		assertEquals(103.0, playerOne.getCashOnHand(),1e-12);
		}
	
	@Test
	public void testGetters() {
		Card c1 = new Card(Rank.Deuce, Suit.Diamonds);
		Card c2 = new Card(Rank.Five, Suit.Hearts);
		Card c3 = new Card(Rank.Six, Suit.Clubs);
		Player playerOne = new Player(1, 100.0);
		
		List<Card> cards = new ArrayList<Card>();
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		
		playerOne.receiveHand(cards);
		
		assertEquals(100.0, playerOne.getCashOnHand(),1e-12);
		assertEquals(1,playerOne.getPlayerNumber());
				
		cards = playerOne.getPlayerCards();
		
		assertEquals(cards.get(0), c1);
		assertEquals(cards.get(1), c2);	
	}
	
	@Test
	public void testGetBestHand() {
		Card c1 = new Card(Rank.Ten, Suit.Diamonds);
		Card c2 = new Card(Rank.Five, Suit.Hearts);
		Card c3 = new Card(Rank.Jack, Suit.Clubs);
		Card c4 = new Card(Rank.Eight, Suit.Clubs);
		Card c5 = new Card(Rank.Ace, Suit.Spades);
		Card c6 = new Card(Rank.King, Suit.Hearts);
		Card c7 = new Card(Rank.Four, Suit.Diamonds);
		Card c8 = new Card(Rank.Queen, Suit.Spades);
		
		Player player = new Player(1, 50.0);
		
		List<Card> cards = new ArrayList<Card>();
		cards.add(c1); cards.add(c2); cards.add(c3); cards.add(c4);
		cards.add(c5); cards.add(c6); cards.add(c7); cards.add(c8);
		
		player.findBestHand(cards);	
		
		assertEquals(Trick.Straight, player.getBestHand().getTrick());
	}
}
