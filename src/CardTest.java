// ==============================================================================
// | Daniel Spence
// | Arizona Holdem Project 2
// | tests the simple card class
// ==============================================================================

import static org.junit.Assert.*;

import org.junit.Test;

//Spades: '\u2660'
//Diamonds: '\u2666'
//Clubs: '\u2663'
//Hearts: '\u2764'

public class CardTest {

	@Test
	public void testToString() {
		Card c1 = new Card(Rank.Ace, Suit.Spades);
		
		System.out.println(c1);
		assertEquals(c1.toString(), "A\u2660");
	}

	@Test
	public void testCompareTo() {
		Card c1 = new Card(Rank.Deuce, Suit.Diamonds);
		Card c2 = new Card(Rank.Four, Suit.Spades);
		
		assertTrue(c2.compareTo(c1) > 0);
	}

	@Test
	public void testGetters() {
		Card c1 = new Card(Rank.Three, Suit.Hearts);
		
		assertEquals(Rank.Three, c1.getRank());
		assertEquals(Suit.Hearts, c1.getSuit());
	}

}
